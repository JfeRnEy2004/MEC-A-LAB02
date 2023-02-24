import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeerYReemplazar {
   public static void main(String[] args) {

      // Creamos un objeto Scanner para leer la entrada del usuario
      Scanner scanner = new Scanner(System.in);

      // Pedimos al usuario que ingrese una cadena de caracteres
      System.out.print("Ingresa una cadena de caracteres: ");

      // Leemos la cadena de caracteres ingresada por el usuario
      String cadena = scanner.nextLine();

      // Creamos un objeto Map para contar las ocurrencias de cada consonante
      Map<Character, Integer> consonantes = new HashMap<>();

      // Recorremos la cadena de caracteres para contar las ocurrencias de cada consonante
      for (int i = 0; i < cadena.length(); i++) {
         char c = cadena.charAt(i);
         if (esConsonante(c)) {
            if (consonantes.containsKey(c)) {
               consonantes.put(c, consonantes.get(c) + 1);
            } else {
               consonantes.put(c, 1);
            }
         }
      }

      // Encontramos la consonante más repetida
      char consonanteMasRepetida = ' ';
      int repeticiones = 0;
      for (Map.Entry<Character, Integer> entry : consonantes.entrySet()) {
         if (entry.getValue() > repeticiones) {
            consonanteMasRepetida = entry.getKey();
            repeticiones = entry.getValue();
         }
      }

      // Reemplazamos las vocales por la consonante más repetida
      String nuevaCadena = "";
      for (int i = 0; i < cadena.length(); i++) {
         char c = cadena.charAt(i);
         if (esVocal(c)) {
            nuevaCadena += consonanteMasRepetida;
         } else {
            nuevaCadena += c;
         }
      }

      // Imprimimos la nueva cadena de caracteres
      System.out.println("La nueva cadena de caracteres es: " + nuevaCadena);

      // Imprimimos la cadena original al revés
      String cadenaAlReves = "";
      for (int i = cadena.length() - 1; i >= 0; i--) {
         cadenaAlReves += cadena.charAt(i);
      }
      System.out.println("La cadena original al revés es: " + cadenaAlReves);
   }

   // Método para determinar si un carácter es una vocal
   public static boolean esVocal(char c) {
      return "AEIOUaeiou".indexOf(c) != -1;
   }

   // Método para determinar si un carácter es una consonante
   public static boolean esConsonante(char c) {
      return !esVocal(c) && Character.isLetter(c);
   }
}