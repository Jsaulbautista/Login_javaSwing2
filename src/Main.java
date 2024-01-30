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


    }
}