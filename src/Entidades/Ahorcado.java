/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Skpo
 */
public class Ahorcado {

    private char[] palabra;
    private boolean[] encontrado;
    private char[] letrasDisponibles = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // {'a','b','c'...}
    private int intentos = 7;

    public Ahorcado(char[] palabra, boolean[] encontrado) {
        this.palabra = palabra;
        this.encontrado = encontrado;
    }

    public char[] getLetrasDisponibles() {
        return letrasDisponibles;
    }

    public void setLetrasDisponibles(char[] letrasDisponibles) {
        this.letrasDisponibles = letrasDisponibles;
    }

    public Ahorcado() {
    }

    public char[] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean[] getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean[] encontrado) {
        this.encontrado = encontrado;
    }

}
