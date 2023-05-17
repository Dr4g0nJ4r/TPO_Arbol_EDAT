

import tpo_arbol.Jerarquicas.Dinamicas.ArbolGen;
import tpo_arbol.Lineales.Dinamicas.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luis
 */
public class Test {
    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";

    public static void main(String args[]) {

        testFrontera();
        testEquals();

    }

    public static void testFrontera(){
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*                  Test metodo sonFrontera()                 *");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************" + "\n\n" + RESET);
        // TEST DE SONFRONTERA
        ArbolGen x = new ArbolGen();
        ArbolGen a = new ArbolGen();
        ArbolGen b = new ArbolGen();

        System.out.println("********************************");
        System.out.println("*    Carga de datos inicial    *");
        System.out.println("********************************");
        
        System.out.println("\n Arbol x.toString()  es: \n"
                + "\n                                15"
                + "\n                +---------------+----------------+"
                + "\n                |               |                |"
                + "\n                10              19               21"
                + "\n            +---+---+      +----+----+       +---+---+"
                + "\n            |       |      |         |       |       |"
                + "\n            1       5      9         7       3       4"
                + "\n ");

        x.insertar(15, null);
        x.insertar(10, 15);
        x.insertar(19, 15);
        x.insertar(21, 15);
        x.insertar(1, 10);
        x.insertar(5, 10);
        x.insertar(9, 19);
        x.insertar(7, 19);
        x.insertar(3, 21);
        x.insertar(4, 21);

        a.insertar(10, 1);
        a.insertar(9, 10);
        a.insertar(15, 10);
        a.insertar(7, 9);
        a.insertar(3, 9);
        a.insertar(12, 15);
        a.insertar(20, 15);
        a.insertar(22, 15);
        a.insertar(30, 15);
        a.insertar(40, 30);
        a.insertar(45, 30);
        a.insertar(55, 30);

        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");
        
        Lista lista = new Lista();
        // Lista compuesta de 1,5,9,7,3
        lista.insertar(1, 1);
        lista.insertar(7, 2);
        lista.insertar(3, 3);
        lista.insertar(4, 4);
        lista.insertar(5, 5);
        lista.insertar(9, 6);
        // imprimo Lista     
        System.out.println("Lista: " + lista.toString());
        System.out.println("********************************");
        System.out.println("*      Pruebas con Arbol x     *");
        System.out.println("********************************");
        System.out.println("\n Arbol x.toString()  es: \n"
                + "\n                                15"
                + "\n                +---------------+----------------+"
                + "\n                |               |                |"
                + "\n                10              19               21"
                + "\n            +---+---+      +----+----+       +---+---+"
                + "\n            |       |      |         |       |       |"
                + "\n            1       5      9         7       3       4"
                + "\n ");
        System.out.println("Lista: " + lista.toString());
        System.out.println("¿La lista tiene duplicados? " + sOk + " --> " + ((contieneDuplicado(lista) ? sOk : sErr)));
        System.out.println("¿Estan todos los nodos hojas en la lista? " + sOk + " --> " + ((x.sonFrontera(lista) ? sOk : sErr)));
        System.out.println("********************************");
        System.out.println("* Pruebas con lista duplicados *");
        System.out.println("********************************");
        lista.insertar(7, 7);
        System.out.println("Insertar 7 a la lista: " + lista.toString());
        System.out.println("¿La lista tiene duplicados? " + sOk + " --> " + ((contieneDuplicado(lista) ? sOk : sErr)));
        System.out.println("¿Estan todos los nodos hojas en la lista? " + sOk + " --> " + ((x.sonFrontera(lista) ? sOk : sErr)));
        lista.eliminar(7);
        System.out.println("Eliminar 7 a la lista: " + lista.toString());
        System.out.println("********************************");
        System.out.println("*       Pruebas con Arbol a    *");
        System.out.println("********************************");
        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");
        System.out.println("Lista: " + lista.toString());
        System.out.println("¿La lista tiene duplicados? " + sOk + " --> " + ((contieneDuplicado(lista) ? sOk : sErr)));
        System.out.println("¿Estan todos los nodos hojas en la lista? " + sOk + " --> " + ((a.sonFrontera(lista) ? sOk : sErr)));
        System.out.println("********************************");
        System.out.println("*       Modifico Arbol x       *");
        System.out.println("********************************");
        System.out.println("\n Arbol x.toString()  es: \n"
                + "\n                                15"
                + "\n                +---------------+----------------+"
                + "\n                |               |                |"
                + "\n                10              19               21"
                + "\n            +---+---+      +----+----+       +---+---+"
                + "\n            |       |      |         |       |       |"
                + "\n            1       5      9         7       3       4"
                + "\n                                                     +---+"
                + "\n                                                         |"
                + "\n                                                         15"
                + "\n ");
        x.insertar(15, 4);
        System.out.println("Insertar 15 en árbol x");
        System.out.println("Lista: " + lista.toString());
        System.out.println("¿Estan todos los nodos hojas en la lista? " + sOk + " --> " + ((a.sonFrontera(lista) ? sOk : sErr)));
        lista.insertar(15,7);
        System.out.println("Insertar 15 a la lista: " + lista.toString());
        System.out.println("¿Estan todos los nodos hojas en la lista? " + sOk + " --> " + ((x.sonFrontera(lista) ? sOk : sErr)));
    }
    public static void testEquals() {
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*                  Test metodo equals()                      *");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************" + "\n\n" + RESET);
        ArbolGen x = new ArbolGen();
        ArbolGen z = new ArbolGen();
        ArbolGen a = new ArbolGen();
        ArbolGen b = new ArbolGen();

        System.out.println("\n Arbol x.toString()  es: \n"
                + "\n                                15"
                + "\n                +---------------+----------------+"
                + "\n                |               |                |"
                + "\n                10              19               21"
                + "\n            +---+---+      +----+----+       +---+---+"
                + "\n            |       |      |         |       |       |"
                + "\n            1       5      9         7       3       4"
                + "\n ");

        x.insertar(15, null);
        x.insertar(10, 15);
        x.insertar(19, 15);
        x.insertar(21, 15);
        x.insertar(1, 10);
        x.insertar(5, 10);
        x.insertar(9, 19);
        x.insertar(7, 19);
        x.insertar(3, 21);
        x.insertar(4, 21);

        System.out.println("\n Arbol z.toString()  es: \n"
                + "\n                                15"
                + "\n                +---------------+----------------+"
                + "\n                |               |                |"
                + "\n                10              19               21"
                + "\n            +---+---+      +----+----+       +---+---+"
                + "\n            |       |      |         |       |       |"
                + "\n            1       5      9         7       3       4"
                + "\n ");

        z.insertar(15, null);
        z.insertar(10, 15);
        z.insertar(19, 15);
        z.insertar(21, 15);
        z.insertar(1, 10);
        z.insertar(5, 10);
        z.insertar(9, 19);
        z.insertar(7, 19);
        z.insertar(3, 21);
        z.insertar(4, 21);

        System.out.println("Es el arbol x igual al arbol z? " + sOk + " --> " + ((x.equals(z) ? sOk : sErr)));

        a.insertar(10, 1);
        a.insertar(9, 10);
        a.insertar(15, 10);
        a.insertar(7, 9);
        a.insertar(3, 9);
        a.insertar(12, 15);
        a.insertar(20, 15);
        a.insertar(22, 15);
        a.insertar(30, 15);
        a.insertar(40, 30);
        a.insertar(45, 30);
        a.insertar(55, 30);

        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        b.insertar(10, 1);
        b.insertar(9, 10);
        b.insertar(11, 10);
        b.insertar(7, 9);
        b.insertar(3, 9);
        b.insertar(12, 11);
        b.insertar(20, 11);
        b.insertar(22, 11);
        b.insertar(30, 11);
        b.insertar(40, 30);
        b.insertar(45, 30);
        b.insertar(55, 30);

        System.out.println("\n Arbol b.toString() es: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            11"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        System.out.println("Es el arbol a igual al arbol b? " + sErr + " --> " + ((a.equals(b) ? sOk : sErr)));

        a.vaciar();
        b.vaciar();

        a.insertar(10, 1);
        a.insertar(9, 10);
        a.insertar(15, 10);
        a.insertar(7, 9);
        a.insertar(3, 9);
        a.insertar(12, 15);
        a.insertar(20, 15);
        a.insertar(22, 15);
        a.insertar(30, 15);
        a.insertar(40, 30);
        a.insertar(45, 30);
        a.insertar(55, 30);

        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                10"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        b.insertar(11, 1);
        b.insertar(9, 11);
        b.insertar(15, 11);
        b.insertar(7, 9);
        b.insertar(3, 9);
        b.insertar(12, 15);
        b.insertar(20, 15);
        b.insertar(22, 15);
        b.insertar(30, 15);
        b.insertar(40, 30);
        b.insertar(45, 30);
        b.insertar(55, 30);

        System.out.println("\n Arbol b.toString() es: \n"
                + "\n                                11"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        System.out.println("Es el arbol a igual al arbol b? " + sErr + " --> " + ((a.equals(b) ? sOk : sErr)));
        a.vaciar();
        b.vaciar();

        a.insertar(11, 1);
        a.insertar(9, 11);
        a.insertar(15, 11);
        a.insertar(7, 9);
        a.insertar(3, 9);
        a.insertar(12, 15);
        a.insertar(20, 15);
        a.insertar(22, 15);
        a.insertar(30, 15);
        a.insertar(40, 30);
        a.insertar(45, 30);
        a.insertar(55, 30);

        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                11"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        b.insertar(11, 1);
        b.insertar(9, 11);
        b.insertar(15, 11);
        b.insertar(7, 9);
        b.insertar(3, 9);
        b.insertar(12, 15);
        b.insertar(20, 15);
        b.insertar(22, 15);
        b.insertar(30, 15);
        b.insertar(40, 30);
        b.insertar(45, 30);
        b.insertar(56, 30);

        System.out.println("\n Arbol b.toString() es: \n"
                + "\n                                11"
                + "\n                +---------------+------------+"
                + "\n                |                            |"
                + "\n                9                            15"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    56"
                + "\n");

        System.out.println("Es el arbol a igual al arbol b? " + sErr + " --> " + ((a.equals(b) ? sOk : sErr)));

        a.vaciar();
        b.vaciar();

        a.insertar(10, 1);
        a.insertar(9, 10);
        a.insertar(15, 10);
        a.insertar(13, 10);
        a.insertar(7, 9);
        a.insertar(3, 9);
        a.insertar(12, 15);
        a.insertar(20, 15);
        a.insertar(22, 15);
        a.insertar(30, 15);
        a.insertar(40, 30);
        a.insertar(45, 30);
        a.insertar(55, 30);

        System.out.println("\n Arbol a.toString()  es: \n"
                + "\n                                             10"
                + "\n                +----------------------------+--------------------------+"
                + "\n                |                            |                          |"
                + "\n                9                            15                         13"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        b.insertar(10, 1);
        b.insertar(9, 10);
        b.insertar(11, 10);
        b.insertar(13, 10);
        b.insertar(7, 9);
        b.insertar(3, 9);
        b.insertar(12, 11);
        b.insertar(20, 11);
        b.insertar(22, 11);
        b.insertar(30, 11);
        b.insertar(40, 30);
        b.insertar(45, 30);
        b.insertar(55, 30);

        System.out.println("\n Arbol b.toString() es: \n"
                + "\n                                             10"
                + "\n                +----------------------------+--------------------------+"
                + "\n                |                            |                          |"
                + "\n                9                            15                         13"
                + "\n            +---+---+              +-------+--+---+-------+"
                + "\n            |       |              |       |      |       |"
                + "\n            7       3              12     20     22       30"
                + "\n                                                     +-----+-----+"
                + "\n                                                     |     |     |"
                + "\n                                                     40    45    55"
                + "\n");

        System.out.println("Es el arbol a igual al arbol b? " + sErr + " --> " + ((a.equals(b) ? sOk : sErr)));
    }
    private static boolean contieneDuplicado(Lista lista){
        int aux = 1;
        int aux2 = 2;
        boolean duplicado = false;
        while (aux <= lista.longitud() && !duplicado) {
            Object elem = lista.recuperar(aux);
            aux2 = aux + 1;
            while (aux2 <= lista.longitud() && !duplicado) {
                if (elem.equals(lista.recuperar(aux2))) {
                    duplicado = true;
                } else {
                    aux2++;
                }
            }
            aux++;
        }
        return duplicado;
    }
}