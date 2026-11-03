package ejercicio3;

public class RelevosPrincipal {



    static void main() {
        Thread relevo1 = new Relevos("Relevo1");
        Thread relevo2 = new Relevos("Relevo2");
        Thread relevo3 = new Relevos("Relevo3");
        Thread relevo4 = new Relevos("Relevo4");
        System.out.println("Todos los hilos creados");
        System.out.println("Doy la salida");

        try {
            relevo1.join();
            relevo2.join();
            relevo3.join();
            relevo4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Todos los hilos terminaron");
    }
}
