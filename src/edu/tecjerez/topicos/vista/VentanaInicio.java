package edu.tecjerez.topicos.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VentanaInicio extends JFrame implements ActionListener {

    JMenu menuAltasTecnico;
    JMenuItem itemAltas;

    public VentanaInicio(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Adler International Airport");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(31, 70, 96));
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
            menuAltasTecnico = new JMenu("Agregar Técnico");
            menuAltasTecnico.setMnemonic(KeyEvent.VK_Q);

                itemAltas = new JMenuItem("Agregar Técnico");
                itemAltas.setMnemonic(KeyEvent.VK_A);
                itemAltas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
                menuAltasTecnico.add(itemAltas);
                itemAltas.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
