/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author AtienzaEzequiel
 */
public class NodoAVL {

    private Object elemento;
    private NodoAVL hijoIzq;
    private NodoAVL hijoDer;
    private int altura;

    public NodoAVL() {
        this.elemento=null;
        this.hijoDer=null;
        this.hijoIzq=null;
        this.altura=-1;
    }

    public NodoAVL(Object elemento,int alt) {
        this.elemento = elemento;
        this.altura = alt;
    }

    public NodoAVL(Object elemento) {
        this.elemento = elemento;
        this.altura = 0;
    }
    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoAVL getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAVL hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAVL getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAVL hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
