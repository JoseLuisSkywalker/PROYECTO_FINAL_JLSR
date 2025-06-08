package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JButton botonLogin;

    public VentanaLogin() {
        setTitle("Ventana de Login");
        setSize(250, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(214, 182, 237, 255));

        JLabel txtUsuario = new JLabel("Usuario:");
        campoUsuario = new JTextField(10);
        JLabel txtPassword = new JLabel("Contraseña:");
        campoPassword = new JPasswordField(10);

        botonLogin = new JButton("Iniciar sesión");

        add(txtUsuario);
        add(campoUsuario);
        add(txtPassword);
        add(campoPassword);
        add(new JLabel());
        add(botonLogin);

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String password = campoPassword.getText();

                if(usuario.equals("joseluis") && password.equals("boom")) {
                    dispose();
                    new VentanaInicio();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            }
        });

        setVisible(true);
    }
}