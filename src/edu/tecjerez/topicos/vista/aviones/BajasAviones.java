package edu.tecjerez.topicos.vista.aviones;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class BajasAviones extends JFrame{

    JDesktopPane desktopPaneAltas;
    JInternalFrame ventanaBajas;


    public BajasAviones(){
        desktopPaneAltas = new JDesktopPane();
        ventanaBajas = new JInternalFrame();
        ventanaBajas.setSize(500, 700);
        ventanaBajas.setClosable(true);
        ventanaBajas.setIconifiable(true);
        ventanaBajas.setResizable(true);
        ventanaBajas.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaBajas.getContentPane().setLayout(new FlowLayout());


        JPanel panelCajas = new JPanel();




    }
}
