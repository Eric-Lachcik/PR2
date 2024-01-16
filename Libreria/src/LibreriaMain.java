public class LibreriaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria estanteriae = new Estanteria();
        Libro L1 = new Libro("Los franceses", "Ibai", 10);
        Libro L2 = new Libro("La muerte de los franceses", "Xokas", 9);
        
        estanteriae.AniadirLibro(L1);
        estanteriae.AniadirLibro(L2);
        
        Libro L3 = new Libro("España Revive", "TheGrefg", 5);
        Libro L4 = new Libro("La Decadencia de España", "TenGris", 8);
        Libro L5 = new Libro("El desahucio de la Abuela", "Abogado de TheGrefg", 2);
        
        estanteriae.AniadirLibro(L3);
        estanteriae.AniadirLibro(L4);
        estanteriae.AniadirLibro(L5);
        
        estanteriae.MostrarTop10();
        
        estanteriae.EliminarLibro(null, "TheGrefg");
                
        estanteriae.DibujarEstanteria();
    }   
}
