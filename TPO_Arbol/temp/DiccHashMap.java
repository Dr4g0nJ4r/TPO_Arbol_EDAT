/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Kolia
 */
public class DiccHashMap {

    HashMap<Integer, Object> hashMap;
    int cant;

    public DiccHashMap() {
        this.hashMap = new HashMap<Integer, Object>();
        this.cant = 0;
    }

    public boolean insertar(Object equipo) {

        Object rta = this.hashMap.putIfAbsent(equipo.hashCode(), equipo);

        return (rta != null);
    }

    public boolean eliminar(Integer clave) {

        Object rta = this.hashMap.remove(clave);

        return (rta != null);
    }

    public Object obtenerDato(Integer clave) {

        return this.hashMap.get(clave);

    }

    public boolean existeClave(Integer clave) {

        return this.hashMap.containsKey(clave);
    }
    
   public Lista listarEquipos(){
    
        Lista rta = new Lista();
        
        this.hashMap.forEach((Integer clave,Object equipo)->{
            
        rta.insertar(equipo,rta.getLongitud()+1);    
            
        });
        

        
     return rta;   
    }
       public Lista listarClaves(){
    
        Lista rta = new Lista();
        
        this.hashMap.forEach((Integer clave,Object equipo)->{
            
        rta.insertar(clave,rta.getLongitud()+1);
            
        });
        

        
     return rta;   
    }
}
