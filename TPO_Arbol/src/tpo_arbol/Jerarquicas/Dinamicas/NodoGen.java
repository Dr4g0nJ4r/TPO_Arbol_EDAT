
package tpo_arbol.Jerarquicas.Dinamicas;

public class NodoGen {

    private Object elem;
    private NodoGen izq;
    private NodoGen der;

    public NodoGen() {
       
        this.elem = null;
        this.izq = null;
        this.der = null;

    }

    public NodoGen(Object elem) {
        this.elem = elem;
        this.izq = null;
        this.der = null;
    }

    public NodoGen(Object elem, NodoGen izq, NodoGen der) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoGen getIzq() {
        return izq;
    }

    public void setIzq(NodoGen izq) {
        this.izq = izq;
    }

    public NodoGen getDer() {
        return der;
    }

    public void setDer(NodoGen der) {
        this.der = der;
    }