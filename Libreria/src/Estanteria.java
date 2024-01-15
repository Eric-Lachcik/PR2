
import java.util.ArrayList;
import java.util.List;

public class Estanteria {
    private final  List<Libro> Libros;
    
    
    public Estanteria(){
        this.Libros = new ArrayList<>();
    }
    public void AniadirLibro(Libro libro){
        if(Libros.size() < 10 && !Libros.contains(libro)){
            Libros.add(libro);
            System.out.println(" Libro añadido con exito! ");
        }else{
            System.out.println(" No se puede añadir el libro porque existe o la estanteria esta llena. ");
        }
    }
    public void EliminarLibro(){
        
    }
    public void MostrarTop10(){
        
    }
    public void DibujarEstanteria(){
        
    }
}