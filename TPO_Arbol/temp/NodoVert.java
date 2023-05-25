

public class NodoVert<Object> {
	private Object elem;
	private NodoVert<Object> sigVertice;
	private NodoAdy primerAdy;

	public NodoVert() {
		this.elem = null;
		this.sigVertice = null;
		this.primerAdy = null;
	}

	public NodoVert(Object elem, NodoVert<Object> vert) {
		this.elem = elem;
		this.sigVertice = vert;
	}

	public Object getElem() {
		return this.elem;
	}

	public void setElem(Object nuevoElem) {
		this.elem = nuevoElem;
	}

	public NodoVert<Object> getSigVertice() {
		return this.sigVertice;
	}

	public void setSigVertice(NodoVert<Object> nodV) {
		this.sigVertice = nodV;
	}

	public NodoAdy getPrimerAdy() {
		return this.primerAdy;
	}

	public void setPrimerAdy(NodoAdy nodA) {
		this.primerAdy = nodA;
	}

}
