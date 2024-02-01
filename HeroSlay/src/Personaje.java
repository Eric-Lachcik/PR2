import java.util.List;
import java.util.Collections;
import java.util.Scanner;


public class Personaje {
    
    private final String Nombre;
    private int Vida;
    private List<Carta> Mazo;
    private boolean Aturdido;
    
    public Personaje(String Nombre, int Vida, List<Carta> Mazo){
        this.Nombre = Nombre;
        this.Vida = Vida;
        this.Mazo = Mazo;
        this.Aturdido = false;
    }
    public String getNombreP(){
        return Nombre;
    }
    public Integer getVida(){
        return Vida;
    }
    public boolean estaAturdido(){
        return Aturdido;
    }
    public String pintarInfo(){
        return String.format("%s | Vida: %d", Nombre, Vida);
    }
    public Carta elegir2CartasAleatoria() {
        if (Mazo.isEmpty()) {
            System.out.println("El mazo está vacío, no se puede elegir una carta.");
        return null;
        }
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        Collections.shuffle(Mazo);
        
        for(int i = 0; i < 2; i++){
            System.out.print((i + 1) + " . ");
            Mazo.get(i).pintarInfo();
        }
        int elec;
        do{
            System.out.print("Elige una carta de entre las dadas (1-2): ");
            elec = scan.nextInt();
        }while(elec <1 || elec > 2);
        
        return Mazo.get(elec - 1);
    }
    public void Atacar(int Vtotal){
        Vida -= Vtotal;
        if (Vida < 0){
            Vida = 0;
        }
    }
    public void Curar(int Vtotal){
        Vida += Vtotal;
    }
    public void Aturdir(int Vtotal){
        Aturdido = true;
        Vida -= Vtotal;
        if (Vida < 0){
            Vida = 0;
        }
    }
    public void quitarAturdido(){
        Aturdido = false;
    }
    public void AplicarCarta(Carta cartas, Personaje aturdido){
        switch(cartas.getTipo()){
            case ATAQUE -> {
                if(!Aturdido){
                    aturdido.Atacar(cartas.getValor());
                }
                break;
            }
            case CURAR -> {
                if(!Aturdido){
                    this.Curar(cartas.getValor());
                }
                break;
            }
            case ATURDIR -> {
                aturdido.Aturdir(cartas.getValor());
                break;
            }
        }
    }
}
