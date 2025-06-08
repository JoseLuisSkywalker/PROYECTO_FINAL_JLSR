import vista.VentanaInicio;
import vista.VentanaLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new VentanaInicio();

            }
        });
    }
}