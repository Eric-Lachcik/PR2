public class Carta {
   
    private final String Nombre;
    private CartaTipo Tipo;
    private final int Valor;
    
    enum CartaTipo{
        ATAQUE,CURAR,ATURDIR    
    }
    public Carta(String Nombre,CartaTipo Tipo, int Valor){
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Valor = Valor;
    }
    public String getNombreC(){
        return Nombre;
    }
    public CartaTipo getTipo(){
        return Tipo;
    }
    public Integer getValor(){
        return Valor;
    }
    public void pintarInfo(){        
        System.out.println("--- " + getNombreC() + " | " + getTipo() + " | " + getValor());
    }
}