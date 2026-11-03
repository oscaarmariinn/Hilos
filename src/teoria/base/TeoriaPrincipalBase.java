package teoria.base;

import java.util.ArrayList;

public class TeoriaPrincipalBase {

    static void main() {
        ArrayList<HiloBase> hilos = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            hilos.add(new HiloBase("Hilo"+i,i));
        }
        Thread hiloPaco = new HiloBase("Paco Fiestas", 1);
        Thread hiloPepe = new HiloBase("Pepe", 10);

        for (int i = 0; i < 50; i++) {
            System.out.println("Yo soy el principal");
        }

        try {
            hiloPepe.join();
            hiloPaco.join();
            for (HiloBase hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo Interrupted");
        }

        System.out.println("Han terminado todos los hilos el valor global es: "+ HiloBase.valorGlobal);
    }
}
