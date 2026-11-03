package ejercicio4;

import java.util.concurrent.Semaphore;

public class Banco extends Thread {

    int cantidad;
    String categoria;
    public static int dinero = 100000;
    public static int dineroPLUS = 50000;
    static Semaphore semaphore = new Semaphore(1);
    public Banco(String name, int cantidad, String categoria) {
        super(name);
        this.cantidad = cantidad;
        this.categoria = categoria;
        start();
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Soy el hilo " + getName() +" y estoy entrando al banco");
            System.out.println("Voy a solicitar la entrada a la camara acorazada");
            sleep(500);
            if (categoria.equals("SINGLE")) {
                System.out.println("Ya he entrado a la camara acorazada");
                dinero += cantidad;
                System.out.println("Dinero despues de sumar cantidad= "+ dinero);
                dinero -= 1000;
                System.out.println("Dinero despues de restar= "+ dinero);
                System.out.println("Salgo de la camara soy " + getName());
            } else if (categoria.equals("PLUS")) {
                System.out.println("Ya he entrado a la camara acorazada PLUS");
                double diez = dineroPLUS * 0.1;
                dineroPLUS -= diez;
                System.out.println("DineroPLUS despues de restar un 10% = "+ dineroPLUS);
                cantidad += diez;
                System.out.println("Cantidad despues de llevarse el 10%= "+ cantidad);
                System.out.println("Salgo de la camaraPLUS, soy: "+ getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }

    }

}
