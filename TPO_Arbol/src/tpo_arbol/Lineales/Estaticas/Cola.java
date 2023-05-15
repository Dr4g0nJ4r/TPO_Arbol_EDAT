package tpo_arbol.Lineales.Estaticas;

public class Cola {

    //Cola estatica con arreglo de tamaño fijo definido por el usuario.

    private static int TAM = 10;
    private Object[] arreglo;
    private int frente;
    private int fin;

    public Cola() {
        this.arreglo = new Object[TAM];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean esVacia() {
        boolean rta = false;

        if (this.frente == this.fin) {
            rta = true;
        }
        return rta;
    }

    public boolean poner(Object elem) {
        boolean rta = false;

        if (this.frente != (this.fin +1)%TAM) {

            this.arreglo[fin] = elem;
            rta = true;
            this.fin = (this.fin + 1) % this.TAM;
        }

        return rta;
    }

    public boolean sacar() {

        boolean rta = false;

        if (!this.esVacia()) {

            this.frente = (this.frente + 1) % this.TAM;
            rta = true;
        }
        return rta;
    }

    public Object obtenerFrente(){
    
        Object rta=null;
        if (!this.esVacia()) {
        rta= this.arreglo[this.frente];    
        }
        
        
     return rta;
    
    }
    
    public void vaciar () {
    
    this.arreglo= new Object[this.TAM];
    this.frente=0;
    this.fin=0;
    
    }
    
    @Override
    public Cola clone(){
    
    Cola rta = new Cola();
    
    
        for (int i = 0; i < TAM-1; i++) {
            rta.arreglo[i]=this.arreglo[i];
        }
        rta.frente=this.frente;
        rta.fin=this.fin;
    
    return rta;
    }
    
    @Override
    public String toString(){
    
        String rta="";
    
        int i=frente;
        while(i!=fin){
            rta += "| " + arreglo[i] + " |";
            i=(i+1)%TAM;//vuelve a la posicion 0 con el '%TAM'
        }
        
        
        return rta;
        }

}