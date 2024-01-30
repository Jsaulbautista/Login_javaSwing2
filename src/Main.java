import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    static JFrame loginn = new JFrame("Iniciar Sesion");
    public static void main(String[] args) {
        loginn.setContentPane(new login().login);
        loginn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginn.setVisible(true);
        loginn.setSize(400,200 );


        String DBurl = "jdbc:mysql://localhost:3306/estudiantes";
        String DBusername = "root";
        String DBpassword = "";
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            Statement statement;
            statement = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM calificaciones");
            int id;
            String nombre, cedula;
            float calificacion_1, calificacion_2;
            while (resultSet.next()){
                id = resultSet.getInt("id");
                nombre = resultSet.getString("username");
                cedula = resultSet.getString("cedula");
                calificacion_1 = resultSet.getFloat("calificacion1");
                calificacion_2 = resultSet.getFloat("calificacion2");
                System.out.println("ID: "+id+" Nombre: "+nombre+" Cédula: "+cedula+" Calificación 1: "+calificacion_1+" Califcación 2: "+calificacion_2);
            }

        }
        catch(Exception e){
            System.out.println("ex");
        }

    }
}