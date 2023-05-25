/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kolia
 */
public class DiccAVL {

    NodoDiccAVL raiz;

    public boolean insertar(Comparable clave, Object dato) {
        boolean rta = true;

        if (this.raiz == null) {

            this.raiz = new NodoDiccAVL(clave, dato);

        } else {

            rta = recInsertar(this.raiz, clave, dato);
        }

        return rta;
    }

    private boolean recInsertar(NodoDiccAVL nodo, Comparable clave, Object dato) {
        boolean rta = false;

        if (clave.compareTo(nodo.getClave()) < 0) {
            if (nodo.getNodoIzq() == null) {
                nodo.setNodoIzq(new NodoDiccAVL(clave, dato));
                rta = true;
            } else {
                rta = recInsertar(nodo.getNodoIzq(), clave, dato);
            }
        } else {
            if (clave.compareTo(nodo.getClave()) > 0) {
                if (nodo.getNodoDer() == null) {
                    nodo.setNodoDer(new NodoDiccAVL(clave, dato));
                    rta = true;
                } else {
                    rta = recInsertar(nodo.getNodoDer(), clave, dato);
                }

            }
        }
        nodo.recalAltura();
        this.balancearArbol(nodo);
        return rta;
    }

    public boolean eliminar(Comparable clave) {
        boolean rta = false;

        if (this.raiz != null) {

            if (this.raiz.getClave().compareTo(clave) == 0) {

                if (this.raiz.getAltura() == 0) {

                    this.raiz = null;

                } else {

                    if (this.raiz.getNodoDer() != null
                            && this.raiz.getNodoIzq() == null) {

                        this.raiz = this.raiz.getNodoDer();

                    } else {

                        if (this.raiz.getNodoIzq() != null
                                && this.raiz.getNodoDer() == null) {

                            this.raiz = this.raiz.getNodoIzq();

                        } else {

                            eliminarCaso3(this.raiz);

                        }
                    }

                    this.raiz.recalAltura();
                    balancearArbol(this.raiz);
                }
            } else {

                //si no es raiz voy a eliminarAux
                if (clave.compareTo(this.raiz.getClave()) < 0) {

                    rta = eliminarAux(this.raiz.getNodoIzq(), clave, this.raiz);

                } else {

                    rta = eliminarAux(this.raiz.getNodoDer(), clave, this.raiz);
                }

            }
        }

        return rta;
    }

    private boolean eliminarAux(NodoDiccAVL nodo, Comparable clave, NodoDiccAVL padre) {
        boolean rta = false;

        if (nodo.getClave().compareTo(clave) == 0) {

            if (nodo.getAltura() == 0) {

                if (padre.getNodoDer().getClave().compareTo(clave) == 0) {

                    padre.setNodoDer(null);

                } else {

                    padre.setNodoIzq(null);

                }

            } else { //caso dos tiene un hijo izquiero o derecho
                NodoDiccAVL hijoDer = nodo.getNodoDer();
                NodoDiccAVL hijoIzq = nodo.getNodoIzq();// casoa hijo izquierdo y derecho del padre
                if (hijoDer != null ^ hijoIzq != null) {
                    if (padre.getNodoDer().equals(nodo)) {
                        if (nodo.getNodoDer() != null) {
                            padre.setNodoDer(nodo.getNodoDer());
                        } else {
                            if (nodo.getNodoIzq() != null) {
                                padre.setNodoDer(nodo.getNodoIzq());
                            }
                        }
                    } else {
                        if (nodo.getNodoDer() != null) {
                            padre.setNodoIzq(nodo.getNodoDer());
                        } else {
                            if (nodo.getNodoIzq() != null) {
                                padre.setNodoIzq(nodo.getNodoIzq());
                            }
                        }
                    }
                } else {// caso 3 debo elegir el maximo de los menores osea sub arbol izquierdo
                    eliminarCaso3(nodo);
                }
            }
            rta = true;
        } else {// mientras no sea el nodo buscado recursivamente lo busco
            // si es mayor voy a la derecha de lo contrario a izquierda
            if (nodo.getClave().compareTo(clave) < 0) {
                //si hay derecho me llamo con hijo derecho.
                if (nodo.getNodoDer() != null) {
                    rta = this.eliminarAux(nodo.getNodoDer(), clave, nodo);
                }
            } else {
                //sino si hay izquierdo me llamo con el hijo izquierdo
                if (nodo.getNodoIzq() != null) {
                    rta = this.eliminarAux(nodo.getNodoIzq(), clave, nodo);
                }
            }
        }
        nodo.recalAltura();
        this.balancearArbol(nodo);
        return rta;
    }

    public boolean existeClave(Comparable clave) {
        return false;
    }

    public Object obtenerDato(Comparable clave) {
        Object dato = null;
        NodoDiccAVL aux = obtenerDatoAux(this.raiz, clave);

        if (aux != null) {
            dato = aux.getDato();
        }

        return dato;
    }

    private NodoDiccAVL obtenerDatoAux(NodoDiccAVL nodo, Comparable clave) {

        NodoDiccAVL aux = null;

        if ((nodo != null) && aux == null) {

            if (clave.compareTo(nodo.getClave()) == 0) {
                aux = nodo;

            } else {

                if (clave.compareTo(nodo.getClave()) < 0) {
                    aux = obtenerDatoAux(nodo.getNodoIzq(), clave);

                } else {

                    if (clave.compareTo(nodo.getClave()) > 0) {
                        aux = obtenerDatoAux(nodo.getNodoDer(), clave);
                    }

                }

            }
        }
        return aux;
    }



    public boolean pertenece(Comparable clave) {

        return perteneceAux(this.raiz, clave);
    }

    private boolean perteneceAux(NodoDiccAVL nodo, Comparable clave) {
        boolean pertenece = false;
        if (nodo != null) {
            //Si no es null voy recorriendo el arbol
            if (clave.compareTo(nodo.getClave()) < 0) {
                //Es menor me voy por la izquierda
                pertenece = perteneceAux(nodo.getNodoIzq(), clave);
            } else {
                if (clave.compareTo(nodo.getClave()) > 0) {
                    //Es mayor me voy por la derecha
                    pertenece = perteneceAux(nodo.getNodoDer(), clave);
                } else {
                    //Son iguales entonces pertenece
                    pertenece = true;
                }
            }
        }
        return pertenece;
    }

    public boolean modificarClaveNodo(Comparable claveModif, Comparable claveNueva) {
        boolean exito = true;
        if (pertenece(claveNueva)) {
            exito = false;
        } else {
            NodoDiccAVL n = obtenerNodo(this.raiz, claveModif);
            n.setClave(claveNueva);
        }
        return exito;
    }

    private NodoDiccAVL obtenerNodo(NodoDiccAVL n, Comparable clave) {
        NodoDiccAVL nuevo = null;
        if (n != null) {
            if (n.getClave().compareTo(clave) == 0) {
                nuevo = n;
            } else {
                if (n.getClave().compareTo(clave) > 0) {
                    nuevo = obtenerNodo(n.getNodoIzq(), clave);
                } else {
                    nuevo = obtenerNodo(n.getNodoDer(), clave);
                }
            }
        }
        return nuevo;
    }

    public Lista listarDatos() {
        Lista nLista = new Lista();
        listarAux3(raiz, nLista);
        return nLista;
    }

    private void listarAux3(NodoDiccAVL n, Lista nLista) {
        if (n != null) {
            listarAux3(n.getNodoIzq(), nLista);
            nLista.insertar(n.getDato(), nLista.getLongitud() + 1);
            listarAux3(n.getNodoDer(), nLista);
        }
    }

    

    private void balancearArbol(NodoDiccAVL nodo) {
        NodoDiccAVL padre = obtenerPadre(this.raiz, nodo.getClave());
        int balanceN = calcularBalance(nodo), caidoIzquierda = 2, caidoDerecha = -2;

        if (balanceN == caidoIzquierda) {
            /* arbol caido a la izquierda */
            if ((calcularBalance(nodo.getNodoIzq())) == -1) {
                /* rotacion doble izq ---> derecha */
                //System.out.println("Rotacion doble izq derecha");
                rotacionDobleIzquierdaDerecha(nodo, padre);
            } else {
                /* rotacion simple a derecha */
                //System.out.println("Rotacion simple a derecha");
                if (nodo == this.raiz) {
                    this.raiz = rotacionSimpleDerecha(nodo);
                    this.raiz.recalAltura();
                } else {
                    NodoDiccAVL nuevaRaiz = rotacionSimpleDerecha(nodo);
                    if (padre.getNodoIzq() == nodo) {
                        padre.setNodoIzq(nuevaRaiz);
                    } else {
                        padre.setNodoDer(nuevaRaiz);

                    }
                }
            }
        } else {
            if (balanceN == caidoDerecha) {
                /* arbol caido a la derecha */
                if (calcularBalance(nodo.getNodoDer()) == 1) {
                    /* rotacion doble derecha izquierda */
                    //System.out.println("rotacion doble derecha izquierda");
                    rotacionDobleDerechaIzquierda(nodo, padre);
                } else {
                    /* rotacion simple a izquierda */
                    //System.out.println("Rotacion simple a izq");
                    if (nodo == this.raiz) {
                        this.raiz = rotacionSimpleIzquierda(nodo);
                        this.raiz.recalAltura();
                    } else {
                        NodoDiccAVL nuevaRaiz = rotacionSimpleIzquierda(nodo);
                        if (padre.getNodoIzq() == nodo) {
                            padre.setNodoIzq(nuevaRaiz);
                        } else {
                            padre.setNodoDer(nuevaRaiz);

                        }
                    }
                }
            }
        }
        nodo.recalAltura();
    }

    private int calcularBalance(NodoDiccAVL nodo) {
        //Metodo que permite obtener el balance de un nodo
        int altIzq, altDer;
        //Si el izquierdo es null
        if (nodo.getNodoIzq() == null) {
            //Es null entonces altIzq es -1
            altIzq = -1;
        } else {
            //No es null entonces obtengo la altura del nodo izquierdo
            altIzq = nodo.getNodoIzq().getAltura();
        }
        //Si el derecho es null
        if (nodo.getNodoDer() == null) {
            //Es null entonces altDer es -1
            altDer = -1;
        } else {
            //No es null entones obtengo la altura del nodo derecho
            altDer = nodo.getNodoDer().getAltura();
        }
        //Retorna altura
        return (altIzq - altDer);
    }
    private void eliminarCaso3(NodoDiccAVL nodo) {
        NodoDiccAVL aux;
        //Verifico si el hijo izquierdo del que deseo eliminar tiene sub-arbol derecho.
        if (nodo.getNodoIzq().getNodoDer() != null) {
            aux = eliminarCaso3aux(nodo.getNodoIzq(), nodo);
        } else {
            aux = nodo.getNodoIzq();
            nodo.setNodoIzq(aux.getNodoIzq());
        }
        nodo.setClave(aux.getClave());
        nodo.setDato(aux.getDato());
        nodo.recalAltura();
    }

    private NodoDiccAVL eliminarCaso3aux(NodoDiccAVL nodo, NodoDiccAVL padre) {
        NodoDiccAVL rta = null;
        if (nodo.getNodoDer() == null) {
            rta = nodo;
            padre.setNodoDer(nodo.getNodoIzq());
        } else {
            rta = eliminarCaso3aux(nodo.getNodoDer(), nodo);
            nodo.recalAltura();//agregue por las dudas
            balancearArbol(nodo);
        }
        return rta;
    }

    private NodoDiccAVL obtenerPadre(NodoDiccAVL nodo, Comparable clave) {
        NodoDiccAVL padre = null;

        if (nodo != null) {
            //lo encontre en el izquierdo o derecho inmediato
            if ((nodo.getNodoIzq() != null && nodo.getNodoIzq().getClave().compareTo(clave) == 0)
                    || (nodo.getNodoDer() != null && nodo.getNodoDer().getClave().compareTo(clave) == 0)) {
                padre = nodo;
            } else {
                // si es 1 debo ir a la izquierda a buscarlo
                if (nodo.getClave().compareTo(clave) > 0) {
                    padre = obtenerPadre(nodo.getNodoIzq(), clave);
                } else {//sino a derecha
                    padre = obtenerPadre(nodo.getNodoDer(), clave);

                }
            }

        }
        return padre;
    }

    private void rotacionDobleIzquierdaDerecha(NodoDiccAVL nodo, NodoDiccAVL padre) {
        nodo.setNodoIzq(rotacionSimpleIzquierda(nodo.getNodoIzq()));
        if (nodo == this.raiz) {
            this.raiz = rotacionSimpleDerecha(nodo);
        } else {
            NodoDiccAVL nuevaRaiz = rotacionSimpleDerecha(nodo);
            if (padre.getNodoIzq() == nodo) {
                padre.setNodoIzq(nuevaRaiz);
            } else {
                padre.setNodoDer(nuevaRaiz);
            }
            padre.recalAltura();
        }
        nodo.recalAltura();

    }

    private NodoDiccAVL rotacionSimpleDerecha(NodoDiccAVL pivote) {
        NodoDiccAVL h, temp;
        h = pivote.getNodoIzq();
        temp = h.getNodoDer();
        h.setNodoDer(pivote);
        pivote.setNodoIzq(temp);
        pivote.recalAltura();
        h.recalAltura();
        return h;
    }

    private void rotacionDobleDerechaIzquierda(NodoDiccAVL nodo, NodoDiccAVL padre) {
        nodo.setNodoDer(rotacionSimpleDerecha(nodo.getNodoDer()));
        if (nodo == this.raiz) {
            this.raiz = rotacionSimpleIzquierda(nodo);
        } else {
            NodoDiccAVL nuevaRaiz = rotacionSimpleIzquierda(nodo);
            if (padre.getNodoIzq() == nodo) {
                padre.setNodoIzq(nuevaRaiz);
            } else {
                padre.setNodoDer(nuevaRaiz);
            }
            padre.recalAltura();
        }
        nodo.recalAltura();

    }

    private NodoDiccAVL rotacionSimpleIzquierda(NodoDiccAVL pivote) {
        NodoDiccAVL h, temp;
        h = pivote.getNodoDer();
        temp = h.getNodoIzq();
        h.setNodoIzq(pivote);
        pivote.setNodoDer(temp);
        pivote.recalAltura();
        h.recalAltura();
        return h;
    }

}
