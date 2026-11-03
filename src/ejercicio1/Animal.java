package ejercicio1;
import java.util.concurrent.atomic.AtomicInteger;
public class Animal extends Thread{


    private static final int meta = 10000;

    private int contador = 0;

    private static final AtomicInteger posicion = new AtomicInteger(0);

    public Animal(String name, int priority){
        super(name);
        setPriority(priority);
        start();
    }

    @Override
    public void run() {
        while(contador<meta){
            contador++;
        }
        int puesto = posicion.incrementAndGet();
        System.out.println(getName()+ " ha llegado en la posicion " + puesto);
    }

}
