import java.util.Random;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
      String[] insultos = {" ",
        "1.¿Has dejado ya de usar pañales?",
        "2.¡He hablado con simios más educados que tu!",
        "3.¡Luchas como un ganadero!",
        "4.¡Una vez tuve un perro más listo que tu!"};
      String[] contestaciones = {" ",
      "1.¿Por qué? ¿Acaso querías pedir uno prestado?",
      "2.Me alegra que asistieras a tu reunión familiar diaria.",
      "3.Qué apropiado, tú peleas como una vaca.",
      "4.Te habrá enseñado todo lo que sabes."};
      int i = 0;
      int y = 0;
      int Jugador1 = 4;
      int Jugador2 = 4;
      Scanner scan = new Scanner(System.in);
      System.out.println("Presione enter para elegir tu turno");
      String turno = scan.nextLine();
      int alea = (int)Math.floor(Math.random()*2+1);
      System.out.println("Tu turno es "+ alea);

      if ( alea == 1) {
        System.out.println("Eres Jugador1, estas son tus opciones, elige del 1 al 4 ");
        for(int n = 0; n < insultos.length; n++)
        {
            // Imprimimos los elementos del array en pantalla.
            System.out.println(insultos[n]);
      
        }
        if (scan.hasNextInt()) {
          int numeroIngresado = scan.nextInt();
              String insulto = insultos[numeroIngresado];
              System.out.println("Insulto seleccionado: " + insulto);

        }
      }
      if (alea == 2){
        System.out.println("Eres Jugador2, estas son tus opciones , elige del 1 al 4");
        for(int m = 0; m < contestaciones.length; m++)
        {
            // Imprimimos los elementos del array en pantalla.
            System.out.println(contestaciones[m]);
        
        }  
        if (scan.hasNextInt()) {
          int numeroIngresado = scan.nextInt();
              String contestacion = contestaciones[numeroIngresado];
              System.out.println("Contestacion seleccionado: " + contestacion);
        }
      }
  }
}
      
      
      



  



