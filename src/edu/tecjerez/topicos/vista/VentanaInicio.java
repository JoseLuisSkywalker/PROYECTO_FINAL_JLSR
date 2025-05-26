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

    JButton btnToolbarSalir, btnConsulta, btnAgregar, btnModificar, btnBorrar;

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

        // toolbar -----------------

        toolbar = new JToolBar(JToolBar.VERTICAL);

            JLabel logo= new JLabel();
            logo.setHorizontalAlignment(SwingConstants.CENTER);
            logo.setIcon(new ImageIcon("./imagenes/logo.png"));
            logo.setPreferredSize(new Dimension(150, 150));
            logo.setAlignmentX(Component.CENTER_ALIGNMENT);
            toolbar.setBackground(new Color(7, 41, 50));
            toolbar.add(logo);

            //btn consulta (jframe predeterminado) -------------
            ImageIcon iconoConsulta = new ImageIcon("./imagenes/consultas.png");
            Image imagenConsulta = iconoConsulta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon iconoConsultaEscalado = new ImageIcon(imagenConsulta);

            btnConsulta = new JButton(iconoConsultaEscalado);
            btnConsulta.setBackground(new Color(7, 41, 50));
            btnConsulta.setToolTipText("Consultar");
            btnConsulta.setBorderPainted(false);
            btnConsulta.setFocusPainted(false);
            btnConsulta.setContentAreaFilled(true);
            btnConsulta.setPreferredSize(new Dimension(64, 64));
            btnConsulta.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnConsulta.addActionListener(this);


            //btn agregar-----------
        ImageIcon iconoAgregar = new ImageIcon("./imagenes/agregar.png");
        Image imagenAgregar = iconoAgregar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoAgregarEscalado = new ImageIcon(imagenAgregar);

        btnAgregar = new JButton(iconoAgregarEscalado);
        btnAgregar.setBackground(new Color(7, 41, 50));
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setContentAreaFilled(true);
        btnAgregar.setPreferredSize(new Dimension(64, 64));
        btnAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAgregar.addActionListener(this);


        // btn borrar ----------------
        ImageIcon iconoBorrar = new ImageIcon("./imagenes/eliminar.png");
        Image imagenBorrar = iconoBorrar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoBorrarEscalado = new ImageIcon(imagenBorrar);

        btnBorrar = new JButton(iconoBorrarEscalado);
        btnBorrar.setBackground(new Color(7, 41, 50));
        btnBorrar.setToolTipText("Eliminar");
        btnBorrar.setBorderPainted(false);
        btnBorrar.setFocusPainted(false);
        btnBorrar.setContentAreaFilled(true);
        btnBorrar.setPreferredSize(new Dimension(64, 64));
        btnBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBorrar.addActionListener(this);


        //btn modificaciones ----------
        ImageIcon iconoModificar = new ImageIcon("./imagenes/modificar.png");
        Image imagenModificar = iconoModificar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon iconoModificarEscalado = new ImageIcon(imagenModificar);

        btnModificar = new JButton(iconoModificarEscalado);
        btnModificar.setBackground(new Color(7, 41, 50));
        btnModificar.setToolTipText("modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.setFocusPainted(false);
        btnModificar.setContentAreaFilled(true);
        btnModificar.setPreferredSize(new Dimension(64, 64));
        btnModificar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnModificar.addActionListener(this);


            //btn para salir --------------
            ImageIcon iconoSalir = new ImageIcon("./imagenes/salir.png");
            Image imagenSalir = iconoSalir.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imagenSalir);

            btnToolbarSalir = new JButton(iconoEscalado);
            btnToolbarSalir.setBackground(new Color(7, 41, 50));
            btnToolbarSalir.setToolTipText("Salir del programa.");
            btnToolbarSalir.setBorderPainted(false);
            btnToolbarSalir.setFocusPainted(false);
            btnToolbarSalir.setContentAreaFilled(true);
            btnToolbarSalir.setPreferredSize(new Dimension(64, 64));
            btnToolbarSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnToolbarSalir.addActionListener(this);

            toolbar.add(btnConsulta);
            toolbar.add(Box.createVerticalStrut(30));
            toolbar.add(btnAgregar);
            toolbar.add(Box.createVerticalStrut(30));
            toolbar.add(btnBorrar);
            toolbar.add(Box.createVerticalStrut(30));
            toolbar.add(btnModificar);
            toolbar.add(Box.createVerticalStrut(30));
            toolbar.add(btnToolbarSalir);


            toolbar.setFloatable(false);
            toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));
            toolbar.add(Box.createVerticalGlue());
            add(toolbar, BorderLayout.WEST);
            toolbar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
