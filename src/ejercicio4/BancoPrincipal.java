package ejercicio4;

import static ejercicio4.Banco.dinero;
import static ejercicio4.Banco.dineroPLUS;

public class BancoPrincipal {

    static void main() {
        Thread banco1 = new Banco("Andrea", 5000, "SINGLE");
        Thread banco2 = new Banco("Leonardo", 4000, "PLUS");
        Thread banco3 = new Banco("Sanson", 6000, "SINGLE");
        Thread banco4 = new Banco("Sara", 7000, "PLUS");

        try {
            banco1.join();
            banco2.join();
            banco3.join();
            banco4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El dinero final de la camara acorazada es: " + dinero);
        System.out.println("El dinero final de la camara acorazada PLUs es: " + dineroPLUS);
    }

}
