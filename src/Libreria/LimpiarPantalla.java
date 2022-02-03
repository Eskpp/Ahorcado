/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author Skpo
 */
public class LimpiarPantalla {

    public static void limpiarConAviso() {
        try {
            System.out.println("Presione enter para continuar.");
            new java.util.Scanner(System.in).nextLine();

            Robot limpiador = new Robot();
            limpiador.keyPress(KeyEvent.VK_CONTROL);
            limpiador.keyPress(KeyEvent.VK_L);
            limpiador.keyRelease(KeyEvent.VK_CONTROL);
            limpiador.keyRelease(KeyEvent.VK_L);
            limpiador.delay(100);

        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public static void limpiarSinAviso() {
        try {
            Robot limpiador = new Robot();
            limpiador.keyPress(KeyEvent.VK_CONTROL);
            limpiador.keyPress(KeyEvent.VK_L);
            limpiador.keyRelease(KeyEvent.VK_CONTROL);
            limpiador.keyRelease(KeyEvent.VK_L);
            limpiador.delay(100);

        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }
    }
}
