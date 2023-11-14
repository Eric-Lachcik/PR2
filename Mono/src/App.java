import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    String[] insultos = { "Insultos: ",
        "¿Has dejado ya de usar pañales?",
        "¡He hablado con simios más educados que tu!",
        "¡Luchas como un ganadero!",
        "¡Una vez tuve un perro más listo que tu!" };
    String[] contestaciones = { "Contestaciones: ",
        "¿Por qué? ¿Acaso querías pedir uno prestado?",
        "Me alegra que asistieras a tu reunión familiar diaria.",
        "Qué apropiado, tú peleas como una vaca.",
        "Te habrá enseñado todo lo que sabes." };
    int turno = 0;
    String resp = "---";
    int Jugador1 = 0;
    int Jugador2 = 0;
    Scanner scan = new Scanner(System.in);
    Random ram = new Random();
    System.out.println("Presione ENTER para elegir tu turno ");
    String turnos = scan.nextLine();
    int alea = ram.nextInt(1, 3);
    int IA = ram.nextInt(1, 5);
    System.out.println("Tu turno es " + alea);
    int valor = alea % 2;
    while (turno < 4) {
      if (valor == 0) {
        System.out.println("Empiezas Primero, estas son tus opciones, elige del 1 al 4 ");
        for (int n = 0; n < insultos.length; n++) {
          System.out.println(resp + insultos[n]);
        }
        if (scan.hasNextInt()) {
          int numeroIngresado = scan.nextInt();
          System.out.println("Insulto seleccionado: " + insultos[numeroIngresado]);
          System.out.println("Constestacion seleccionada: " + contestaciones[IA]);
          if (numeroIngresado == IA) {
            System.out.println("Has Perdido contra la IA ");
            Jugador2++;
          } else {
            System.out.println("Has Ganando contra la IA ");
            Jugador1++;
          }

        }
        valor++;
      } else {
        System.out.println(resp + insultos[IA]);
        System.out.println("Empiezas Segundo, estas son tus opciones , elige del 1 al 4 ");
        for (int m = 0; m < contestaciones.length; m++) {
          System.out.println(resp + contestaciones[m]);

        }
        if (scan.hasNextInt()) {
          int numeroIngresado = scan.nextInt();
          System.out.println("Insulto seleccionado: " + insultos[IA]);
          System.out.println("Contestacion seleccionada: " + contestaciones[numeroIngresado]);

          if (numeroIngresado == IA) {
            System.out.println("Has Ganado contra la IA");
            Jugador1++;
          } else {
            System.out.println("Has Perdido contra la IA");
            Jugador2++;
          }
        }
        valor = 0;
      }

      turno++;
    }
    System.out.println("Has ganado un total de: "  + Jugador1 + " veces. Y has perdido un total de: " + Jugador2 + " veces.");
  }
}
