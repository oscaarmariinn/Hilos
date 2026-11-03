package ejercicio3;

import java.util.concurrent.Semaphore;

public class Relevos extends Thread {
    static int contador = 0;
    static Semaphore semaforo = new Semaphore(1);
    public Relevos(String name) {
        super(name);
        start();
    }
    @Override
    public void run() {

        try {
            semaforo.acquire();
            System.out.println("Soy el hilo " + getName() + " corriendo");
            contador++;
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaforo.release();
        }
        if (contador < 4) {
            System.out.println("Termine, paso el testigo");
        }else {
            System.out.println("Termine la carrera, soy el ultimo");
        }
    }
}
