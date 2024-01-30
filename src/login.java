import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    public JPanel login;
    private JFormattedTextField usuarioText;
    private JPasswordField passText;
    private JButton button1;

    public login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame nuevaPag = new JFrame("nueva Pagina");
                nuevaPag.setContentPane(new nuevaPagina().nuevo);
                nuevaPag.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                nuevaPag.setVisible(true);
                nuevaPag.setSize(500,200);

                Main.loginn.dispose();
            }
        });
    }
}
