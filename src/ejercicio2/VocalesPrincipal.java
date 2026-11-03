package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ejercicio2.Vocales.totalVocales;

public class VocalesPrincipal {

    static void main() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String frase = "";
        try {
             frase = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread a = new Vocales("a", frase);
        Thread e = new Vocales("e", frase);
        Thread i = new Vocales("i" , frase);
        Thread o = new Vocales("o" , frase);
        Thread u = new Vocales("u"  , frase);

        try {
            a.join();
            e.join();
            i.join();
            o.join();
            u.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Vocales totales: "+ totalVocales);
    }
}
