public class Libro {
    private final String Titulo;
    private final String Autor;
    private int calificacion;
    
    public Libro(String Titulo, String Autor, int cualificacion){
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.calificacion = cualificacion;    
    }
    public String getTitulo(){
        return Titulo;
    }
    public String getAutor(){
        return Autor;
    }
    public int getCalificacion(){
        return calificacion;
    }
    public void setCalificacion(int calificacion){
        if(calificacion >= 0 && calificacion <= 10){
            this.calificacion = calificacion;
        }else{
            System.out.println(" La calificación introducida esta fuera de los límites ");
        }
    }
}
