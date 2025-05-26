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

    JToolBar toolbar;

    JButton btnToolbarSalir, btnToolbarLogin;

    public VentanaInicio(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dane County Airport");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(31, 70, 96));
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(7, 41, 50));
        menuBar.setOpaque(true);

//----------------------- MENU AVIONES-------------------–––––––---––––––––--------
        menuAviones = new JMenu("Aviones");
        menuAviones.setMnemonic(KeyEvent.VK_W);

        itemAltasTraficadores = new JMenuItem("Agregar");
        itemAltasTraficadores.setMnemonic(KeyEvent.VK_A);
        itemAltasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuAviones.add(itemAltasTraficadores);
        itemAltasTraficadores.addActionListener(this);

        itemBajasTraficadores = new JMenuItem("Eliminar");
        itemBajasTraficadores.setMnemonic(KeyEvent.VK_E);
        itemBajasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuAviones.add(itemBajasTraficadores);
        itemBajasTraficadores.addActionListener(this);

        itemModificacionesTraficadores = new JMenuItem("Modificar");
        itemModificacionesTraficadores.setMnemonic(KeyEvent.VK_M);
        itemModificacionesTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        menuAviones.add(itemModificacionesTraficadores);
        itemModificacionesTraficadores.addActionListener(this);

        itemConsultasTraficadores = new JMenuItem("Buscar");
        itemConsultasTraficadores.setMnemonic(KeyEvent.VK_B);
        itemConsultasTraficadores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        menuAviones.add(itemConsultasTraficadores);
        itemConsultasTraficadores.addActionListener(this);

        menuBar.add(menuAviones);

        //------------- final menu aviones -----------

//----------------------- MENU EMPLEADOS ----------------------------
            menuEmpleados = new JMenu("Empleados");

                    menuTecnicos= new JMenu("Técnicos");
                    menuTecnicos.setMnemonic(KeyEvent.VK_Q);

                        itemAltasTecnicos = new JMenuItem("Agregar");
                        menuTecnicos.add(itemAltasTecnicos);
                        itemAltasTecnicos.addActionListener(this);

                        itemBajasTecnicos = new JMenuItem("Eliminar");
                        menuTecnicos.add(itemBajasTecnicos);
                        itemBajasTecnicos.addActionListener(this);

                        itemModificacionesTecnicos = new JMenuItem("Modificar");
                        menuTecnicos.add(itemModificacionesTecnicos);
                        itemModificacionesTecnicos.addActionListener(this);

                        itemConsultasTecnicos = new JMenuItem("Buscar");
                        menuTecnicos.add(itemConsultasTecnicos);
                        itemConsultasTecnicos.addActionListener(this);

                menuEmpleados.add(menuTecnicos);

                        menuTraficadores= new JMenu("Controladores Aéreos");

                        itemAltasTraficadores = new JMenuItem("Agregar");
                        menuTraficadores.add(itemAltasTraficadores);
                        itemAltasTraficadores.addActionListener(this);

                        itemBajasTraficadores = new JMenuItem("Eliminar");
                        menuTraficadores.add(itemBajasTraficadores);
                        itemBajasTraficadores.addActionListener(this);

                        itemModificacionesTraficadores = new JMenuItem("Modificar");
                        menuTraficadores.add(itemModificacionesTraficadores);
                        itemModificacionesTraficadores.addActionListener(this);

                        itemConsultasTraficadores = new JMenuItem("Buscar");
                        menuTraficadores.add(itemConsultasTraficadores);
                        itemConsultasTraficadores.addActionListener(this);

                        menuEmpleados.add(menuTraficadores);

            menuBar.add(menuEmpleados);


        setJMenuBar(menuBar);

//----------- final menu empleados-----------------

        toolbar = new JToolBar(JToolBar.VERTICAL);

            JLabel logo= new JLabel();
            logo.setHorizontalAlignment(SwingConstants.CENTER);
            logo.setIcon(new ImageIcon("./imagenes/logo.png"));
            logo.setPreferredSize(new Dimension(150, 150));
            logo.setAlignmentX(Component.CENTER_ALIGNMENT);
            toolbar.setBackground(new Color(7, 41, 50));
            toolbar.add(logo, BorderLayout.WEST);

            //btn para salir --------------
            btnToolbarSalir = new JButton();
            btnToolbarSalir.setBackground(new Color(7, 41, 50));
            btnToolbarSalir.setIcon(new ImageIcon("./imagenes/toolbarSalir.png"));
            toolbar.add(btnToolbarSalir);
            btnToolbarSalir.addActionListener(this);
            btnToolbarSalir.setToolTipText("Salir del programa.");

            //btn para regresar al login ---------
            btnToolbarLogin = new JButton();
            btnToolbarLogin.setIcon(new ImageIcon("./imagenes/toolbarLogin.png"));

            add(toolbar, BorderLayout.WEST);
            toolbar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
