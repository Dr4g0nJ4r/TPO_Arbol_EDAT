public class ArbolGen {

    NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean esVacio() {

        boolean rta = false;

        if (this.raiz == null) {
            rta = true;

        }
        return rta;
    }

    public boolean insertar(Object elem, Object padre) {

        boolean rta = false;
        NodoGen nodoPadre;

        if (this.esVacio()) {
            this.raiz = new NodoGen(elem);
            rta = true;
        } else {
            nodoPadre = buscarNodo(padre, this.raiz);
            if (nodoPadre != null) {
                if (nodoPadre.getIzq() == null) {
                    nodoPadre.setIzq(new NodoGen(elem));
                    rta = true;
                } else {
                    NodoGen aux = nodoPadre.getIzq();

                    while (aux.getDer() != null) {
                        aux = aux.getDer();
                    }

                    aux.setDer(new NodoGen(elem));
                    rta = true;

                }
            }
        }

        return rta;
    }

    private NodoGen buscarNodo(Object elem, NodoGen nodo) {

        NodoGen rta = null;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                rta = nodo;
            } else {

                NodoGen aux = nodo.getIzq();

                while (aux != null && rta == null) {
                    rta = buscarNodo(elem, aux);
                    aux.getDer();
                }

            }
        }

        return rta;
    }

    public boolean pertenece(Object elem) {

        boolean rta = false;

        if (buscarNodo(elem, this.raiz) != null) {
            rta = true;
        }

        return rta;

    }

    public Object padre(Object elem) {

        Object rta = null;
        NodoGen aux;

        if (!this.esVacio()) {

            aux = buscarPadre(elem, this.raiz);
            if (aux != null) {
                rta = aux.getElem();
            }
        }

        return rta;

    }

    private NodoGen buscarPadre(Object elem, NodoGen nodo) {

        NodoGen rta = null;

        if (nodo != null) {

            if (nodo.getIzq() != null) {               //compruebo si el izquierdo posee el elemento
                if (nodo.getIzq().getElem().equals(elem)) {
                    rta = nodo;                    // si lo posee guardo en nodo actual y lo devuelvo
                }                                           // compruebo si hay hijo izq.

            }      // si existe lo envio recursivamente.
            if (rta == null) {
                rta = buscarPadre(elem,nodo.getIzq());
                while (nodo.getDer() != null && rta == null) { //si no, itero a traves de los hijos derechos mientras exitan
                    rta = buscarPadre(elem,nodo.getDer());
                }
            }

        }

        return rta;
    }
}