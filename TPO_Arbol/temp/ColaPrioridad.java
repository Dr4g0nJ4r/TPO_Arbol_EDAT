/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kolia
 */
public class ColaPrioridad {


    private Cola colaProfecional;
    private Cola colaAficionado;
    private Cola colaNovato;

    public ColaPrioridad() {

        this.colaProfecional = new Cola();
        this.colaAficionado = new Cola();
        this.colaNovato = new Cola();

    }

    public boolean insertar(Object elem, int prioridad) {
        boolean rta = false;

        switch (prioridad) {

            case 0:
                rta = colaProfecional.poner(elem);
                break;

            case 1:
                rta = colaAficionado.poner(elem);
                break;

            case 2:
                rta = colaNovato.poner(elem);
                break;

            default:
                System.out.println("Prioridad no reconocida");
                break;
        }

        return rta;

    }


    public boolean eliminarFrente() {

        boolean rta;

        if (colaProfecional.length() > 0) {

            rta = colaProfecional.sacar();

        } else {

            if (colaAficionado.length() > 0) {

                rta = colaAficionado.sacar();

            } else {

                rta = colaNovato.sacar();

            }
        }

        return rta;

    }

    public Object obtenerFrente() {

        Object rta = null;
        if (colaProfecional.length() > 0) {
            rta = colaProfecional.obtenerFrente();
            colaProfecional.sacar();
        } else {
            if (colaAficionado.length() > 0) {
                rta = colaAficionado.obtenerFrente();
                colaAficionado.sacar();
            } else {

                if (colaNovato.length() > 0) {
                    rta = colaNovato.obtenerFrente();
                    colaNovato.sacar();
                }
            }
        }

        return rta;

    }

    public int length() {

        return (colaNovato.length() + colaAficionado.length() + colaProfecional.length());

    }

    public boolean esVacia() {

        return (colaNovato.length() == 0 && colaAficionado.length() == 0 && colaProfecional.length() == 0);

    }

}
