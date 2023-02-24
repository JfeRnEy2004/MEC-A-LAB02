import java.util.HashMap;
import java.util.Scanner;

public class ProcesamientoCadena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una línea de caracteres: ");
        String linea = sc.nextLine();

        // Sustituir las vocales por el carácter que más se repite en la línea
        char[] caracteres = linea.toCharArray();
        HashMap<Character, Integer> frecuencias = new HashMap<>();
        for (char c : caracteres) {
            if (esVocal(c)) {
                continue; // saltar las vocales
            }
            if (frecuencias.containsKey(c)) {
                frecuencias.put(c, frecuencias.get(c) + 1);
            } else {
                frecuencias.put(c, 1);
            }
        }
        char caracterMasRepetido = ' ';
        int maxFrecuencia = 0;
        for (char c : frecuencias.keySet()) {
            if (frecuencias.get(c) > maxFrecuencia) {
                caracterMasRepetido = c;
                maxFrecuencia = frecuencias.get(c);
            }
        }
        for (int i = 0; i < caracteres.length; i++) {
            if (esVocal(caracteres[i])) {
                caracteres[i] = caracterMasRepetido;
            }
        }
        String sustituida = new String(caracteres);

        // Invertir el orden de las letras
        StringBuilder invertida = new StringBuilder(sustituida);
        invertida.reverse();

        System.out.println("La línea procesada es: " + invertida);
    }

    public static boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
