import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class login {
    public JPanel login;
    private JFormattedTextField usuarioText;
    public JPasswordField passText;
    private JButton button1;

    public login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pas = new String(passText.getPassword());
                    String user, contrasena;
                    if (!usuarioText.getText().isEmpty() && !pas.isEmpty()) {


                        String DBurl = "jdbc:mysql://localhost:3307/usuario";
                        String DBusername = "root";
                        String DBpassword = "";
                        java.sql.Connection connection = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection(DBurl, DBusername, DBpassword);
                            Statement statement;
                            statement = connection.createStatement();
                            java.sql.ResultSet resultSet;
                            resultSet = statement.executeQuery("SELECT * FROM usuarios");

                            while (resultSet.next()){
                                user = resultSet.getString("usuarios");
                                contrasena = resultSet.getString("contrasena");
                                System.out.println("usuario: " + user +  " contrasena: " + contrasena);

                                contrasena = resultSet.getString("contrasena");
                                if (user.equals(usuarioText.getText()) || contrasena.equals(pas)) {

                                    JFrame nuevaPag = new JFrame("nueva Pagina");
                                    nuevaPag.setContentPane(new nuevaPagina().nuevo);
                                    nuevaPag.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                                    nuevaPag.setVisible(true);
                                    nuevaPag.setSize(500, 200);
                                    Main.loginn.dispose();


                                }
                            }
                        } catch (Exception e1) {
                            System.out.println("No vale");
                        }

                    }
                }catch (Exception e1){
                    System.out.println("No valio");

                }
            }
        });
    }
}
