
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/basejava";
        try{
            
            Connection con=DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("select Nombre from equipo");


            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        

    }
}
