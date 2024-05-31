
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
       Top10();
    }

    public static void Top10() {
        JFrame frame = new JFrame("Clasificación Top 10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    
        DefaultTableModel tableTop10 = new DefaultTableModel();
        String columnTop10[] = {"Posicion", "Puntos", "Piloto_Id", "Equipo_Nombre"}; 
        tableTop10.setColumnIdentifiers(columnTop10);
        JTable Top10 = new JTable(tableTop10);
        JScrollPane Pane10 = new JScrollPane(Top10);
        frame.add(Pane10, BorderLayout.CENTER);
        
        String url = "jdbc:mysql://localhost:3306/basejava";
        try (Connection con = DriverManager.getConnection(url, "root", "")) {
            Statement myst = con.createStatement();
            ResultSet rs = myst.executeQuery("SELECT * FROM clasificacion");
            while (rs.next()) {
                String posicion = rs.getString("Posicion");
                String puntos = rs.getString("Puntos");
                String piloto_id = rs.getString("Piloto_Id");
                String equipo_nombre = rs.getString("Equipo_Nombre");
                tableTop10.addRow(new Object[]{posicion, puntos, piloto_id, equipo_nombre});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        JButton sortButton = new JButton("Ordenar Puntos");
       
        sortButton.addActionListener(new ActionListener() {
            boolean ascending = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                
    
                String url = "jdbc:mysql://localhost:3306/basejava";
                try (Connection con = DriverManager.getConnection(url, "root", "")) {
                    Statement myst = con.createStatement();
                    String order = ascending ? "ASC" : "DESC";
                    ResultSet rs = myst.executeQuery("select * from clasificacion" + " ORDER BY Puntos " + order);
                    tableTop10.setRowCount(0);
    
                    while (rs.next()) {
                        String posicion = rs.getString("Posicion");
                        String puntos = rs.getString("Puntos");
                        String piloto_id = rs.getString("Piloto_Id");
                        String equipo_nombre = rs.getString("Equipo_Nombre");
                        tableTop10.addRow(new Object[]{posicion, puntos, piloto_id, equipo_nombre});
                    }
    
                    ascending = !ascending; // Reverse the order for the next click
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    
        frame.add(sortButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
    public static void Equipos(){
        JFrame frame = new JFrame("Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        DefaultTableModel tableEquipos = new DefaultTableModel();

        String columnEquipos[] = {"Nombre", "Director_Deportivo"}; 

        tableEquipos.setColumnIdentifiers(columnEquipos);

        JTable Equipos = new JTable(tableEquipos);
      
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
        JScrollPane PaneEquipos = new JScrollPane(Equipos);
        frame.add(PaneEquipos, BorderLayout.CENTER);

        JButton addButton = new JButton("Añadir Equipo");
        addButton.setPreferredSize(new Dimension(100, 50)); 
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Añadir");
                addFrame.setLayout(new GridLayout(3, 2));

                JLabel nameLabel = new JLabel("Nombre Equipo:");
                JTextField nameField = new JTextField();
                JLabel directorLabel = new JLabel("Director Deportivo:");
                JTextField directorField = new JTextField();

                JButton submitButton = new JButton("Submit");
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = nameField.getText();
                        String director = directorField.getText();

                        try {
                            String url = "jdbc:mysql://localhost:3306/basejava";
                            Connection con = DriverManager.getConnection(url, "root", "");

                            String sql = "INSERT INTO equipo (Nombre, Director_Deportivo) VALUES (?, ?)";
                            PreparedStatement inst = con.prepareStatement(sql);
                            inst.setString(1, name);
                            inst.setString(2, director);
                            inst.executeUpdate();
                            

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }

                        nameField.setText("");
                        directorField.setText("");
                        addFrame.dispose();
                    }
                });

                addFrame.add(nameLabel);
                addFrame.add(nameField);
                addFrame.add(directorLabel);
                addFrame.add(directorField);
                addFrame.add(submitButton);

                addFrame.pack();
                addFrame.setVisible(true);
            }
        
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(600, 349);
        frame.setVisible(true);
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
        frame.pack();
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
