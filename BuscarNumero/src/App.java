    import java.util.Random;
    import java.util.Scanner;
public class App {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ram = new Random();
 
    System.out.println("Presione ENTER para comenzar el juego ");
    String turnos = scan.nextLine();
    int IA = ram.nextInt(1, 51);
    int i = 0;
    boolean fin = false;
    while(i < 5 && fin == false){
        System.out.println("Escriba un numero del 1 al 50");
        int numeroingresado = scan.nextInt();
        if(numeroingresado == IA){
            System.out.println("Has acertado");
            System.out.println("El numero era " + IA );
            fin = true;
        }else if(numeroingresado > IA){
            System.out.println("Tu numero es mayor");
        
        }else if(numeroingresado < IA){
            System.out.println("Tu numero es menor");
        }
               
        
        
    i++;    
    }
        
    }
}
