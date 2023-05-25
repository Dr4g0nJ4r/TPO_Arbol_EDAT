/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kolia
 */
public class NodoDiccAVL {

    Comparable clave;
    Object dato;
    int altura;
    int balance;
    NodoDiccAVL nodoIzq;
    NodoDiccAVL nodoDer;

    public NodoDiccAVL(Comparable clave, Object dato) {
        this.clave = clave;
        this.dato = dato;
    }

    public NodoDiccAVL() {
        this.altura = 0;
        this.nodoIzq = null;
        this.nodoDer = null;
    }

    public int getBalance() {
        return balance;
    }
    
    

    public Comparable getClave() {
        return clave;
    }

    public void setClave(Comparable clave) {
        this.clave = clave;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public int getAltura() {
        return altura;
    }
//------------------------------------------------------------------------------
    public void recalAltura() {

        if (this.nodoIzq != null) {
            if (this.nodoDer != null) {
                altura = 1 + Math.max(this.getNodoDer().getAltura(), this.getNodoIzq().getAltura());
                balance= this.getNodoIzq().getAltura()-this.getNodoDer().getAltura();
            } else {
                altura = 1 + this.getNodoIzq().getAltura();
                balance= this.getNodoIzq().getAltura()-(-1);
            }
        } else {
            if (this.nodoDer != null) {
                altura = 1 + this.getNodoDer().getAltura();
                balance = -1 - this.getNodoDer().getAltura();
            } else {
                if (this.nodoDer == null) {
                    altura = 0;
                    balance=-1;
                }
            }
        }

    }
//------------------------------------------------------------------------------
    public NodoDiccAVL getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoDiccAVL nodoIzq) {
        this.nodoIzq = nodoIzq;
        if (nodoIzq != null) {

            nodoIzq.recalAltura();

        }
        this.recalAltura();
    }

    public NodoDiccAVL getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoDiccAVL nodoDer) {
        this.nodoDer = nodoDer;
        
        if (nodoDer !=null) {
            
            nodoDer.recalAltura();
        }
        
        this.recalAltura();
    }

}
