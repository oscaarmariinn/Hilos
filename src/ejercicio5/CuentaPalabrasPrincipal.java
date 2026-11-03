package ejercicio5;

public class CuentaPalabrasPrincipal {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo1 = new CuentaPalabras(0, 200);
        Thread hilo2 = new CuentaPalabras(200, 400);
        Thread hilo3 = new CuentaPalabras(400, 500);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        // El principal espera a que acaben los tres
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("Total de palabras: " + CuentaPalabras.totalWords);
        System.out.println("Total de impares: " + CuentaPalabras.totalOdd);
    }
}