
import java.sql.*;
import javax.swing.*; 
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        Top10();
    }

    public static void Top10() {
        JTable table = new JTable();
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 1));

        String tableTop10[] = {"Posicion", "Nombre"}; 

        try {
            String url = "jdbc:mysql://localhost:3306/basejava";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs1 = myst.executeQuery("select Posicion, Nombre from pilotos join clasificacion on pilotos.Id = clasificacion.Piloto_Id order by Puntos desc");
            ResultSet rs = myst.executeQuery("select * from clasificacion");

            while (rs.next()) {
                String Posicion = String.valueOf(rs.getInt("Posicion"));
                String Puntos = String.valueOf(rs.getInt("Puntos"));
                String Nombre = rs1.getString("Nombre");
                String Equipo_Nombre = rs.getString("Equipo_Nombre");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
