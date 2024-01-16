
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static java.util.Comparator.comparingInt;


public class Estanteria {
    private final  List<Libro> Libros;
    
    
    public  Estanteria(){
        this.Libros = new ArrayList<>();
    }
    public void AniadirLibro(Libro libro){
        if(Libros.size() < 10 && !Libros.contains(libro)){
            Libros.add(libro);
            System.out.println("--------------------------");
            System.out.println(" Libro añadido con exito! ");
            System.out.println("--------------------------");
        }else{
            System.out.println("---------                                                     ---------");
            System.out.println(" No se puede añadir el libro porque existe o la estanteria esta llena. ");
            System.out.println("---------                                                     ---------");
        }
    }
    public void EliminarLibro(String Titulo, String Autor){
        Libros.removeIf(libro -> libro.getTitulo().equals(Titulo) || libro.getAutor().equals(Autor));
        System.out.println("-----------------------------");
        System.out.println(" Libro/s elimnados con éxito ");
        System.out.println("-----------------------------");
    }
    public void MostrarTop10(){
        Collections.sort(Libros, comparingInt(Libro::getCalificacion).reversed());
        
        for(int i = 0; i < Math.min(10, Libros.size()); i++){
           Libro libro = Libros.get(i);
           System.out.println("------------------                                      ------------------");
           System.out.println((i + 1) +" El titulo del libro es " + libro.getTitulo() + " y su calificacion es " + libro.getCalificacion());
       }   System.out.println("------------------                                      ------------------");
    
    }
    public void DibujarEstanteria(){
        for(Libro libro : Libros){
            System.out.println(" El titulo del libro es " + libro.getTitulo() + " el autor es " + libro.getAutor() + " y su calificacion es " + libro.getCalificacion() );
        }
    }
}