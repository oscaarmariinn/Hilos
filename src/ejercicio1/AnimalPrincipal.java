package ejercicio1;


public class AnimalPrincipal  {

    static void main(String[] args){
        Animal liebre = new Animal("Liebre",5);
        Animal guepardo = new Animal("Guepardo",1);
        Animal tortuga = new Animal("Tortuga", 10);


        try {
            liebre.join();
            guepardo.join();
            tortuga.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrupted");
        }

        System.out.println("La carrera ha terminado");

    }
}
