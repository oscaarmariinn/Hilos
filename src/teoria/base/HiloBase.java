package teoria.base;

import java.util.concurrent.Semaphore;

public class HiloBase extends Thread{

    private int valor = 0;
    public static int valorGlobal = 0;

    private static Semaphore semaphore = new Semaphore(1);
    public HiloBase(String name, int priority){
        super(name);
        setPriority(priority);
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            System.out.println("Hola soy un hilo " + getName() +"y tengo valor: "+ valor++ +"!!");

            try {
                semaphore.acquire(); //SOLICITAR UN PERMISO AL SEMAFORO Y LO DEJA A 0
            } catch (InterruptedException e) {
                System.out.println("Hilo Interrumpido");
            }
            int valorAux = valorGlobal;
            valorAux++;
            valorGlobal = valorAux;
            semaphore.release(); // AL SEMAFORO LE SUMA 1 Y VUELVE A TENER PERMISO
        }
    }
}
