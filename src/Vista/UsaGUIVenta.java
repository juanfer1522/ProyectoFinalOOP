/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
   package Vista;

/**
 *
 * @author Juanfer
 */

import Modelo.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Clase principal de la vista GUI para gestión de ventas de paquetes turísticos.
 * Proyecto: Gestionar_Ventas_PaquetesTuristicos
 * Versión: 1.0 - 20260430
 *
 * @author Juanfer
 */
public class UsaGUIVenta extends javax.swing.JFrame {

    // ─────────────────────────────────────────────
    //  Colecciones principales
    // ─────────────────────────────────────────────
    private ArrayList<Venta> datosVentas = new ArrayList<>();
    private ArrayList<Cliente> datosClientes = new ArrayList<>();

    // Nombres de archivos de objetos serializados
    private static final String ARCHIVO_VENTAS   = "ventas.dat";
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    // ─────────────────────────────────────────────
    //  Componentes de la interfaz
    // ─────────────────────────────────────────────
    private JTextArea txtAreaResultados;
    private JScrollPane scrollResultados;
    private JPanel panelMenu;
    private JLabel lblTitulo;
    private JLabel lblStatus;

    // ─────────────────────────────────────────────
    //  Constructor
    // ─────────────────────────────────────────────
    public UsaGUIVenta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    // ─────────────────────────────────────────────
    //  Inicialización de componentes (GUI manual)
    // ─────────────────────────────────────────────
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Gestión de Ventas - Paquetes Turísticos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setMinimumSize(new Dimension(900, 600));

        // ── Paleta de colores ──
        Color colorFondo      = new Color(15, 23, 42);
        Color colorPanel      = new Color(30, 41, 59);
        Color colorBoton      = new Color(56, 189, 248);
        Color colorBotonHover = new Color(14, 165, 233);
        Color colorTexto      = new Color(226, 232, 240);
        Color colorAcento     = new Color(99, 102, 241);
        Color colorExito      = new Color(34, 197, 94);
        Color colorPeligro    = new Color(239, 68, 68);
        Font  fuenteTitulo    = new Font("SansSerif", Font.BOLD, 18);
        Font  fuenteBoton     = new Font("SansSerif", Font.BOLD, 12);
        Font  fuenteNormal    = new Font("Monospaced", Font.PLAIN, 13);

        // ── Panel principal ──
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(panelPrincipal);

        // ── Título ──
        lblTitulo = new JLabel("✈  Gestión de Ventas de Paquetes Turísticos", SwingConstants.CENTER);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(colorBoton);
        lblTitulo.setBorder(new EmptyBorder(0, 0, 10, 0));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // ── Panel izquierdo: menú de botones ──
        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(11, 1, 5, 5));
        panelMenu.setBackground(colorPanel);
        panelMenu.setBorder(new CompoundBorder(
                new LineBorder(colorAcento, 1, true),
                new EmptyBorder(10, 10, 10, 10)));
        panelMenu.setPreferredSize(new Dimension(260, 0));

        String[][] opcionesMenu = {
            {"1. Nueva Venta",                "CREAR"},
            {"2. Todas las Ventas",            "TODAS"},
            {"3. Venta por Número",            "POR_NUMERO"},
            {"4. Venta por Posición",          "POR_POSICION"},
            {"5. Ventas por Estado",           "POR_ESTADO"},
            {"6. Guardar Ventas (Archivo)",    "GUARDAR_V"},
            {"7. Cargar Ventas (Archivo)",     "CARGAR_V"},
            {"8. Actualizar Venta",            "ACTUALIZAR"},
            {"9. Guardar Clientes (Archivo)",  "GUARDAR_C"},
            {"10. Cargar Clientes (Archivo)",  "CARGAR_C"},
            {"11. Salir",                      "SALIR"}
        };

        for (String[] op : opcionesMenu) {
            JButton btn = crearBoton(op[0], op[1], fuenteBoton,
                    op[0].startsWith("11") ? colorPeligro : colorBoton,
                    op[0].startsWith("11") ? new Color(185, 28, 28) : colorBotonHover,
                    colorFondo);
            panelMenu.add(btn);
        }

        panelPrincipal.add(panelMenu, BorderLayout.WEST);

        // ── Panel derecho: área de resultados ──
        txtAreaResultados = new JTextArea();
        txtAreaResultados.setEditable(false);
        txtAreaResultados.setFont(fuenteNormal);
        txtAreaResultados.setBackground(new Color(15, 23, 42));
        txtAreaResultados.setForeground(colorTexto);
        txtAreaResultados.setCaretColor(colorBoton);
        txtAreaResultados.setBorder(new EmptyBorder(10, 10, 10, 10));
        txtAreaResultados.setText("""
                                  Bienvenido al sistema de gesti\u00f3n de ventas
                                  Seleccione una opci\u00f3n del men\u00fa para comenzar.
                                  """);

        scrollResultados = new JScrollPane(txtAreaResultados);
        scrollResultados.setBorder(new CompoundBorder(
                new LineBorder(colorAcento, 1, true),
                new EmptyBorder(2, 2, 2, 2)));
        scrollResultados.getViewport().setBackground(colorFondo);

        panelPrincipal.add(scrollResultados, BorderLayout.CENTER);

        // ── Barra de estado ──
        lblStatus = new JLabel("  Sistema listo  |  Ventas en memoria: 0");
        lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblStatus.setForeground(new Color(148, 163, 184));
        lblStatus.setBorder(new EmptyBorder(5, 0, 0, 0));
        panelPrincipal.add(lblStatus, BorderLayout.SOUTH);
    }

    /** Crea un botón con estilo uniforme y listener basado en comando. */
    private JButton crearBoton(String texto, String comando, Font fuente,
                                Color colorBase, Color colorHover, Color colorTexto) {
        JButton btn = new JButton(texto);
        btn.setFont(fuente);
        btn.setBackground(colorBase);
        btn.setForeground(colorTexto);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setActionCommand(comando);

        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn.setBackground(colorHover); }
            @Override public void mouseExited(MouseEvent e)  { btn.setBackground(colorBase);  }
        });

        btn.addActionListener(e -> manejarAccion(e.getActionCommand()));
        return btn;
    }

    /** Despacha las acciones del menú al método correspondiente*/
    private void manejarAccion(String comando) {
        switch (comando) {
            case "CREAR":        crearNuevaVenta(datosVentas);          break;
            case "TODAS":        mostrarResultado(consultarTodasVentas(datosVentas)); break;
            case "POR_NUMERO":   pedirNumeroVentaYConsultar();           break;
            case "POR_POSICION": pedirPosicionYConsultar();              break;
            case "POR_ESTADO":   pedirEstadoYConsultar();                break;
            case "GUARDAR_V":    generarArchivoObjetosVentas(datosVentas);   break;
            case "CARGAR_V":     recuperarVentasDesdeArchivoObjetos();   break;
            case "ACTUALIZAR":   pedirDatosYActualizarVenta();           break;
            case "GUARDAR_C":    generarArchivoObjetosClientes(datosClientes); break;
            case "CARGAR_C":     recuperarClientesDesdeArchivoObjetos(); break;
            case "SALIR":        confirmarSalida();                      break;
        }
        actualizarStatus();
    }
    //  MÉTODOS DE GESTIÓN DE VENTAS
  
    /**
     * Genera automáticamente el número de la próxima venta.
     * Si la lista está vacía inicia en 1; si no, toma el máximo + 1.
     */
    public int generarNumeroVenta(ArrayList<Venta> datosVentas) {
        if (datosVentas.isEmpty()) return 1;
        int max = 0;
        for (Venta v : datosVentas) {
            if (v.getNumero() > max) max = v.getNumero();
        }
        return max + 1;
    }

    /**
     * Guía al usuario para crear una nueva venta a través de diálogos.
     * Genera el número automáticamente, solicita datos del cliente,
     * crea al menos un paquete y agrega la venta a la colección.
     */
    public ArrayList<Venta> crearNuevaVenta(ArrayList<Venta> datosVentas) {
        try {
            // ── Datos del cliente ──
            String tipoIdStr = pedirOpcion("Tipo de identificación del cliente:",
                    new String[]{"C - Cédula", "N - NIT"});
            if (tipoIdStr == null) return datosVentas;
            char tipoId = tipoIdStr.charAt(0);

            String numId = JOptionPane.showInputDialog(this,
                    "Número de identificación\n(Cédula: mín 6 dígitos / NIT: 9 dígitos):",
                    "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            if (numId == null || numId.isBlank()) return datosVentas;
            numId = numId.trim();
            // Validar longitud según tipo
            if (tipoId == 'C' && numId.length() < 6) {
                JOptionPane.showMessageDialog(this, "La cédula debe tener mínimo 6 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return datosVentas;
            }
            if (tipoId == 'N' && numId.length() != 9) {
                JOptionPane.showMessageDialog(this, "El NIT debe tener exactamente 9 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return datosVentas;
            }

            String esEmpresaStr = pedirOpcion("¿El cliente es una empresa?",
                    new String[]{"Sí", "No"});
            if (esEmpresaStr == null) return datosVentas;
            boolean esEmpresa = esEmpresaStr.equals("Sí");

            String nombreCliente = JOptionPane.showInputDialog(this,
                    esEmpresa ? "Razón social de la empresa:" : "Nombre completo del cliente:",
                    "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            if (nombreCliente == null || nombreCliente.isBlank()) return datosVentas;

            String email = JOptionPane.showInputDialog(this, "Email:", "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            if (email == null) email = "";

            String telefono = JOptionPane.showInputDialog(this,
                    esEmpresa ? "Teléfono fijo de la empresa:" : "Teléfono (móvil o fijo):",
                    "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            if (telefono == null) telefono = "";

            String nombreContacto = JOptionPane.showInputDialog(this,
                    "Nombre del contacto" + (esEmpresa ? " (persona contacto):" : " (puede ser el mismo cliente):"),
                    "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            if (nombreContacto == null) nombreContacto = nombreCliente;

            String porcDescStr = JOptionPane.showInputDialog(this,
                    "Porcentaje de descuento (0.0 - 70.0):", "Nuevo Cliente", JOptionPane.PLAIN_MESSAGE);
            double porcDesc = 0.0;
            try { porcDesc = Double.parseDouble(porcDescStr); }
            catch (NumberFormatException | NullPointerException ignored) {}
            if (porcDesc < 0.0) porcDesc = 0.0;
            if (porcDesc > 70.0) porcDesc = 70.0;

            Cliente cliente = new Cliente(tipoId, numId, esEmpresa, nombreCliente.trim(),
                    email.trim(), telefono.trim(), nombreContacto.trim(), porcDesc);

            // ── Paquetes ──
            ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
            boolean agregarOtroPaquete = true;
            while (agregarOtroPaquete) {
                PaqueteTuristico paquete = crearPaquete();
                if (paquete != null) paquetes.add(paquete);

                String resp = pedirOpcion("¿Agregar otro paquete?", new String[]{"Sí", "No"});
                agregarOtroPaquete = "Sí".equals(resp);
            }

            if (paquetes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe agregar al menos un paquete.", "Error", JOptionPane.ERROR_MESSAGE);
                return datosVentas;
            }

            // ── Crear y agregar venta ──
            int numeroVenta = generarNumeroVenta(datosVentas);
            Venta nuevaVenta = new Venta(numeroVenta, cliente, paquetes);
            datosVentas.add(nuevaVenta);

            mostrarResultado("✅ Venta #" + numeroVenta + " creada exitosamente.\n\n"
                    + nuevaVenta.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear venta: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return datosVentas;
    }

    /** Crea un paquete turístico (único o múltiple) a través de diálogos. */
    private PaqueteTuristico crearPaquete() {
        try {
            String categoriaStr = pedirOpcion("Categoría del paquete:",
                    new String[]{"Único (un destino)", "Múltiple (varios destinos)"});
            if (categoriaStr == null) return null;
            boolean esMultiple = categoriaStr.startsWith("Múltiple");

            String codigo = JOptionPane.showInputDialog(this, "Código del paquete:", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            if (codigo == null || codigo.isBlank()) return null;

            String nombre = JOptionPane.showInputDialog(this, "Nombre del paquete (mín 10 caracteres):", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null || nombre.trim().length() < 10) {
                JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            String tipologia = JOptionPane.showInputDialog(this,
                    "Tipología de turismo (ej. negocios, recreación, educativo, ecológico):",
                    "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            if (tipologia == null) tipologia = "";

            String descripcion = JOptionPane.showInputDialog(this, "Descripción (máx 500 caracteres):", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            if (descripcion == null) descripcion = "";
            if (descripcion.length() > 500) descripcion = descripcion.substring(0, 500);

            String origen = JOptionPane.showInputDialog(this, "Lugar de origen (ej. Bogotá D.C.):", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            if (origen == null) origen = "";

            boolean hotel        = "Sí".equals(pedirOpcion("¿Incluye hotel?",        new String[]{"Sí","No"}));
            boolean alimentacion = "Sí".equals(pedirOpcion("¿Incluye alimentación?", new String[]{"Sí","No"}));
            boolean alimentacionTodo = false;
            if (alimentacion) {
                alimentacionTodo = "Todo incluido".equals(pedirOpcion("Tipo de alimentación:",
                        new String[]{"Todo incluido", "Solo desayuno"}));
            }
            boolean vuelo     = "Sí".equals(pedirOpcion("¿Incluye vuelo?",     new String[]{"Sí","No"}));
            boolean asistencia = "Sí".equals(pedirOpcion("¿Incluye asistencia?", new String[]{"Sí","No"}));

            String tarifaStr = JOptionPane.showInputDialog(this, "Tarifa por día (entero > 0):", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            int tarifaDia = 0;
            try { tarifaDia = Integer.parseInt(tarifaStr); } catch (Exception ignored) {}
            if (tarifaDia <= 0) { JOptionPane.showMessageDialog(this, "La tarifa debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE); return null; }

            String cantStr = JOptionPane.showInputDialog(this, "Cantidad de reservas (mín 1):", "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE);
            int cantidadUnidades = 1;
            try { cantidadUnidades = Integer.parseInt(cantStr); } catch (Exception ignored) {}
            if (cantidadUnidades < 1) cantidadUnidades = 1;

            // ── Destinos ──
            ArrayList<Destino> destinos = new ArrayList<>();
            boolean agregarDestino = true;
            while (agregarDestino) {
                Destino d = crearDestino();
                if (d != null) destinos.add(d);
                if (esMultiple) {
                    String resp = pedirOpcion("¿Agregar otro destino?", new String[]{"Sí","No"});
                    agregarDestino = "Sí".equals(resp);
                } else {
                    agregarDestino = false; // único: solo 1 destino
                }
            }
            if (destinos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe agregar al menos un destino.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            if (!esMultiple) {
                // Paquete Único
                String nombreHotel = hotel ? JOptionPane.showInputDialog(this, "Nombre del hotel:", "Paquete Único", JOptionPane.PLAIN_MESSAGE) : "";
                if (nombreHotel == null) nombreHotel = "";
                String tipoDesayuno = "";
                if (alimentacion) {
                    tipoDesayuno = JOptionPane.showInputDialog(this,
                            "Tipo de desayuno (ej. Buffet, Americano):", "Paquete Único", JOptionPane.PLAIN_MESSAGE);
                    if (tipoDesayuno == null) tipoDesayuno = "";
                }
                return new PaqueteTuristicoUnico(codigo.trim(), nombre.trim(), tipologia.trim(),
                        descripcion.trim(), origen.trim(), destinos, hotel, alimentacion,
                        alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades,
                        nombreHotel.trim(), tipoDesayuno.trim());
            } else {
                // Paquete Múltiple
                String obsequio = JOptionPane.showInputDialog(this, "Obsequio incluido:", "Paquete Múltiple", JOptionPane.PLAIN_MESSAGE);
                if (obsequio == null) obsequio = "";
                return new PaqueteTuristicoMultiple(codigo.trim(), nombre.trim(), tipologia.trim(),
                        descripcion.trim(), origen.trim(), destinos(), hotel, alimentacion(),
                        alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades,
                        obsequio.trim());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear paquete: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /** Crea un destino a través de diálogos. */
    private Destino crearDestino() {
        String nombreLugar = JOptionPane.showInputDialog(this, "Nombre del lugar / destino:", "Nuevo Destino", JOptionPane.PLAIN_MESSAGE);
        if (nombreLugar == null || nombreLugar.isBlank()) return null;

        String diasStr = JOptionPane.showInputDialog(this, "Días de permanencia (mín 1):", "Nuevo Destino", JOptionPane.PLAIN_MESSAGE);
        int dias = 1;
        try { dias = Integer.parseInt(diasStr); } catch (Exception ignored) {}
        if (dias < 1) dias = 1;

        boolean atractivosIncluidos = "Sí".equals(pedirOpcion("¿Atractivos incluidos?", new String[]{"Sí","No (opcionales)"}));

        ArrayList<String> atractivos = new ArrayList<>();
        boolean agregarAtractivo = "Sí".equals(pedirOpcion("¿Agregar atractivos?", new String[]{"Sí","No"}));
        while (agregarAtractivo) {
            String atractivo = JOptionPane.showInputDialog(this, "Nombre del atractivo:", "Atractivos", JOptionPane.PLAIN_MESSAGE);
            if (atractivo != null && !atractivo.isBlank()) atractivos.add(atractivo.trim());
            String resp = pedirOpcion("¿Agregar otro atractivo?", new String[]{"Sí","No"});
            agregarAtractivo = "Sí".equals(resp);
        }

        return new Destino(nombreLugar.trim(), dias, atractivos, atractivosIncluidos);
    }

    //  CONSULTAS
   

    /**
     * Retorna la representación en texto de todas las ventas.
     */
    public String consultarTodasVentas(ArrayList<Venta> datosVentas) {
        if (datosVentas.isEmpty()) return "No hay ventas registradas.";
        StringBuilder sb = new StringBuilder();
        sb.append("           Listado de todas las ventas        \n");
        for (Venta v : datosVentas) {
            sb.append(formatearVenta(v, true));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Retorna la información de una venta dado su número.
     */
    public String consultarVentaDadoNumero(ArrayList<Venta> datosVentas, int numeroVenta) {
        for (Venta v : datosVentas) {
            if (v.getNumero() == numeroVenta) {
                return formatearVenta(v, true);
            }
        }
        return "No se encontró la venta con número: " + numeroVenta;
    }

    /**
     * Retorna la información de la primera (P) o última (U) venta.
     */
    public String consultarVentaDadaPosicion(ArrayList<Venta> datosVentas, char posicionVenta) {
        if (datosVentas.isEmpty()) return "No hay ventas registradas.";
        Venta v = (posicionVenta == 'P' || posicionVenta == 'p')
                ? datosVentas.get(0)
                : datosVentas.get(datosVentas.size() - 1);
        String etiqueta = (posicionVenta == 'P' || posicionVenta == 'p') ? "PRIMERA" : "ÚLTIMA";
        return "─── " + etiqueta + " VENTA ───\n" + formatearVenta(v, true);
    }

    /**
     * Retorna las ventas filtradas por estado: A, C o P.
     */
    public String consultarVentasDadoEstado(ArrayList<Venta> datosVentas, char estadoVenta) {
        StringBuilder sb = new StringBuilder();
        String etiqueta = estadoVenta == 'A' ? "ACTIVAS" : estadoVenta == 'C' ? "CANCELADAS/ANULADAS" : "CON PAGO ASOCIADO";
        sb.append("─── VENTAS ").append(etiqueta).append(" ───\n\n");
        boolean encontrada = false;
        for (Venta v : datosVentas) {
            if (Character.toUpperCase(v.getEstado()) == Character.toUpperCase(estadoVenta)) {
                boolean mostrarPaquetes = (v.getEstado() == 'A' || v.getEstado() == 'P');
                sb.append(formatearVenta(v, mostrarPaquetes)).append("\n");
                encontrada = true;
            }
        }
        if (!encontrada) sb.append("No hay ventas con estado '").append(estadoVenta).append("'.\n");
        return sb.toString();
    }

    /**
     * Retorna las ventas filtradas por categoría de paquete: "Único" o "Múltiple".
     */
    public String consultarVentasDadaCategoriaPaquete(ArrayList<Venta> datosVentas, String categoriaPaquete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" VENTAS CON PAQUETES ").append(categoriaPaquete.toUpperCase()).append("S ───\n\n");
        boolean esMultiple = categoriaPaquete.equalsIgnoreCase("Múltiple");
        boolean encontrada = false;
        for (Venta v : datosVentas) {
            boolean tieneCategoria = false;
            for (PaqueteTuristico p : v.getSusPaquetesTuristicos()) {
                if (esMultiple && p instanceof PaqueteTuristicoMultiple) { tieneCategoria = true; break; }
                if (!esMultiple && p instanceof PaqueteTuristicoUnico)   { tieneCategoria = true; break; }
            }
            if (tieneCategoria) {
                sb.append(formatearVenta(v, true)).append("\n");
                encontrada = true;
            }
        }
        if (!encontrada) sb.append("No hay ventas con paquetes de categoría '").append(categoriaPaquete).append("'.\n");
        return sb.toString();
    }

    //  ACTUALIZACIÓN DE VENTA

    /**
     * Actualiza el estado de la venta (C: Cancelar, P: Pagar)
     * y modifica la fecha/hora de última actualización.
     */
    public void actualizarVenta(ArrayList<Venta> datosVentas, int numeroVenta, char operacion) {
        for (Venta v : datosVentas) {
            if (v.getNumero() == numeroVenta) {
                char nuevoEstado = (operacion == 'C' || operacion == 'c') ? 'C' : 'P';
                v.setEstado(nuevoEstado);
                v.setFechaHoraActualizacion(LocalDateTime.now());
                mostrarResultado("Venta #" + numeroVenta + " actualizada.\n"
                        + "Nuevo estado: " + (nuevoEstado == 'C' ? "Cancelada" : "Pagada") + "\n"
                        + "Fecha actualización: "
                        + v.getFechaHoraActualizacion().format(
                                DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss")));
                return;
            }
        }
        mostrarResultado("⚠ No se encontró la venta con número: " + numeroVenta);
    }

 
    //  ARCHIVO DE OBJETOS — VENTAS
   

    /**
     * Serializa la colección de ventas en un archivo de objetos.
     */
    public void generarArchivoObjetosVentas(ArrayList<Venta> datosVentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_VENTAS))) {
            oos.writeObject(datosVentas);
            mostrarResultado("Archivo de ventas generado: " + ARCHIVO_VENTAS
                    + "\nTotal ventas guardadas: " + datosVentas.size());
        } catch (IOException ex) {
            mostrarResultado("Error al generar archivo de ventas:\n" + ex.getMessage());
        }
    }

    /**
     * Carga la colección de ventas desde el archivo de objetos.
     * Limpia la colección actual antes de cargar.
     */
    @SuppressWarnings("unchecked")
    public void recuperarVentasDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO_VENTAS))) {
            datosVentas.clear();
            datosVentas = (ArrayList<Venta>) ois.readObject();
            mostrarResultado("✅ Ventas recuperadas desde archivo.\n"
                    + "Total ventas cargadas: " + datosVentas.size());
        } catch (FileNotFoundException ex) {
            mostrarResultado("⚠ Archivo no encontrado: " + ARCHIVO_VENTAS
                    + "\nGuarde primero las ventas (opción 6).");
        } catch (IOException | ClassNotFoundException ex) {
            mostrarResultado("❌ Error al leer archivo de ventas:\n" + ex.getMessage());
        }
    }

    // ──────────────────────────────────────────────────────────────────
    //  ARCHIVO DE OBJETOS — CLIENTES
    // ──────────────────────────────────────────────────────────────────

    /**
     * Genera la colección de clientes (sin duplicados) desde las ventas
     * y la serializa en un archivo de objetos.
     */
    public void generarArchivoObjetosClientes(ArrayList<Cliente> datosClientes) {
        // Construir colección sin duplicados a partir de las ventas
        ArrayList<Cliente> clientesUnicos = new ArrayList<>();
        for (Venta v : datosVentas) {
            Cliente c = v.getSuCliente();
            boolean yaExiste = false;
            for (Cliente cu : clientesUnicos) {
                if (cu.getNumeroIdentificacion().equals(c.getNumeroIdentificacion())
                        && cu.getTipoIdentificacion() == c.getTipoIdentificacion()) {
                    yaExiste = true;
                    break;
                }
            }
            if (!yaExiste) clientesUnicos.add(c);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(clientesUnicos);
            this.datosClientes = clientesUnicos;
            mostrarResultado("✅ Archivo de clientes generado: " + ARCHIVO_CLIENTES
                    + "\nTotal clientes guardados: " + clientesUnicos.size());
        } catch (IOException ex) {
            mostrarResultado("❌ Error al generar archivo de clientes:\n" + ex.getMessage());
        }
    }

    /**
     * Carga la colección de clientes desde el archivo de objetos.
     * Limpia la colección actual antes de cargar.
     */
    @SuppressWarnings("unchecked")
    public void recuperarClientesDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARCHIVO_CLIENTES))) {
            datosClientes.clear();
            datosClientes = (ArrayList<Cliente>) ois.readObject();
            StringBuilder sb = new StringBuilder("✅ Clientes recuperados desde archivo.\n"
                    + "Total clientes cargados: " + datosClientes.size() + "\n\n");
            for (Cliente c : datosClientes) sb.append(c.toString()).append("\n");
            mostrarResultado(sb.toString());
        } catch (FileNotFoundException ex) {
            mostrarResultado("⚠ Archivo no encontrado: " + ARCHIVO_CLIENTES
                    + "\nGuarde primero los clientes (opción 9).");
        } catch (IOException | ClassNotFoundException ex) {
            mostrarResultado("❌ Error al leer archivo de clientes:\n" + ex.getMessage());
        }
    }

    // ══════════════════════════════════════════════════════════════════
    //  HELPERS DE DIÁLOGOS
    // ══════════════════════════════════════════════════════════════════

    private void pedirNumeroVentaYConsultar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el número de la venta:", "Consultar Venta", JOptionPane.QUESTION_MESSAGE);
        if (input == null) return;
        try {
            int num = Integer.parseInt(input.trim());
            mostrarResultado(consultarVentaDadoNumero(datosVentas, num));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pedirPosicionYConsultar() {
        String posStr = pedirOpcion("Seleccione posición:", new String[]{"P - Primera venta", "U - Última venta"});
        if (posStr == null) return;
        char pos = posStr.charAt(0);
        mostrarResultado(consultarVentaDadaPosicion(datosVentas, pos));
    }

    private void pedirEstadoYConsultar() {
        String estStr = pedirOpcion("Seleccione estado:", new String[]{
            "A - Activa",
            "C - Cancelada / Anulada",
            "P - Pago asociado"
        });
        if (estStr == null) return;
        char estado = estStr.charAt(0);
        mostrarResultado(consultarVentasDadoEstado(datosVentas, estado));
    }

    private void pedirDatosYActualizarVenta() {
        String numStr = JOptionPane.showInputDialog(this, "Número de la venta a actualizar:", "Actualizar Venta", JOptionPane.QUESTION_MESSAGE);
        if (numStr == null) return;
        int num;
        try { num = Integer.parseInt(numStr.trim()); }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String opStr = pedirOpcion("Seleccione operación:", new String[]{"C - Cancelar", "P - Registrar Pago"});
        if (opStr == null) return;
        char op = opStr.charAt(0);
        actualizarVenta(datosVentas, num, op);
    }

    /** Muestra un JOptionPane de selección y retorna la opción elegida. */
    private String pedirOpcion(String mensaje, String[] opciones) {
        return (String) JOptionPane.showInputDialog(this, mensaje, "Selección",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    }

    private void confirmarSalida() {
        int resp = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea salir?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) System.exit(0);
    }

    //  Helpers del formato
   
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");

    /** Formatea una venta completa para mostrar en el área de resultados. */
    private String formatearVenta(Venta v, boolean mostrarPaquetes) {
        StringBuilder sb = new StringBuilder();
        sb.append("┌─────────────────────────────────────────────────\n");
        sb.append(String.format("│  Número: %-6d  Estado: %s\n",
                v.getNumero(), descripcionEstado(v.getEstado())));
        sb.append(String.format("│  Generación:    %s\n", v.getFechaHoraGeneracion().format(FMT)));
        sb.append(String.format("│  Actualización: %s\n", v.getFechaHoraActualizacion().format(FMT)));
        sb.append("│\n│  CLIENTE:\n");
        sb.append(formatearCliente(v.getSuCliente()));
        sb.append("│\n│  RESUMEN PAQUETES:\n");
        sb.append(String.format("│    Cantidad de paquetes         : %d\n",
                v.getSusPaquetesTuristicos().size()));
        sb.append(String.format("│    Total unidades               : %d\n",
                v.calcularCantidadTotalUnidadesPaquetes()));
        sb.append(String.format("│    Valor total paquetes         : $%,d\n",
                v.calcularValorTotalPaquetes()));
        sb.append(String.format("│    Valor descuento (%.1f%%)       : $%,d\n",
                v.getSuCliente().getPorcentajeDescuento(), v.calcularValorDescuento()));
        sb.append(String.format("│    TOTAL A PAGAR                : $%,d\n",
                v.calcularValorTotalPagar()));

        if (mostrarPaquetes) {
            sb.append("│\n│  PAQUETES:\n");
            int idx = 1;
            for (PaqueteTuristico p : v.getSusPaquetesTuristicos()) {
                sb.append(String.format("│  [%d] %s\n", idx++, formatearPaquete(p)));
            }
        }
        sb.append("└─────────────────────────────────────────────────\n");
        return sb.toString();
    }

    private String formatearCliente(Cliente c) {
        return String.format(
                "│    Tipo ID: %c  Número ID: %s\n" +
                "│    Nombre: %s\n" +
                "│    Email: %s  Teléfono: %s\n" +
                "│    Contacto: %s  Descuento: %.1f%%\n",
                c.getTipoIdentificacion(), c.getNumeroIdentificacion(),
                c.getNombre(), c.getEmail(), c.getTelefono(),
                c.getNombreContacto(), c.getPorcentajeDescuento());
    }

    private String formatearPaquete(PaqueteTuristico p) {
        StringBuilder sb = new StringBuilder();
        String categoria = (p instanceof PaqueteTuristicoMultiple) ? "MÚLTIPLE" : "ÚNICO";
        sb.append(String.format("Categoría: %s | Código: %s | Nombre: %s\n", categoria, p.getCodigo(), p.getNombre()));
        sb.append(String.format("│       Tipología: %s | Origen: %s\n", p.getTipologiaTurismo(), p.getOrigen()));
        sb.append(String.format("│       Descripción: %s\n", p.getDescripcion()));
        sb.append(String.format("│       Hotel: %s | Alimentación: %s (%s) | Vuelo: %s | Asistencia: %s\n",
                p.isHotel()?"Sí":"No", p.isAlimentacion()?"Sí":"No",
                p.isAlimentacionTodo()?"Todo incluido":"Solo desayuno",
                p.isVuelo()?"Sí":"No", p.isAsistencia()?"Sí":"No"));
        sb.append(String.format("│       Tarifa/día: $%,d | Duración: %d días | Unidades: %d\n",
                p.getTarifaDia(), p.calcularDuracionTotalDias(), p.getCantidadUnidades()));

        if (p instanceof PaqueteTuristicoUnico pu) {
            sb.append(String.format("│       Hotel: %s | Tipo desayuno: %s\n",
                    pu.getNombreHotel(), pu.getTipoDesayuno().isBlank() ? "N/A" : pu.getTipoDesayuno()));
        } else if (p instanceof PaqueteTuristicoMultiple pm) {
            Destino ini = pm.obtenerDestinoInicial();
            Destino fin = pm.obtenerDestinoFinal();
            sb.append(String.format("│       Destino inicial: %s | Destino final: %s\n",
                    ini != null ? ini.getNombreLugar() : "N/A",
                    fin != null ? fin.getNombreLugar() : "N/A"));
            sb.append(String.format("│       Obsequio: %s\n", pm.getObsequio()));
        }

        sb.append(String.format("│       Valor/unidad: $%,d | Valor total: $%,d",
                p.calcularValorUnidad(), p.calcularValorTotal()));
        return sb.toString();
    }

    private String descripcionEstado(char estado) {
        return switch (estado) {
            case 'A' -> "Activa";
            case 'P' -> "Pagada";
            case 'C' -> "Cancelada";
            default  -> String.valueOf(estado);
        };
    }

    private void mostrarResultado(String texto) {
        txtAreaResultados.setText(texto);
        txtAreaResultados.setCaretPosition(0);
    }

    private void actualizarStatus() {
        lblStatus.setText("  Sistema listo  |  Ventas en memoria: " + datosVentas.size()
                + "  |  Clientes en memoria: " + datosClientes.size());
    }

    // ══════════════════════════════════════════════════════════════════
    //  MAIN
    // ══════════════════════════════════════════════════════════════════

    /**
     * Punto de entrada de la aplicación.
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsaGUIVenta.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new UsaGUIVenta().setVisible(true));
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        


  

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsaGUIVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsaGUIVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsaGUIVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsaGUIVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

