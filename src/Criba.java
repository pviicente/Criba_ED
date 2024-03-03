import java.util.Scanner;

/**
 * Clase Criba
 * Este programa contiene una clase para generar todos los números primos de 1 hasta un número máximo especificado por el usuario
 * @author Pablo Vicente Monserrat
 * @version 3
 *
 */

public class Criba {
    public static void main(String[] args) {
        /**
         * Este es el programa principal de la clase criba
         * @param dato corresponde al valor introducido del que queremos saber los números primos hasta el
         * @param vector a partir de dato, genera un vector con esa dimensión
         *               El for permite incluir un salto de línea cada 10 números
         */
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }

    /**
     * @param dim es una variable de clase, que al sumarle uno, nos proporciona el tamñano del vector para almacenar todos los valores hasta dato
     * @param esPrimo es un array, de dimensión dim (dato+1) para almacenar los valores, al principio todos, y luego solo los primos
     * @param primos almacena los números primos
     */
    public static int dim;
    public static boolean esPrimo[];
    public static int primos[];

    /**
     * Llama a los métodos creados
     * @param max valor introducido como parámetro
     * @return primos el array de números primos
     */
    public static int[] generarPrimos(int max) {    // Generar números primos de 1 a max
        if (max >= 2) {
            iniciarCriba(max);
            criba();
            rellenarVectorPrimos();
            return primos;
        }
        else// max < 2
            return new int[0];// Vector vacío
    }

    /**
     * iniciar la criba creando el vector, asignando true y eliminando los dos primeros
     * @param max
     */
    public static void iniciarCriba(int max){
        int i;
        dim = max + 1; // Tamaño del array //algunas variables las he pasado de locales, a variables de clase, en este caso dim ya estaba declarada
        esPrimo = new boolean[dim];// Inicializar el array
        for (i = 0; i < dim; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;// Eliminar el 0 y el 1, que no son primos
    }

    /**
     * // Realiza la criba mediante el método de Eratostenes
     */
    public static void criba() {    // Realiza la criba mediante el método de Eratostenes
        int i;
        int j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) { // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Cuenta los números primos y los mete en el vector
     */
    public static void rellenarVectorPrimos() {
        int i;
        int j;
        int cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        primos = new int[cuenta]; //algunas variables las he pasado de locales, a variables de clase, en este caso primos ya estaba declarada
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }
}

