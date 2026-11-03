package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Vocales extends Thread {

    private String frase;
    char[] listaLetras;
    static int totalVocales = 0;
    private static Semaphore semaphore = new Semaphore(1);
    public Vocales(String name, String frase) {
        super(name);
        this.frase = frase;
        start();
    }

    @Override
    public void run() {
        char[] listaLetras = frase.toCharArray();
        int contador = 0;
        for (int i = 0; i < listaLetras.length; i++) {
            if (listaLetras[i] == getName().charAt(0)) {
                contador++;
                try {
                    semaphore.acquire();
                    totalVocales++;

                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                } finally {
                    semaphore.release();
                }
            }

        }
        System.out.println("Soy la letra "+ getName()+" y he aparecido un total de " + contador + " veces");

    }
}
