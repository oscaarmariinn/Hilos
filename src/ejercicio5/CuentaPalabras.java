package ejercicio5;

public class CuentaPalabras extends Thread {
    int inicio;
    int fin;

    public static final String texto = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur explicabo\n" +
            "laboriosam, minusm ollitia nostrum quibusdam quo reprehenderit. Adipisci\n" +
            "consectetur, ducimus, facere laudantium nemoo mnis optio quaerat, quo soluta\n" +
            "voluptate voluptatibus. Lorem ipsum dolor sit amet, consectetur adip sicing elit.\n" +
            "Aliquam, aperiam beatae blanditiis consectetur dolore dolorem excepturi harum\n" +
            "maximeob caecati perferendis porro quisquam quos repellendus sequi soluta ullam\n" +
            "veritatis! Inventore davince.";

    static int totalWords = 0;
    static int totalOdd = 0;

    // Un candado por variable: así un hilo puede escribir totalWords
    // mientras otro escribe totalOdd, pero nunca dos a la vez en la misma
    static final Object lockWords = new Object();
    static final Object lockOdd = new Object();

    public CuentaPalabras(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    @Override
    public void run() {
        int finReal = Math.min(fin, texto.length()); // el hilo 3 pide hasta 500 y el texto puede ser más corto
        int palabras = 0;
        int impares = 0;

        for (int i = inicio; i < finReal; i++) {
            boolean esLetra = !Character.isWhitespace(texto.charAt(i));
            boolean inicioPalabra = esLetra && (i == 0 || Character.isWhitespace(texto.charAt(i - 1)));

            if (inicioPalabra) {
                // Medimos la palabra completa, aunque acabe fuera de mi intervalo
                int j = i;
                while (j < texto.length() && !Character.isWhitespace(texto.charAt(j))) {
                    j++;
                }
                int longitud = j - i;

                palabras++;
                synchronized (lockWords) {
                    totalWords++;
                }

                if (longitud % 2 != 0) {
                    impares++;
                    synchronized (lockOdd) {
                        totalOdd++;
                    }
                }
            }
        }
        System.out.println(getName() + " ha contado " + palabras
                + " palabras y " + impares + " impares");
    }
}