/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Libreria.LimpiarPantalla;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Skpo
 */
public class AhorcadoControl {

    
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static Ahorcado crearJuego() {
        System.out.println("Ingrese la palabra para el juego.");
        String palabra = leer.next();
        while (palabra.contains(" ")) {
            System.out.println("Ingrese una sola palabra sin espacios.");
            System.out.println("Ingrese la palabra para el juego.");
            palabra = leer.next();
        }
        palabra = palabra.toLowerCase();
        boolean[] arregloBooleano = new boolean[palabra.length()];
        Arrays.fill(arregloBooleano, false);
        return new Ahorcado(palabra.toCharArray(), arregloBooleano);
    }

    public static void jugarJuego(Ahorcado juego) {
        etiqueta:
        {
            do {
                LimpiarPantalla.limpiarSinAviso();
                mostrarJuego(juego);
                mostrarPalabra(juego);
                mostrarLetrasDisponibles(juego);
                if (condicionDeVictoria(juego)) {
                    break etiqueta;
                }
                jugarTurno(juego);
            } while (juego.getIntentos() > 0);
        }
        
        if (juego.getIntentos() > 0) {
            ganar(juego);
            LimpiarPantalla.limpiarConAviso();
        } else {
            LimpiarPantalla.limpiarSinAviso();
            mostrarJuego(juego);
            mostrarPalabra(juego);
            mostrarLetrasDisponibles(juego);
            perder(juego);
            LimpiarPantalla.limpiarConAviso();
        }
    }

    public static boolean condicionDeVictoria(Ahorcado juego) {
        boolean[] aux = new boolean[juego.getPalabra().length];
        Arrays.fill(aux, true);
        return Arrays.equals(juego.getEncontrado(), aux);
    }

    public static void ganar(Ahorcado juego) {
        System.out.println("CORRECTO, USTED HA GANADO");
    }

    public static void perder(Ahorcado juego) {
        System.out.println("INCORRECTO, USTED HA PERDIDO.\nLA PALABRA ERA >>> " + Arrays.toString(juego.getPalabra()) + " <<<");

    }

    public static void jugarTurno(Ahorcado juego) {

        boolean letraEncontradaEnElArreglo = false;
        System.out.println("Ingrese una letra minúscula del abecedario");
        String aux = leer.next();

        char letra = aux.charAt(0);
        
        for (int i = 0; i < juego.getLetrasDisponibles().length; i++) {
            if (letra == juego.getLetrasDisponibles()[i]) {
                juego.getLetrasDisponibles()[i] = '#';
            }
        }
        for (int i = 0; i < juego.getPalabra().length; i++) {
            if (letra == juego.getPalabra()[i]) {
                modificarArregloBooleano(juego, i);
                letraEncontradaEnElArreglo = true;
            }
        }
        if (!letraEncontradaEnElArreglo) {
            juego.setIntentos(juego.getIntentos() - 1);
        }
    }

    public static void modificarArregloBooleano(Ahorcado juego, int posicion) {
        boolean[] aux = juego.getEncontrado();
        for (int i = 0; i < aux.length; i++) {
            if (i == posicion) {
                aux[i] = true;
            }
        }
        juego.setEncontrado(aux);
    }

    public static void mostrarLetrasDisponibles(Ahorcado juego) {
        for (char letraDisponible : juego.getLetrasDisponibles()) {
            System.out.print(letraDisponible + " ");
        }
        System.out.println("");
    }

    public static void mostrarPalabra(Ahorcado juego) {
        for (int i = 0; i < juego.getPalabra().length; i++) {
            if (juego.getEncontrado()[i]) {
                System.out.print(juego.getPalabra()[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("");
    }

    public static void mostrarJuego(Ahorcado juego) {
        switch (juego.getIntentos()) {
            case 7:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	          ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 6:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 5:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "        |         ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 4:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "       \\|         ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 3:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "       \\|/        ║\n"
                        + "                  ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 2:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "       \\|/        ║\n"
                        + "        |         ║\n"
                        + "                  ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 1:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "       \\|/        ║\n"
                        + "        |         ║\n"
                        + "       /          ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
            case 0:
                System.out.println("        ╔═════╗\n"
                        + "	|         ║\n"
                        + "	O         ║\n"
                        + "       \\|/        ║\n"
                        + "        |         ║\n"
                        + "       / \\        ║\n"
                        + "             ╔══╩══╗\n"
                        + "	     ╚═════╝");
                break;
        }
    }
}
