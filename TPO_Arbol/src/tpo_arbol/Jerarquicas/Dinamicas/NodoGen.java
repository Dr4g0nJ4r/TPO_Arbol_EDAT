package tpo_arbol.Jerarquicas.Dinamicas;

/**Estructura básica del Árbol Genérico. Contiene:
 * 
 *  - un elemento
 *  - un enlace al nodo hijo situado más a la izquierda
 *  - un enlace al nodo hermano
 */
public class NodoGen {
    private Object elemento;
    private NodoGen hijoIzquierdo;
    private NodoGen hermano;

    /** Constructor. Retorna una instancia de NodoGen con el elemento pasado por parámetro y sin enlaces */
    public NodoGen(Object elem)
    {
        this.elemento = elem;
        this.hijoIzquierdo = null;
        this.hermano = null;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoGen getHermano() {
        return this.hermano;
    }

    public void setHermano(NodoGen hermano) {
        this.hermano = hermano;
    }

}