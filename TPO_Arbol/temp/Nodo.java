/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kolia
 */
public class Nodo {
    
    private Object  elem;
    private Nodo enlace;
    
    public Nodo(){
    
    this.elem=null;
    this.enlace=null;
    }
            
    public Nodo(Object elemento, Nodo enlac){
    
    this.elem = elemento;
    this.enlace = enlac;
    
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    
    
}
