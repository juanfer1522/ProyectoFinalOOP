/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Modelo.*;

/**
 *
 * @author Juanfer
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class UsaGUIVenta extends JFrame {

    private ArrayList<Venta> datosVentas;
    private ArrayList<Cliente> datosClientes;

    private JTextArea areaResultados;

    private JButton btnCrearVenta;
    private JButton btnConsultarTodas;
    private JButton btnConsultarNumero;
    private JButton btnConsultarPosicion;
    private JButton btnConsultarEstado;
    private JButton btnConsultarCategoria;
    private JButton btnActualizarVenta;
    private JButton btnGuardarVentas;
    private JButton btnRecuperarVentas;
    private JButton btnGuardarClientes;
    private JButton btnRecuperarClientes;

    public UsaGUIVenta() {

        datosVentas = new ArrayList<>();
        datosClientes = new ArrayList<>();

        setTitle("Sistema Agencia Turística");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        iniciarComponentes();

        setVisible(true);
    }

    private void iniciarComponentes() {

        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();

        panelBotones.setLayout(
                new GridLayout(6, 2, 10, 10)
        );

        btnCrearVenta = new JButton("Crear Nueva Venta");
        btnConsultarTodas = new JButton("Consultar Todas");
        btnConsultarNumero = new JButton("Consultar Númeroo");
        btnConsultarPosicion = new JButton("Consultar Posición");
        btnConsultarEstado = new JButton("Consultar Estadoss");
        btnConsultarCategoria = new JButton("Consultar Categoría");
        btnActualizarVenta = new JButton("Actualizar Venta");
        btnGuardarVentas = new JButton("Guardar Ventas");
        btnRecuperarVentas = new JButton("Recuperar Ventass");
        btnGuardarClientes = new JButton("Guardar Clientess");
        btnRecuperarClientes = new JButton("Recuperar Clientes");

        panelBotones.add(btnCrearVenta);
        panelBotones.add(btnConsultarTodas);
        panelBotones.add(btnConsultarNumero);
        panelBotones.add(btnConsultarPosicion);
        panelBotones.add(btnConsultarEstado);
        panelBotones.add(btnConsultarCategoria);
        panelBotones.add(btnActualizarVenta);
        panelBotones.add(btnGuardarVentas);
        panelBotones.add(btnRecuperarVentas);
        panelBotones.add(btnGuardarClientes);
        panelBotones.add(btnRecuperarClientes);

        add(panelBotones, BorderLayout.NORTH);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(areaResultados);

        add(scroll, BorderLayout.CENTER);

        // CREAR VENTA
        btnCrearVenta.addActionListener(e -> {
            crearNuevaVenta(datosVentas);
        });

        // CONSULTAR TODAS
        btnConsultarTodas.addActionListener(e -> {

            areaResultados.setText(
                    consultarTodasVentas(datosVentas)
            );
        });

        // CONSULTAR NÚMERO
        btnConsultarNumero.addActionListener(e -> {

            String entrada =
                    JOptionPane.showInputDialog(
                            "Ingrese número venta"
                    );

            if (entrada != null &&
                    !entrada.isEmpty()) {

                int numero =
                        Integer.parseInt(entrada);

                areaResultados.setText(
                        consultarVentaDadoNumero(
                                datosVentas,
                                numero
                        )
                );
            }
        });

        // CONSULTAR POSICIÓN
        btnConsultarPosicion.addActionListener(e -> {

            String entrada =
                    JOptionPane.showInputDialog(
                            "Ingrese P o U"
                    );

            if (entrada != null &&
                    !entrada.isEmpty()) {

                char posicion =
                        entrada.toUpperCase().charAt(0);

                areaResultados.setText(
                        consultarVentaDadaPosicion(
                                datosVentas,
                                posicion
                        )
                );
            }
        });

        // CONSULTAR ESTADO
        btnConsultarEstado.addActionListener(e -> {

            String entrada =
                    JOptionPane.showInputDialog(
                            "Ingrese estado A/C/P"
                    );

            if (entrada != null &&
                    !entrada.isEmpty()) {

                char estado =
                        entrada.toUpperCase().charAt(0);

                areaResultados.setText(
                        consultarVentasDadoEstado(
                                datosVentas,
                                estado
                        )
                );
            }
        });

        // CONSULTAR CATEGORÍA
        btnConsultarCategoria.addActionListener(e -> {

            String categoria =
                    JOptionPane.showInputDialog(
                            "Ingrese categoría"
                    );

            if (categoria != null &&
                    !categoria.isEmpty()) {

                areaResultados.setText(
                        consultarVentasDadaCategoriaPaquete(
                                datosVentas,
                                categoria
                        )
                );
            }
        });

        // ACTUALIZAR
        btnActualizarVenta.addActionListener(e -> {

            String numeroTexto =
                    JOptionPane.showInputDialog(
                            "Número venta"
                    );

            String operacionTexto =
                    JOptionPane.showInputDialog(
                            "Operación C/P"
                    );

            if (numeroTexto != null &&
                    operacionTexto != null &&
                    !numeroTexto.isEmpty() &&
                    !operacionTexto.isEmpty()) {

                int numero =
                        Integer.parseInt(numeroTexto);

                char operacion =
                        operacionTexto.toUpperCase().charAt(0);

                actualizarVenta(
                        datosVentas,
                        numero,
                        operacion
                );
            }
        });

        // GUARDAR VENTAS
        btnGuardarVentas.addActionListener(e -> {
            generarArchivoObjetosVentas(datosVentas);
        });

        // RECUPERAR VENTAS
        btnRecuperarVentas.addActionListener(e -> {
            recuperarVentasDesdeArchivoObjetos();
        });

        // GUARDAR CLIENTES
        btnGuardarClientes.addActionListener(e -> {
            generarArchivoObjetosClientes(datosClientes);
        });

        // RECUPERAR CLIENTES
        btnRecuperarClientes.addActionListener(e -> {
            recuperarClientesDesdeArchivoObjetos();
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new UsaGUIVenta();
        });
    }

    // GENERAR NÚMERO
    public int generarNumeroVenta(
            ArrayList<Venta> datosVentas) {

        if (datosVentas.isEmpty()) {
            return 1;
        }

        return datosVentas.get(
                datosVentas.size() - 1
        ).getNumero() + 1;
    }

    // CREAR VENTA
    public ArrayList<Venta> crearNuevaVenta(
            ArrayList<Venta> datosVentas) {

        try {

            String nombre =
                    JOptionPane.showInputDialog(
                            "Nombre cliente"
                    );

            String documento =
                    JOptionPane.showInputDialog(
                            "Documento"
                    );

            String correo =
                    JOptionPane.showInputDialog(
                            "Correo"
                    );

            String telefono =
                    JOptionPane.showInputDialog(
                            "Teléfono"
                    );

            String tipoTexto =
                    JOptionPane.showInputDialog(
                            "Tipo ID C/N"
                    );

            char tipo =
                    tipoTexto.toUpperCase().charAt(0);

            Cliente cliente = new Cliente(
                    tipo,
                    documento,
                    false,
                    nombre,
                    correo,
                    telefono,
                    "",
                    0.10
            );

            datosClientes.add(cliente);

            // DESTINOS
            LinkedList<String> atractivos =
                    new LinkedList<>();

            atractivos.add("Museo");
            atractivos.add("Playa");

            Destino destino =
                    new Destino(
                            "Cartagena",
                            5,
                            atractivos,
                            true
                    );

            ArrayList<Destino> destinos =
                    new ArrayList<>();

            destinos.add(destino);

            // PAQUETE
            PaqueteTuristico paquete =
                    new PaqueteTuristicoUnico(
                            "Hilton",
                            "Buffet",
                            "PK001",
                            "Paquete VIP",
                            "Recreativo",
                            "Viaje completo",
                            "Bogotá",
                            destinos,
                            true,
                            true,
                            true,
                            true,
                            false,
                            300000,
                            2
                    );

            ArrayList<PaqueteTuristico> paquetes =
                    new ArrayList<>();

            paquetes.add(paquete);

            Venta venta =
                    new Venta(
                            generarNumeroVenta(
                                    datosVentas
                            ),
                            cliente,
                            paquetes
                    );

            datosVentas.add(venta);

            JOptionPane.showMessageDialog(
                    this,
                    "Venta creada correctamente"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error:\n" + e.getMessage()
            );
        }

        return datosVentas;
    }

    // CONSULTAR TODAS
    public String consultarTodasVentas(
            ArrayList<Venta> datosVentas) {

        if (datosVentas.isEmpty()) {
            return "No existen ventas";
        }

        String resultado = "";

        for (Venta venta : datosVentas) {

            resultado += venta.toString();
            resultado += "\n\n";
        }

        return resultado;
    }

    // CONSULTAR NÚMERO
    public String consultarVentaDadoNumero(
            ArrayList<Venta> datosVentas,
            int numeroVenta) {

        for (Venta venta : datosVentas) {

            if (venta.getNumero() == numeroVenta) {

                return venta.toString();
            }
        }

        return "Venta no encontrada";
    }

    // CONSULTAR POSICIÓN
    public String consultarVentaDadaPosicion(
            ArrayList<Venta> datosVentas,
            char posicionVenta) {

        if (datosVentas.isEmpty()) {
            return "No existen ventas";
        }

        posicionVenta =
                Character.toUpperCase(posicionVenta);

        switch (posicionVenta) {

            case 'P':

                return datosVentas.get(0).toString();

            case 'U':

                return datosVentas.get(
                        datosVentas.size() - 1
                ).toString();

            default:

                return "Posición inválida";
        }
    }

    // CONSULTAR ESTADO
    public String consultarVentasDadoEstado(
            ArrayList<Venta> datosVentas,
            char estadoVenta) {

        String resultado = "";

        for (Venta venta : datosVentas) {

            if (venta.getEstado() == estadoVenta) {

                resultado += venta.toString();
                resultado += "\n\n";
            }
        }

        if (resultado.isEmpty()) {

            return "No existen ventas con ese estado";
        }

        return resultado;
    }

    // CONSULTAR CATEGORÍA
    public String consultarVentasDadaCategoriaPaquete(
            ArrayList<Venta> datosVentas,
            String categoriaPaquete) {

        String resultado = "";

        for (Venta venta : datosVentas) {

            for (PaqueteTuristico paquete :
                    venta.getSusPaquetesTuristicos()) {

                if (paquete.getTipologiaTurismo()
                        .equalsIgnoreCase(
                                categoriaPaquete
                        )) {

                    resultado += venta.toString();
                    resultado += "\n\n";
                }
            }
        }

        if (resultado.isEmpty()) {

            return "No hay ventas para esa categoría";
        }

        return resultado;
    }

    // ACTUALIZAR
    public void actualizarVenta(
            ArrayList<Venta> datosVentas,
            int numeroVenta,
            char operacion) {

        for (Venta venta : datosVentas) {

            if (venta.getNumero() == numeroVenta) {

                if (operacion == 'C' ||
                        operacion == 'P') {

                    venta.setEstado(operacion);

                    JOptionPane.showMessageDialog(
                            this,
                            "Venta actualizada"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Operación inválida"
                    );
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(
                this,
                "Venta no encontrada"
        );
    }

    // GUARDAR VENTAS
    public void generarArchivoObjetosVentas(
            ArrayList<Venta> datosVentas) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    "ventas.dat"
                            )
                    );

            salida.writeObject(datosVentas);

            salida.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Ventas guardadas"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error guardando ventas"
            );
        }
    }

    // RECUPERAR VENTAS
    public void recuperarVentasDesdeArchivoObjetos() {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(
                                    "ventas.dat"
                            )
                    );

            datosVentas =
                    (ArrayList<Venta>)
                            entrada.readObject();

            entrada.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Ventas recuperadas"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error recuperando ventas"
            );
        }
    }

    // GUARDAR CLIENTES
    public void generarArchivoObjetosClientes(
            ArrayList<Cliente> datosClientes) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    "clientes.dat"
                            )
                    );

            salida.writeObject(datosClientes);

            salida.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Clientes guardados"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error guardando clientes"
            );
        }
    }

    // RECUPERAR CLIENTES
    public void recuperarClientesDesdeArchivoObjetos() {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(
                                    "clientes.dat"
                            )
                    );

            datosClientes =
                    (ArrayList<Cliente>)
                            entrada.readObject();

            entrada.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Clientes recuperados"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error recuperando clientes"
            );
        }
    }
}
//