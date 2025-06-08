package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class VentanaInicio extends JFrame implements ActionListener {
    JDesktopPane desktopPane;

    JMenuItem itemAltasAviones, itemBajasAviones, itemModificacionesAviones, itemConsultasAviones;
    JMenuItem itemAltasTecnicos, itemBajasTecnicos, itemModificacionesTecnicos, itemConsultasTecnicos;
    JMenuItem itemAltasTraficadores, itemBajasTraficadores, itemModificacionesTraficadores, itemConsultasTraficadores;


    JMenu menuEmpleados, menuAviones;
    JMenu menuTraficadores, menuTecnicos;


    JToolBar toolbar;
    JButton btnToolbarSalir, btnConsulta, btnAgregar, btnModificar, btnBorrar;

    AltasAviones IF_Altas = new AltasAviones();
    BajasAviones IF_Bajas = new BajasAviones();
    ConsultasAviones IF_Consultas = new ConsultasAviones();
    CambiosAviones IF_Cambios = new CambiosAviones();


    public VentanaInicio(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dane County Airport");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(31, 70, 96));
        add(desktopPane, BorderLayout.CENTER);



        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(7, 41, 50));
        menuBar.setOpaque(true);

 // ----------------–––––––––––––––––––––––––––––––––––––––- menu aviones principio
        menuAviones = new JMenu("Aviones");
        menuAviones.setMnemonic(KeyEvent.VK_W);

        itemAltasAviones = new JMenuItem("Agregar");
        itemAltasAviones.setMnemonic(KeyEvent.VK_A);
        itemAltasAviones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuAviones.add(itemAltasAviones);
        itemAltasAviones.addActionListener(this);

        itemBajasAviones = new JMenuItem("Eliminar");
        itemBajasAviones.setMnemonic(KeyEvent.VK_E);
        itemBajasAviones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuAviones.add(itemBajasAviones);
        itemBajasAviones.addActionListener(this);

        itemModificacionesAviones = new JMenuItem("Modificar");
        itemModificacionesAviones.setMnemonic(KeyEvent.VK_M);
        itemModificacionesAviones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        menuAviones.add(itemModificacionesAviones);
        itemModificacionesAviones.addActionListener(this);

        itemConsultasAviones = new JMenuItem("Buscar");
        itemConsultasAviones.setMnemonic(KeyEvent.VK_B);
        itemConsultasAviones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        menuAviones.add(itemConsultasAviones);
        itemConsultasAviones.addActionListener(this);

        menuBar.add(menuAviones);
//------------------------------------------------------------- menu aviones fin

//-------------------------------------------------- menu empleados principio
        menuEmpleados = new JMenu("Empleados");

        menuTecnicos = new JMenu("Técnicos");
        menuTecnicos.setMnemonic(KeyEvent.VK_Q);

        itemAltasTecnicos = new JMenuItem("Agregar");
        menuTecnicos.add(itemAltasTecnicos);

        itemBajasTecnicos = new JMenuItem("Eliminar");
        menuTecnicos.add(itemBajasTecnicos);

        itemModificacionesTecnicos = new JMenuItem("Modificar");
        menuTecnicos.add(itemModificacionesTecnicos);

        itemConsultasTecnicos = new JMenuItem("Buscar");
        menuTecnicos.add(itemConsultasTecnicos);


        menuEmpleados.add(menuTecnicos);

        menuTraficadores = new JMenu("Controladores Aéreos");

        itemAltasTraficadores = new JMenuItem("Agregar");
        menuTraficadores.add(itemAltasTraficadores);

        itemBajasTraficadores = new JMenuItem("Eliminar");
        menuTraficadores.add(itemBajasTraficadores);

        itemModificacionesTraficadores = new JMenuItem("Modificar");
        menuTraficadores.add(itemModificacionesTraficadores);

        itemConsultasTraficadores = new JMenuItem("Buscar");
        menuTraficadores.add(itemConsultasTraficadores);

        menuEmpleados.add(menuTraficadores);

        menuBar.add(menuEmpleados);
//--------------------–––––––––––––––––menu empleados fin

        setJMenuBar(menuBar);


//------------------------------ tool bar principio
        toolbar = new JToolBar(JToolBar.VERTICAL);

        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon("./imagenes/logo.png"));
        logo.setPreferredSize(new Dimension(150, 150));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        toolbar.setBackground(new Color(7, 41, 50));
        toolbar.add(logo);

        //btn consulta  -------------
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
        toolbar.setVisible(true);
//------------------------------------- tool bar fin

        getContentPane().add(toolbar, BorderLayout.WEST);
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        //para que aparesca bien bonito
        desktopPane.add(IF_Altas);
        IF_Altas.toFront();

        //para que aparesca
        desktopPane.add(IF_Bajas);
        IF_Bajas.toFront();

        //para que aparesca consultas
        desktopPane.add(IF_Consultas);
        IF_Consultas.toFront();

        //para que aparesca modificaciones
        desktopPane.add(IF_Cambios);
        IF_Cambios.toFront();

        setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        IF_Altas.setVisible(false);
        IF_Bajas.setVisible(false);
        IF_Cambios.setVisible(false);
        IF_Consultas.setVisible(false);


        // si se presiona boton o item de menu agregar
        if(componente == itemAltasAviones || componente == btnAgregar){
            //asegurate que pongas los demas metodos para actualizar tabla.

            //visibilidad en el desktop pane
            if (!IF_Altas.isVisible()) {
                IF_Altas.setVisible(true);
                IF_Altas.toFront();
            }

        }
        // si se presiona boton o itme de menu borrar
        if(componente == itemBajasAviones || componente == btnBorrar){
            //jose luis del futuro: agrega validación aqui.

            //visibilidad en el desk...
            if (!IF_Bajas.isVisible()) {
                IF_Bajas.setVisible(true);
                IF_Bajas.toFront();

            }

        }


        // si se presiona boton o item de menu consultar
        if(componente == itemConsultasAviones || componente == btnConsulta){

            if (!IF_Consultas.isVisible()) {
                IF_Consultas.setVisible(true);
                IF_Consultas.toFront();

            }

        }

        // si se presiona boton o item de menu modificar
        if(componente == itemModificacionesAviones || componente == btnModificar){
            if(!IF_Cambios.isVisible()){
                IF_Cambios.setVisible(true);
                IF_Consultas.toFront();
            }



        }

        if(componente == btnToolbarSalir){
            System.exit(0);

        }




    }
}


