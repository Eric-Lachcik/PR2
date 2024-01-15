public class Libro {
    private final String Titulo;
    private final String Autor;
    private int cualificacion;
    
    public Libro(String Titulo, String Autor, int cualificacion){
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.cualificacion = cualificacion;    
    }
    public String getTitulo(){
        return Titulo;
    }
    public String getAutor(){
        return Autor;
    }
    public int getCualificacion(){
        return cualificacion;
    }
    public void setCualificacion(int cualificacion){
        this.cualificacion = cualificacion;
    }
}
