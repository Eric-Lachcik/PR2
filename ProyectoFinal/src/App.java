
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        circuitos();
    }

    public static void Top10() {
        JFrame frame = new JFrame("Clasificacion Top 10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        DefaultTableModel tableTop10 = new DefaultTableModel();

        String columnTop10[] = {"Posicion", "Puntos", "Piloto_Id", "Equipo_Nombre"}; 

        tableTop10.setColumnIdentifiers(columnTop10);

        JTable Top10 = new JTable(tableTop10);
        JScrollPane Pane10 = new JScrollPane(Top10);

        frame.add(Pane10);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        try {
            String url = "jdbc:mysql://localhost:3306/basejava";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("select * from clasificacion");
            tableTop10.setRowCount(0);

            while (rs.next()) {
                String Posicion = String.valueOf(rs.getInt("Posicion"));
                String Puntos = String.valueOf(rs.getInt("Puntos"));
                String Nombre = rs.getString("Piloto_Id");
                String Equipo_Nombre = rs.getString("Equipo_Nombre");

                tableTop10.addRow(new Object[]{Posicion, Puntos, Nombre, Equipo_Nombre});
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void Equipos(){
        JFrame frame = new JFrame("Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        DefaultTableModel tableEquipos = new DefaultTableModel();

        String columnEquipos[] = {"Nombre", "Director_Deportivo"}; 

        tableEquipos.setColumnIdentifiers(columnEquipos);

        JTable Equipos = new JTable(tableEquipos);
        JScrollPane PaneEquipos = new JScrollPane(Equipos);

        frame.add(PaneEquipos);
        frame.pack();
        frame.setSize(600, 349);
        frame.setVisible(true);
        try {
            String url = "jdbc:mysql://localhost:3306/basejava";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("select * from equipo");
            tableEquipos.setRowCount(0);

            while (rs.next()) {
                String Nombre = rs.getString("Nombre");
                String Director_Deportivo = rs.getString("Director_Deportivo");
                

                tableEquipos.addRow(new Object[]{Nombre, Director_Deportivo});
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void Pilotos(){
        JFrame frame = new JFrame("Pilotos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        DefaultTableModel tablePilotos = new DefaultTableModel();

        String columnPilotos[] = {"Id", "Nombre", "Equipo_Nombre"};
        
        tablePilotos.setColumnIdentifiers(columnPilotos);

        JTable Pilotos = new JTable(tablePilotos);
        JScrollPane PanePilotos = new JScrollPane(Pilotos);
        JPanel panelPiloto = new JPanel();
        panelPiloto.add(PanePilotos);
        frame.add(panelPiloto);
        // frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
       
        try {
            String url = "jdbc:mysql://localhost:3306/basejava";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("select * from pilotos");
            tablePilotos.setRowCount(0);

            while (rs.next()) {
                String Id = rs.getString("Id");
                String Nombre = rs.getString("Nombre");
                String Equipo_Nombre = rs.getString("Equipo_Nombre");

                tablePilotos.addRow(new Object[]{Id, Nombre, Equipo_Nombre});
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void circuitos(){
        JFrame frame = new JFrame("Circuitos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        DefaultTableModel tableCircuitos = new DefaultTableModel();

        String columnCircuitos[] = {"Id", "Nombre", "Fecha", "Piloto_Id"}; 

        tableCircuitos.setColumnIdentifiers(columnCircuitos);

        JTable Circuitos = new JTable(tableCircuitos);
        JScrollPane PaneCircuitos = new JScrollPane(Circuitos);

        frame.add(PaneCircuitos);
        frame.pack();
        frame.setSize(600,643);
        frame.setVisible(true);
        try {
            String url = "jdbc:mysql://localhost:3306/basejava";
            Connection con = DriverManager.getConnection(url, "root", "");

            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("select * from circuitos");
            tableCircuitos.setRowCount(0);

            while (rs.next()) {
                String Id = rs.getString("Id");
                String Nombre = rs.getString("Nombre");
                String Fecha = rs.getString("Fecha");
                String Piloto_Id = rs.getString("Piloto_Id");

                tableCircuitos.addRow(new Object[]{Id, Nombre, Fecha, Piloto_Id});
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
