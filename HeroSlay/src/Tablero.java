// import  HeroSlay.Carta.CartaTipo.ATAQUE;
// import  HeroSlay.Carta.CartaTipo.ATURDIR;
// import  HeroSlay.Carta.CartaTipo.CURAR;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;


// public class Tablero {

    
//     public static void main(String[] args) {
//        Carta cartaAtaque1 = new Carta("Navaja del Chino", ATAQUE, 5);
//        Carta cartaAtaque2 = new Carta("Machete Oxidado", ATAQUE, 15);
//        Carta cartaCurar1 = new Carta("Kebab Mixto", CURAR, 15);
//        Carta cartaCurar2 = new Carta("Durum Mixto", CURAR, 20);
//        Carta cartaAturdir1 = new Carta("Chancla de Mama", ATURDIR, 4);
//        Carta cartaAturdir2 = new Carta("Cinturón del Padre", ATURDIR, 8);
       
       
//        List<Carta> Mazo = new ArrayList<>();
//        Mazo.add(cartaAtaque1);
//        Mazo.add(cartaAtaque2);
//        Mazo.add(cartaCurar1);
//        Mazo.add(cartaCurar2);
//        Mazo.add(cartaAturdir1);
//        Mazo.add(cartaAturdir2);
       
//        Personaje heroe = new Personaje("Policia de Barrio", 30, new ArrayList<>(Mazo));
//        Personaje villano = new Personaje("Delincuente", 30, new ArrayList<>(Mazo));
        
//        int ronda = 1;
//        while(heroe.getVida() > 0 && villano.getVida() > 0){
//            System.out.println("╔════════════════╗");
//            System.out.println("║   Ronda " + ronda + " !  ║");
//            System.out.println("╚════════════════╝");
//            iniciar(heroe, villano);
//            ronda ++;
//        }
//             System.out.println("╔════════════════════════════════════════════╗");
//         if(heroe.getVida() <= 0){
//             System.out.println("║  El Delincuente ha ganado!!          ║");
//         }else{
//             System.out.println("║  El Policia de Barrio ha ganado!!    ║");
//         }
//             System.out.println("╚════════════════════════════════════════════╝");
//     }
//     public static Personaje cambiarTurno( Personaje p1, Personaje p2){
//         Random ran = new Random();
//         int Dado = ran.nextInt(2);
   
//         if (Dado == 0){
//                 return p1;
//             }else{
//                 return p2;
//             }
//         }
 
//     private static void iniciar(Personaje turno1, Personaje turno2){
        
        
//         Personaje turnoActual = cambiarTurno( turno1, turno2);
//         Personaje turnoSiguiente = (turnoActual == turno1) ? turno2 : turno1;
//         if(!turnoActual.estaAturdido()){
//             System.out.println("╔═══════════════════════════════════════╗");
//             System.out.println("║  Turno de " + turnoActual.pintarInfo() + "║");
//             System.out.println("╚═══════════════════════════════════════╝");
//             Carta CartaRandom = turnoActual.elegir2CartasAleatoria();
//             turnoActual.AplicarCarta(CartaRandom, turnoSiguiente);
//             if(turnoSiguiente.getVida() <= 0){
//                 return;
//             }
//         }else{
//             System.out.println(turnoActual.pintarInfo() + " Esta aturdido pierde el turno ");
//         }
//         turnoActual.quitarAturdido();
        
//         if(!turnoSiguiente.estaAturdido()){
//             System.out.println("╔═══════════════════════════════════════════╗");
//             System.out.println("║  Turno de " + turnoSiguiente.pintarInfo() +  "║");
//             System.out.println("╚═══════════════════════════════════════════╝");
//             Carta CartaRandomSiguiente = turnoSiguiente.elegir2CartasAleatoria();
//             turnoSiguiente.AplicarCarta(CartaRandomSiguiente, turnoActual);
//             if(turnoActual.getVida() <= 0){
//                 return;
//             }
//         }else{
//             System.out.println(turnoSiguiente.pintarInfo() + " Esta aturdido pierde el turno ");
//         }
//          turnoSiguiente.quitarAturdido();
//     }
// }