import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CalculosEstadisticos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();

        int[] arreglo = new int[n];

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arreglo[i] = rand.nextInt(100); // generar números aleatorios entre 0 y 99
        }

        System.out.println("El arreglo generado es: " + Arrays.toString(arreglo));

        double media = calcularMedia(arreglo);
        System.out.println("La media es: " + media);

        double mediana = calcularMediana(arreglo);
        System.out.println("La mediana es: " + mediana);

        double varianza = calcularVarianza(arreglo, media);
        System.out.println("La varianza es: " + varianza);

        double desviacion = calcularDesviacion(varianza);
        System.out.println("La desviación estándar es: " + desviacion);

        int moda = calcularModa(arreglo);
        System.out.println("La moda es: " + moda);
    }

    public static double calcularMedia(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return (double)suma / arreglo.length;
    }

    public static double calcularMediana(int[] arreglo) {
        Arrays.sort(arreglo);
        int n = arreglo.length;
        if (n % 2 == 0) {
            return (double)(arreglo[n/2 - 1] + arreglo[n/2]) / 2;
        } else {
            return arreglo[n/2];
        }
    }

    public static double calcularVarianza(int[] arreglo, double media) {
        double suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += Math.pow(arreglo[i] - media, 2);
        }
        return suma / arreglo.length;
    }

    public static double calcularDesviacion(double varianza) {
        return Math.sqrt(varianza);
    }

    public static int calcularModa(int[] arreglo) {
        int moda = 0;
        int maxFrecuencia = 0;
        for (int i = 0; i < arreglo.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    frecuencia++;
                }
            }
            if (frecuencia > maxFrecuencia) {
                moda = arreglo[i];
                maxFrecuencia = frecuencia;
            }
        }
        return moda;
    }
}