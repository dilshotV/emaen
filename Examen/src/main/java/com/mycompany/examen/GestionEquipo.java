/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dilsh
 */
public class GestionEquipo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final Color COLOR_FONDO = new Color(245, 247, 250);
    private static final Color COLOR_CABECERA = new Color(33, 37, 41);
    private static final Color COLOR_PANEL = Color.WHITE;

    private JTextField txtCodigo, txtCliente, txtTelefono, txtMarca, txtModelo, txtDescripcion, txtCosto;

    private JButton btnRegistrar, btnEliminar, btnOrdenarcosto, btnModificar, btnLimpiar, btnBuscar, btnordenarcodigo;
    private ArrayList<Equipo> ListaEquipo;

    private JComboBox<EstadoEquipo> comboEstado;
    private JComboBox<TipoEquipo> comboTipo;

    private DefaultTableModel ModeloEquipos;
    private JTable tablaEquipos;

    private int indiceEquipoSeleccionado = -1;

    public GestionEquipo() {

        super("Registro de Equipo");
        ListaEquipo = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COLOR_FONDO);
        setMinimumSize(new Dimension(1120, 760));

       
        add(crearPanelCabecera(), BorderLayout.NORTH);
        JPanel panelCentro = new JPanel(new BorderLayout(0, 12));
        panelCentro.setBorder(new EmptyBorder(12, 20, 12, 20));
        panelCentro.setOpaque(false);

        JPanel panelFormularios = new JPanel(new GridLayout(1, 2, 14, 14));
        panelFormularios.setOpaque(false);

        panelFormularios.add(CrearPanelEquipo());

        panelCentro.add(panelFormularios, BorderLayout.NORTH);
        panelCentro.add(crearPanelTabla(), BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void buscarEquipo() {
        String dato = JOptionPane.showInputDialog(
                this,
                "Ingrese codigo o nombre del cliente o tipo de equipo:"
        );

        if (dato != null && !dato.isEmpty()) {
            boolean encontrado = false;

            for (int i = 0; i < ListaEquipo.size(); i++) {
                Equipo equipo = ListaEquipo.get(i);

                if (String.valueOf(equipo.getCodigoEquipo()).equalsIgnoreCase(dato)
                        || equipo.getNombreCliente().equalsIgnoreCase(dato)
                        || equipo.getTipoEquipo().toString().equalsIgnoreCase(dato)) {

                    JOptionPane.showMessageDialog(this, "Equipo encontrado:\n" + equipo.toString());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún equipo");
            }
        }
    }

    private void registrarEquipo() {

        try {

            String NombreCliente = txtCliente.getText();
            int Codigo = Integer.parseInt(txtCodigo.getText());
            int Costo = Integer.parseInt(txtCosto.getText());
            String Telefono = txtTelefono.getText();
            String Descripcion = txtDescripcion.getText();
            String Marca = txtMarca.getText();
            String Modelo = txtModelo.getText();
            EstadoEquipo Estado = (EstadoEquipo) comboEstado.getSelectedItem();
            TipoEquipo tipo = (TipoEquipo) comboTipo.getSelectedItem();

            Equipo nuevoEquipo = new Equipo();

            nuevoEquipo.setNombreCliente(NombreCliente);
            nuevoEquipo.setCodigoEquipo(Codigo);
            nuevoEquipo.setCostoReparación(Costo);
            nuevoEquipo.setTeléfonoCliente(Telefono);
            nuevoEquipo.setDescripciónProblema(Descripcion);
            nuevoEquipo.setMarca(Marca);
            nuevoEquipo.setModelo(Modelo);
            nuevoEquipo.setEstadodelequipo(Estado);
            nuevoEquipo.setTipoEquipo(tipo);

            ListaEquipo.add(nuevoEquipo);

            ModeloEquipos.addRow(new Object[]{
                NombreCliente,
                Codigo,
                Costo,
                Telefono,
                Descripcion,
                Marca,
                Modelo,
                Estado,
                tipo
            });

            JOptionPane.showMessageDialog(
                    this,
                    "¡Equipo Registrado Correctamente!",
                    "¡Exito! - Registro Equipo",
                    JOptionPane.INFORMATION_MESSAGE
            );
            Dispositivo d = nuevoEquipo;
            JOptionPane.showMessageDialog(
                    this,
                    d.getDescripcion(),
                    "Descripción",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "¡Error de tipo de dato " + e.getMessage(),
                    "¡Error! - Registro Equipo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "¡Error al intentar registrar equipo " + e.getMessage(),
                    "¡Error! - Registro equipo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }

    private void limpiarCampos() {
        txtCliente.setText("");
        txtCodigo.setText("");
        txtCosto.setText("");
        txtTelefono.setText("");
        txtDescripcion.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        comboEstado.setSelectedIndex(0);
        comboTipo.setSelectedIndex(0);

        tablaEquipos.clearSelection();
        indiceEquipoSeleccionado = -1;

        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(true);
    }

    private void eliminarEquipo() {
        int fila = tablaEquipos.getSelectedRow();
        if (fila >= 0) {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Eliminar este equipo?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {

                ListaEquipo.remove(fila);

                ModeloEquipos.removeRow(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Equipo eliminado correctamente",
                        "Eliminación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );

                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un equipo de la tabla para eliminar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void modificarEquipo() {
        
       if (indiceEquipoSeleccionado == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un equipo para modificar.");
        return;
    }

    Equipo eq = ListaEquipo.get(indiceEquipoSeleccionado);
    eq.setNombreCliente(txtCliente.getText());
    eq.setCodigoEquipo(Integer.parseInt(txtCodigo.getText()));
    eq.setCostoReparación(Integer.parseInt(txtCosto.getText()));
    eq.setTeléfonoCliente(txtTelefono.getText());
    eq.setDescripciónProblema(txtDescripcion.getText());
    eq.setMarca(txtMarca.getText());
    eq.setModelo(txtModelo.getText());
    eq.setEstadodelequipo((EstadoEquipo) comboEstado.getSelectedItem());
    eq.setTipoEquipo((TipoEquipo) comboTipo.getSelectedItem());

    refrescarTabla();
    JOptionPane.showMessageDialog(this, "Equipo modificado correctamente.");
    btnModificar.setEnabled(false);
    indiceEquipoSeleccionado = -1; 
}
    

    private JPanel CrearPanelEquipo() {
        JPanel panel = crearPanelFormularios("Datos del Equipo");

        txtCliente = crearCampoTexto("Ingrese nombre del cliente.");
        txtCodigo = crearCampoTexto("Ingrese el codigo.");
        txtCosto = crearCampoTexto("Ingrese el costo");
        txtTelefono = crearCampoTexto("Ingrese el telefono");
        txtDescripcion = crearCampoTexto("Descripcion del dispositivo");
        txtMarca = crearCampoTexto("Ingrese marca");
        txtModelo = crearCampoTexto("Ingrese moddelo");

        comboEstado = new JComboBox<>(EstadoEquipo.values());
        comboTipo = new JComboBox<>(TipoEquipo.values());
        comboEstado.setToolTipText("Seleccione el estado del dispositivo ");
        comboTipo.setToolTipText("Seleccione el tipo de equipo");

        agregarFila(panel, " nombre cliente:", txtCliente);
        agregarFila(panel, " codigo:", txtCodigo);
        agregarFila(panel, " costo:", txtCosto);
        agregarFila(panel, " Telefono:", txtTelefono);
        agregarFila(panel, " Descripcion", txtDescripcion);
        agregarFila(panel, " Marca:", txtMarca);
        agregarFila(panel, " Modelo:", txtModelo);
        agregarFila(panel, " estado:", comboEstado);
        agregarFila(panel, " Tipo:", comboTipo);

        btnRegistrar = crearBoton("Registrar", new Color(46, 125, 50));
        btnRegistrar.addActionListener(this);

        btnEliminar = crearBoton("Eliminar", new Color(198, 40, 40));
        btnEliminar.addActionListener(this);

        btnLimpiar = crearBoton("Limpiar", new Color(96, 125, 139));
        btnLimpiar.addActionListener(this);

        btnModificar = crearBoton("modificar", new Color(20, 110, 139));
        btnModificar.addActionListener(this);

        btnOrdenarcosto = crearBoton("ordenar por costo", new Color(50, 120, 134));
        btnOrdenarcosto.addActionListener(this);

        btnordenarcodigo = crearBoton("Ordenar por Codigo", new Color(70, 130, 180));
        btnordenarcodigo.addActionListener(this);

        btnBuscar = crearBoton("Buscar", new Color(70, 130, 180));
        btnBuscar.addActionListener(this);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));
        panelBotones.setOpaque(false);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnOrdenarcosto);
        panelBotones.add(btnordenarcodigo);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBuscar);
        JPanel panelContenedor = new JPanel(new BorderLayout(0, 10));
        panelContenedor.setOpaque(false);
        panelContenedor.add(panel, BorderLayout.CENTER);
        panelContenedor.add(panelBotones, BorderLayout.SOUTH);

        agregarFila(panel, "", new JLabel(""));

        return panelContenedor;
    }

    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setOpaque(false);

        JLabel lblTabla = new JLabel("Listado de equipos registrados");
        lblTabla.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        lblTabla.setForeground(new Color(55, 71, 79));
        panel.add(lblTabla, BorderLayout.NORTH);

        String[] columnas = {
            "Nombre",
            "Codigo",
            "costo",
            "telefono",
            "descripcion",
            "marca",
            "modelo",
            "Estado",
            "tipo"
        };

        ModeloEquipos = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tablaEquipos = new JTable(ModeloEquipos);
        tablaEquipos.setRowHeight(24);
        tablaEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listenerDoubleClick();

        JScrollPane scroll = new JScrollPane(tablaEquipos);
        scroll.setPreferredSize(new Dimension(800, 260));
        panel.add(scroll);

        return panel;
    }

    private JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        return boton;
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(new Color(55, 71, 79));
        etiqueta.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        return etiqueta;
    }

    private void agregarFila(JPanel panel, String texto, Component componente) {
        panel.add(crearEtiqueta(texto));
        panel.add(componente);
    }

    private JTextField crearCampoTexto(String ayuda) {
        JTextField campo = new JTextField(25);
        campo.setToolTipText(ayuda);
        return campo;
    }

    private JPanel crearPanelFormularios(String titulo) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210)),
                titulo,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font(Font.SANS_SERIF, Font.BOLD, 13),
                new Color(55, 71, 79)
        ));
        panel.setBackground(COLOR_PANEL);
        return panel;
    }

    public JPanel crearPanelCabecera() {
        JPanel panel = new JPanel(new BorderLayout(8, 4));
        panel.setBackground(COLOR_CABECERA);
        panel.setBorder(new EmptyBorder(14, 20, 14, 20));

        JLabel lblTitulo = new JLabel("Registro de equipos");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JLabel lblSubTitulo = new JLabel("Registre, edite y elimine clientes en una sola ventana");
        lblSubTitulo.setForeground(Color.WHITE);
        lblSubTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(lblSubTitulo, BorderLayout.SOUTH);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegistrar) {

            registrarEquipo();
        }

        if (e.getSource() == btnLimpiar) {

            limpiarCampos();
        }
        if (e.getSource() == btnEliminar) {
            eliminarEquipo();
        }
        if (e.getSource() == btnModificar) {
                modificarEquipo();
            }
        
        if (e.getSource() == btnBuscar) {
            buscarEquipo();
        }
        if (e.getSource() == btnordenarcodigo) {
            ListaEquipo.sort(null);
            refrescarTabla();
        }

        if (e.getSource() == btnOrdenarcosto) {
            ListaEquipo.sort(new ComparadorPrecio());
            refrescarTabla();
        }
    }

    private void refrescarTabla() {
        ModeloEquipos.setRowCount(0); 

        for (Equipo eq : ListaEquipo) {
            ModeloEquipos.addRow(new Object[]{
                eq.getNombreCliente(),
                eq.getCodigoEquipo(),
                eq.getCostoReparación(),
                eq.getTeléfonoCliente(),
                eq.getDescripciónProblema(),
                eq.getMarca(),
                eq.getModelo(),
                eq.getEstadodelequipo(),
                eq.getTipoEquipo()
            });
        }
    }

    private void listenerDoubleClick() {
        tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                indiceEquipoSeleccionado = tablaEquipos.getSelectedRow(); 
                if (indiceEquipoSeleccionado != -1) {
                    cargarEquipoFormulario(indiceEquipoSeleccionado);
                    btnModificar.setEnabled(true);
                }
            }
        }
    });
    }

    private void cargarEquipoFormulario(int fila) {
        try {

            indiceEquipoSeleccionado = fila;
            Equipo equipoSeleccionado = ListaEquipo.get(indiceEquipoSeleccionado);

            txtCliente.setText(equipoSeleccionado.getNombreCliente());
            txtCodigo.setText(String.valueOf(equipoSeleccionado.getCodigoEquipo()));
            txtCosto.setText(String.valueOf(equipoSeleccionado.getCostoReparación()));
            txtTelefono.setText(equipoSeleccionado.getTeléfonoCliente());
            txtDescripcion.setText(equipoSeleccionado.getDescripciónProblema());
            txtMarca.setText(equipoSeleccionado.getMarca());
            txtModelo.setText(equipoSeleccionado.getModelo());

            EstadoEquipo estado = equipoSeleccionado.getEstadodelequipo();
            comboEstado.setSelectedItem(estado);

            TipoEquipo tipo = equipoSeleccionado.getTipoEquipo();
            comboTipo.setSelectedItem(tipo);

            btnLimpiar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnRegistrar.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "¡Error al cargar equipo seleccionado. " + e.getMessage(),
                    "¡Error! - Registro Equipos",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

}
