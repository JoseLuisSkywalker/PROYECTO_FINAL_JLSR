package edu.tecjerez.topicos.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VentanaInicio extends JFrame implements ActionListener {

    JMenu menuEmpleados, menuAviones;
    //-------------- ITEMS EMPLEADOS ---------------
    JMenu menuTraficadores, menuTecnicos;

    //-------------- ITEMS DE LOS ITEMS EMPLEADOS ---------------------
    JMenuItem itemAltasTecnicos, itemBajasTecnicos, itemModificacionesTecnicos, itemConsultasTecnicos;
    JMenuItem itemAltasTraficadores, itemBajasTraficadores, itemModificacionesTraficadores, itemConsultasTraficadores;
    //--------------------

    public VentanaInicio(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dane County Airport");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(31, 70, 96));
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();

//----------------------- MENU EMPLEADOS ----------------------------
            menuEmpleados = new JMenu("Empleados");

                    menuTecnicos= new JMenu("Técnicos");
                    menuTecnicos.setMnemonic(KeyEvent.VK_Q);

                        itemAltasTecnicos = new JMenuItem("Agregar");
                        itemAltasTecnicos.setMnemonic(KeyEvent.VK_A);
                        itemAltasTecnicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
                        menuTecnicos.add(itemAltasTecnicos);
                        itemAltasTecnicos.addActionListener(this);

                        itemBajasTecnicos = new JMenuItem("Eliminar");
                        itemBajasTecnicos.setMnemonic(KeyEvent.VK_E);
                        itemBajasTecnicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
                        menuTecnicos.add(itemBajasTecnicos);
                        itemBajasTecnicos.addActionListener(this);

                        itemModificacionesTecnicos = new JMenuItem("Modificar");
                        itemModificacionesTecnicos.setMnemonic(KeyEvent.VK_M);
                        itemModificacionesTecnicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
                        menuTecnicos.add(itemModificacionesTecnicos);
                        itemModificacionesTecnicos.addActionListener(this);

                        itemConsultasTecnicos = new JMenuItem("Buscar");
                        itemConsultasTecnicos.setMnemonic(KeyEvent.VK_C);
                        itemConsultasTecnicos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
                        menuTecnicos.add(itemConsultasTecnicos);
                        itemConsultasTecnicos.addActionListener(this);

                menuEmpleados.add(menuTecnicos);
            menuBar.add(menuEmpleados);

        setJMenuBar(menuBar);



            //----------------------- MENU AVIONES-------------------–––––––---––––––––--------
            menuAviones = new JMenu("Aviones");
            menuAviones.setMnemonic(KeyEvent.VK_W);

                itemAltasTraficadores = new JMenuItem("Agregar");
                itemAltasTraficadores.setMnemonic(KeyEvent.VK_R);
                itemAltasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
                menuAviones.add(itemAltasTraficadores);
                itemAltasTraficadores.addActionListener(this);

                itemBajasTraficadores = new JMenuItem("Eliminar");
                itemBajasTraficadores.setMnemonic(KeyEvent.VK_F);
                itemBajasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
                menuAviones.add(itemBajasTraficadores);
                itemBajasTraficadores.addActionListener(this);

                itemModificacionesTraficadores = new JMenuItem("Modificar");
                itemModificacionesTraficadores.setMnemonic(KeyEvent.VK_T);
                itemModificacionesTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
                menuAviones.add(itemModificacionesTraficadores);
                itemModificacionesTraficadores.addActionListener(this);

                itemConsultasTraficadores = new JMenuItem("Buscar");
                itemConsultasTraficadores.setMnemonic(KeyEvent.VK_G);
                itemConsultasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
                menuAviones.add(itemConsultasTraficadores);
                itemConsultasTraficadores.addActionListener(this);

            menuBar.add(menuAviones);

//para agregar la barra de
        setJMenuBar(menuBar);

/*
anotaciones:

Tablas que en teoría debe de tener el proyecto:

1. tecnicos: (aunque la duda es considerarlo dentro de empleados, porque el tecnico tendría mas elementos de especialización
que un empleado)

2. Aviones: (esta tabla registra todos los aviones el numero de modelo de avion y los tecnicos que se especializan en esos modelos,
la fecha de la utlima examinación de avion y el nombre del tecnico que la examino)

3. Empleados / Union: (En estre se registra todo el personal y el puesto que ocupan, por ello mi duda de poner a los tecnicos aqui
o darle su propio espacio a ellos)
 */



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
