
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

        // TEST DE SONFRONTERA
        ArbolGen arbolGen = new ArbolGen();
        Lista lista = new Lista();
        // Arbol genérico compuesto de:
        /*
         * 15
         * / | \
         * 10 19 21
         * / \ / \ /
         * 1 5 9 7 3
         */
        arbolGen.insertar(15, null);
        arbolGen.insertar(10, 15);
        arbolGen.insertar(19, 15);
        arbolGen.insertar(21, 15);
        arbolGen.insertar(1, 10);
        arbolGen.insertar(5, 10);
        arbolGen.insertar(9, 19);
        arbolGen.insertar(7, 19);
        arbolGen.insertar(3, 21);
        // Lista compuesta de 1,5,9,7,3
        lista.insertar(1, 1);
        lista.insertar(5, 2);
        lista.insertar(9, 3);
        lista.insertar(7, 4);
        lista.insertar(3, 5);
        lista.insertar(23, 6);
        // imprimo Lista
        System.out.println("Lista: " + lista.toString());
        // Imprimo árbol
        System.out.println("ArbolGen: " + arbolGen.toString());
        // Verifico resultado de sonFrontera
        System.out.println("sonFrontera: " + arbolGen.sonFrontera(lista));
        // Valido que lista no tenga duplicados
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
        System.out.println("Lista es duplicada? : " + duplicado);

        testEquals();

    }

    public static void testEquals() {

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

        System.out.println("\n Arbol x.toString()  es: \n"
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
        b.insertar(12, 15);
        b.insertar(20, 15);
        b.insertar(22, 15);
        b.insertar(30, 15);
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

        System.out.println("Es el arbol a igual al arbol b? " + sOk + " --> " + ((a.equals(b) ? sOk : sErr)));

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
        b.insertar(9, 10);
        b.insertar(15, 10);
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

        System.out.println("Es el arbol a igual al arbol b? " + sOk + " --> " + ((a.equals(b) ? sOk : sErr)));
        a.vaciar();
        b.vaciar();

        a.insertar(11, 1);
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
        b.insertar(9, 10);
        b.insertar(15, 10);
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

        System.out.println("Es el arbol a igual al arbol b? " + sOk + " --> " + ((a.equals(b) ? sOk : sErr)));
    }

}