/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import Entidades.AhorcadoControl;
import Entidades.Ahorcado;
import Libreria.LimpiarPantalla;
import java.util.Scanner;

/**
 *
 * @author Skpo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String salir = "";
        int selec;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Bienvenido al juego del Ahorcado");
        do {
            do {
                System.out.println("1- Jugar\n2- Instrucciones\n3- Opciones\n4- Salir");
                selec = leer.nextInt();

                if (selec == 1) {
                    Ahorcado juego = AhorcadoControl.crearJuego();
                    AhorcadoControl.jugarJuego(juego);
                } else if (selec == 2) {
                    instrucciones();
                }

            } while (!(selec == 3 || selec == 4));
            if (selec == 3) {
                System.out.println("Aún no hemos implementado las opciones, por favor elegir otra opción.");
                LimpiarPantalla.limpiarConAviso();
            } else if (selec == 4) {
                System.out.println("Está seguro que quiere salir? Y/N");
                salir = leer.next();

            }
        } while (!(selec == 4 && salir.equalsIgnoreCase("Y")));

    }

    public static void instrucciones() {
        System.out.println("Antes de jugar es necesario que el verdugo seleccione jugar e ingrese la palabra secreta"
                + "\nque luego tendra que intentar adivinar el ahorcado, se disponen de 7 intentos visualizados graficamente,"
                + "\nel ahorcado debe ingresar letra por letra y se le irá mostrando si dicha letra encaja en la palabra"
                + "\ningresada por el verdugo, si la palabra corresponde se mostrara en pantalla y no sumara un intento,"
                + "\ncaso contrario, si se equivoca, sumara un intento y tentra otra oportunidad.");
        LimpiarPantalla.limpiarConAviso();
    }
}
