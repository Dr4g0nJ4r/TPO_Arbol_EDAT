/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Kolia
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public Lista listar() {

        Lista rta = new Lista();

        return listarAux(rta, this.raiz);
    }

    private Lista listarAux(Lista l, NodoAVL aux) {
        if (aux != null) {

            if (aux.getHijoIzq() != null) {
                l = listarAux(l, aux.getHijoIzq());
            }
            l.insertar(aux.getElemento(), l.getLongitud() + 1);
            if (aux.getHijoDer() != null) {
                l = listarAux(l, aux.getHijoDer());
            }
        }
        return l;
    }

    public boolean eliminar(Object elem) {

        boolean estado = false;
        if (pertenece(elem)) {
            if (this.raiz != null) {
                if (this.raiz.getElemento() == elem && this.raiz.getHijoIzq() == null
                        && this.raiz.getHijoDer() == null) {
                    this.raiz.setElemento(null);
                } else {
                    this.raiz = eliminarAux(elem, this.raiz, estado);
                }
               estado = true;
            }
        }
         return estado;
    }

    private NodoAVL eliminarAux(Object buscado, NodoAVL nodo, boolean estado) {
        if (nodo != null) {
            if (nodo.getElemento().compareTo(buscado) == 0) {
                estado = true;
                // CASO ES HOJA
                if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
                    nodo = null;
                    this.modificarAltura(this.raiz);
                } else {
                    // CASO TIENE UN HIJO SOLO
                    if ((nodo.getHijoIzq() != null && nodo.getHijoDer() == null)
                            || (nodo.getHijoIzq() == null && nodo.getHijoDer() != null)) {
                        nodo = caso_2(nodo, buscado);
                        this.modificarAltura(this.raiz);
                    } else {
                        // CASO QUE TENGA LOS 2 HIJOS
                        if (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
                            nodo = caso_3(nodo, buscado);
                            this.modificarAltura(this.raiz);
                        }
                    }
                }
            } else {
                if (nodo.getHijoIzq() != null) {// elimine los nodo de retorno
                    nodo.setHijoIzq(eliminarAux(buscado, nodo.getHijoIzq(), estado));
                }
                if (nodo.getHijoDer() != null) {
                    nodo.setHijoDer(eliminarAux(buscado, nodo.getHijoDer(), estado));
                }
            }
        }
        this.modificarAltura(this.raiz);
        nodo = this.balancear(nodo);
        return nodo;
    }

    public boolean pertenece(Object elem) {
        boolean estado = false;
        if (elem != null) {
            
            estado = perteneceAux(false, this.raiz, elem);

        }
        return estado;
    }

    private boolean perteneceAux(boolean estado, NodoAVL aux, Object elem) {
        if (aux != null) {
            if (aux.getElemento().compareTo(elem) == 0) {
                estado = true;
            } else {
                if (aux.getHijoIzq() != null) {
                    estado = perteneceAux(estado, aux.getHijoIzq(), elem);
                }
                if (aux.getHijoDer() != null && !(estado)) {
                    estado = perteneceAux(estado, aux.getHijoDer(), elem);
                }
            }
        }
        return estado;
    }

    public boolean insertar(Object elem) {
        boolean rta = true;
        NodoAVL n = new NodoAVL();
        System.out.println("Ingresa el valor " + elem);
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elem);
            this.raiz.setAltura(0);
        } else {
            this.raiz = insertarAux(rta, elem, this.raiz);
        }

        return rta;
    }

    private NodoAVL insertarAux(boolean rta, Object elem, NodoAVL nodo) {
        NodoAVL aux2;
        if (elem != nodo.getElemento()) {
            if (elem.getPrecio() < nodo.getElemento().getPrecio()) {
                if (nodo.getHijoIzq() != null) {
                    aux2 = insertarAux(rta, elem, nodo.getHijoIzq());
                    nodo.setHijoIzq(aux2);
                    this.modificarAltura(this.raiz);
                } else {
                    nodo.setHijoIzq(new NodoAVL(elem));
                    this.modificarAltura(this.raiz);
                }
            } else {
                if (nodo.getHijoDer() != null) {
                    aux2 = insertarAux(rta, elem, nodo.getHijoDer());
                    nodo.setHijoDer(aux2);
                    this.modificarAltura(this.raiz);
                } else {
                    nodo.setHijoDer(new NodoAVL(elem));
                    this.modificarAltura(this.raiz);
                }
            }
        } else {

            nodo.getElemento().aumentarCantidad();

        }
        nodo = this.balancear(nodo);
        // this.modificarAltura(this.raiz);
        return nodo;
    }

    private boolean modificarAltura(NodoAVL nodo) {
        boolean exito = false;
        if (nodo != null) {
            int alt = altura(nodo, 0, 0);
            nodo.setAltura(alt);
            exito = true;
            if (nodo.getHijoIzq() != null) {
                exito = modificarAltura(nodo.getHijoIzq());
            }
            if (nodo.getHijoDer() != null) {
                exito = modificarAltura(nodo.getHijoDer());
            }
        }
        return exito;
    }

    private NodoAVL balancear(NodoAVL nodo) {
        NodoAVL reemplazado1;
        NodoAVL reemplazado2;
        // int auxOriginal = nodo.getElemento();
        if (nodo != null) {
            System.out.println("Entra a balancear el elemento= " + nodo.getElemento());

            if (this.balance(nodo) == -2) {
                if (this.balance(nodo.getHijoDer()) == 1) {
                    System.out.println("Hago una rotacion doble der - izq en " + nodo.getElemento());
                    NodoAVL hijoDer = nodo.getHijoDer();
                    reemplazado2 = this.rotacionSimpleDer(hijoDer);
                    hijoDer = reemplazado2;
                    nodo.setHijoDer(hijoDer);
                    nodo = this.rotacionSimpleIzq(nodo);
                    // aux = reemplazado1;
                } else {
                    // if()
                    System.out.println("entra en balance hijo derecho <= 0");
                    // if (this.balance(nodo.getHijoDer()) <= 0 ) {
                    System.out.println("Hago una rotacion simple izq en " + nodo.getElemento());
                    nodo = this.rotacionSimpleIzq(nodo);
                    // aux = reemplazado1;
                }
                // this.modificarAltura(this.raiz);
            } else if (this.balance(nodo) == 2) {
                if (this.balance(nodo.getHijoIzq()) == -1) {
                    System.out.println("Hago una rotacion doble izq - der en " + nodo.getElemento());
                    NodoAVL hijoIzq = nodo.getHijoIzq();
                    reemplazado2 = this.rotacionSimpleIzq(hijoIzq);
                    hijoIzq = reemplazado2;
                    nodo.setHijoIzq(hijoIzq);
                    nodo = this.rotacionSimpleDer(nodo);
                    // aux = reemplazado1;
                } else {
                    System.out.println("Entra en balance hijo izquierdo");
                    // if (this.balance(nodo.getHijoIzq()) >= 0) {
                    System.out.println("Hago una rotacion simple der en " + nodo.getElemento());
                    reemplazado1 = this.rotacionSimpleDer(nodo);
                    nodo = reemplazado1;
                }
                // this.modificarAltura(this.raiz);
            }
        }
        // System.out.println(" ---- sale de balancear " + auxOriginal);
        return nodo;
    }

    private int balance(NodoAVL nodo) {
        int bal;
        int AltHI;
        int AltHD;
        if (nodo.getHijoIzq() != null) {
            AltHI = nodo.getHijoIzq().getAltura();
        } else {
            AltHI = -1;
        }
        if (nodo.getHijoDer() != null) {
            AltHD = nodo.getHijoDer().getAltura();
        } else {
            AltHD = -1;
        }
        if (AltHD == -1) {
            bal = AltHI + 1;
        } else {
            bal = AltHI - AltHD;
        }
        return bal;
    }

    private NodoAVL rotacionSimpleDer(NodoAVL nodo) {
        System.out.println("Rotacion Simple Der en " + nodo.getElemento());
        NodoAVL h = nodo.getHijoIzq();
        NodoAVL temp = h.getHijoDer();
        nodo.setHijoIzq(null);
        h.setHijoDer(nodo);
        nodo.setHijoIzq(temp);

        return h;
    }

    private NodoAVL rotacionSimpleIzq(NodoAVL nodo) {
        System.out.println("Rotacion Simple Izq en " + nodo.getElemento());
        NodoAVL h = nodo.getHijoDer();
        NodoAVL temp = h.getHijoIzq();
        nodo.setHijoDer(null);
        h.setHijoIzq(nodo);
        nodo.setHijoDer(temp);

        return h;
    }

    private int altura(NodoAVL nodo, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private NodoAVL buscarPadre(NodoAVL nodo, NodoAVL padre,Object buscado) {
        if (nodo != null) {
            if (nodo.getHijoIzq() != null) {
                if (nodo.getHijoIzq().getElemento().compareTo(buscado) == 0) {
                    padre = nodo;
                } else {
                    padre = buscarPadre(nodo.getHijoIzq(), padre, buscado);
                }
            }
            if (padre == null && nodo.getHijoDer() != null) {
                if (nodo.getHijoDer().getElemento().compareTo(buscado) == 0) {
                    padre = nodo;
                } else {
                    padre = buscarPadre(nodo.getHijoDer(), padre, buscado);
                }
            }
        }
        return padre;
    }

    private NodoAVL caso_2(NodoAVL nodo, Object buscado) {
        System.out.println("REALIZANDO CASO 2 en " + nodo.getElemento());
        if (nodo != null) {
            if (nodo.getHijoIzq() != null) {
                nodo = nodo.getHijoIzq();
            } else {
                nodo = nodo.getHijoDer();
            }
        }

        return nodo;
    }

    private NodoAVL caso_3(NodoAVL nodo, Object buscado) {
        System.out.println("REALIZANDO CASO 3 en " + nodo.getElemento());
        if (nodo.getElemento() == buscado) {
            // YO ELEGI EL ELEMENTO MAXIMO DEL SUBARBOL DERECHO
        Object c2 = candidato2(nodo.getHijoDer());
            eliminarAux(c2, this.raiz, false);
            nodo.setElemento(c2);
            this.modificarAltura(this.raiz);
        }
        return nodo;
    }

    private Object candidato1(NodoAVL aux) {
        while (aux.getHijoDer() != null) {
            aux = aux.getHijoDer();
        }
        return aux.getElemento();
    }

    private Object candidato2(NodoAVL nodo) {
        while (nodo.getHijoDer() != null) {
            nodo = nodo.getHijoDer();
        }
        return nodo.getElemento();
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoAVL n) {
        String s = "";
        if (n != null) {
            s = "(" + n.getAltura() + ") " + n.getElemento();
            if (n.getHijoIzq() != null) {
                s += "  izq: " + n.getHijoIzq().getElemento();
            }
            if (n.getHijoDer() != null) {
                s += "  der: " + n.getHijoDer().getElemento();
            }

            s += "\n";
            s += toStringAux(n.getHijoIzq());
            s += toStringAux(n.getHijoDer());
        }
        return s;
    }

}
