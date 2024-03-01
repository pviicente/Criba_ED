import java.util.Scanner;

public class Criba {
    public static void main(String[] args) {
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
    public static int dim;
    public static boolean esPrimo[];
    public static int primos[];
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
    public static void iniciarCriba(int max){     //iniciar la criba creando el vector, asignando true y eliminando los dos primeros
        int i;
        dim = max + 1; // Tamaño del array //algunas variables las he pasado de locales, a variables de clase, en este caso dim ya estaba declarada
        esPrimo = new boolean[dim];// Inicializar el array
        for (i = 0; i < dim; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;// Eliminar el 0 y el 1, que no son primos
    }
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
    public static void rellenarVectorPrimos() {     // Cuenta los números primos y los mete en el vector
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

