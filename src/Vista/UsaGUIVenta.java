package Vista;

import Modelo.Cliente;
import Modelo.Destino;
import Modelo.PaqueteTuristico;
import Modelo.PaqueteTuristicoMultiple;
import Modelo.PaqueteTuristicoUnico;
import Modelo.Venta;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class UsaGUIVenta extends javax.swing.JFrame {

    private ArrayList<Venta> datosVentas;
    private ArrayList<Cliente> datosClientes;

    public UsaGUIVenta() {
        datosVentas = new ArrayList<Venta>();
        datosClientes = new ArrayList<Cliente>();
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonTodas = new javax.swing.JButton();
        botonNumero = new javax.swing.JButton();
        botonPosicion = new javax.swing.JButton();
        botonEstado = new javax.swing.JButton();
        botonGuardarVentas = new javax.swing.JButton();
        botonRecuperarVentas = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonGuardarClientes = new javax.swing.JButton();
        botonRecuperarClientes = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        scrollResultados = new javax.swing.JScrollPane();
        areaResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar ventas paquetes turisticos");

        panelBotones.setLayout(new java.awt.GridLayout(11, 1));

        botonCrear.setText("1. Crear nueva venta");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        panelBotones.add(botonCrear);

        botonTodas.setText("2. Consultar todas las ventas");
        botonTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTodasActionPerformed(evt);
            }
        });
        panelBotones.add(botonTodas);

        botonNumero.setText("3. Consultar venta por numero");
        botonNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNumeroActionPerformed(evt);
            }
        });
        panelBotones.add(botonNumero);

        botonPosicion.setText("4. Consultar venta por posicion");
        botonPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPosicionActionPerformed(evt);
            }
        });
        panelBotones.add(botonPosicion);

        botonEstado.setText("5. Consultar ventas por estado");
        botonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstadoActionPerformed(evt);
            }
        });
        panelBotones.add(botonEstado);

        botonGuardarVentas.setText("6. Generar archivo ventas");
        botonGuardarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarVentasActionPerformed(evt);
            }
        });
        panelBotones.add(botonGuardarVentas);

        botonRecuperarVentas.setText("7. Consultar ventas desde archivo");
        botonRecuperarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecuperarVentasActionPerformed(evt);
            }
        });
        panelBotones.add(botonRecuperarVentas);

        botonActualizar.setText("8. Actualizar venta por numero");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        panelBotones.add(botonActualizar);

        botonGuardarClientes.setText("9. Generar archivo clientes");
        botonGuardarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarClientesActionPerformed(evt);
            }
        });
        panelBotones.add(botonGuardarClientes);

        botonRecuperarClientes.setText("10. Consultar clientes desde archivo");
        botonRecuperarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecuperarClientesActionPerformed(evt);
            }
        });
        panelBotones.add(botonRecuperarClientes);

        botonSalir.setText("11. Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelBotones.add(botonSalir);

        areaResultados.setColumns(20);
        areaResultados.setRows(5);
        areaResultados.setText("Seleccione una opcion del menu.");
        scrollResultados.setViewportView(areaResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollResultados)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        crearNuevaVenta(datosVentas);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTodasActionPerformed
        areaResultados.setText(consultarTodasVentas(datosVentas));
    }//GEN-LAST:event_botonTodasActionPerformed

    private void botonNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNumeroActionPerformed
        Integer numero = pedirEntero("Digite el numero de la venta");
        if (numero != null) {
            areaResultados.setText(consultarVentaDadoNumero(datosVentas, numero));
        }
    }//GEN-LAST:event_botonNumeroActionPerformed

    private void botonPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPosicionActionPerformed
        String posicion = pedirTexto("Digite P parax primera o U para ultima");
        if (posicion != null) {
            areaResultados.setText(consultarVentaDadaPosicion(datosVentas, posicion.charAt(0)));
        }
    }//GEN-LAST:event_botonPosicionActionPerformed

    private void botonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstadoActionPerformed
        String estado = pedirTexto("Digite A para activa, C para cancelada o P para pagada");
        if (estado != null) {
            areaResultados.setText(consultarVentasDadoEstado(datosVentas, estado.charAt(0)));
        }
    }//GEN-LAST:event_botonEstadoActionPerformed

    private void botonGuardarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarVentasActionPerformed
        generarArchivoObjetosVentas(datosVentas);
    }//GEN-LAST:event_botonGuardarVentasActionPerformed

    private void botonRecuperarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecuperarVentasActionPerformed
        recuperarVentasDesdeArchivoObjetos();
    }//GEN-LAST:event_botonRecuperarVentasActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        Integer numero = pedirEntero("Digite el numero de la venta");
        String operacion = pedirTexto("Digite C para cancelar o P para pagar");

        if (numero != null && operacion != null) {
            actualizarVenta(datosVentas, numero, operacion.charAt(0));
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonGuardarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarClientesActionPerformed
        generarArchivoObjetosClientes(datosClientes);
    }//GEN-LAST:event_botonGuardarClientesActionPerformed

    private void botonRecuperarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecuperarClientesActionPerformed
        recuperarClientesDesdeArchivoObjetos();
    }//GEN-LAST:event_botonRecuperarClientesActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsaGUIVenta().setVisible(true);
            }
        });
    }

    public int generarNumeroVenta(ArrayList<Venta> datosVentas) {
        if (datosVentas.isEmpty()) {
            return 1;
        }

        return datosVentas.get(datosVentas.size() - 1).getNumero() + 1;
    }

    public ArrayList<Venta> crearNuevaVenta(ArrayList<Venta> datosVentas) {
        try {
            Cliente cliente = pedirCliente();

            if (cliente == null) {
                return datosVentas;
            }

            ArrayList<PaqueteTuristico> paquetes = pedirPaquetes();

            if (paquetes == null) {
                return datosVentas;
            }

            Venta venta = new Venta(generarNumeroVenta(datosVentas), cliente, paquetes);
            datosVentas.add(venta);

            JOptionPane.showMessageDialog(this, "La venta fue creada correctamente");
            areaResultados.setText(obtenerTextoVenta(venta, true));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

        return datosVentas;
    }

    public String consultarTodasVentas(ArrayList<Venta> datosVentas) {
        if (datosVentas.isEmpty()) {
            return "No existen ventas";
        }

        String texto = "";

        for (int i = 0; i < datosVentas.size(); i++) {
            texto = texto + obtenerTextoVenta(datosVentas.get(i), true) + "\n";
        }

        return texto;
    }

    public String consultarVentaDadoNumero(ArrayList<Venta> datosVentas, int numeroVenta) {
        for (int i = 0; i < datosVentas.size(); i++) {
            Venta venta = datosVentas.get(i);

            if (venta.getNumero() == numeroVenta) {
                return obtenerTextoVenta(venta, true);
            }
        }

        return "Venta no encontrada";
    }
    public String consultarVentaDadaPosicion(ArrayList<Venta> datosVentas, char posicionVenta) {
        if (datosVentas.isEmpty()) {
            return "No existen ventas";
        }
        posicionVenta = Character.toUpperCase(posicionVenta);

        if (posicionVenta == 'P') {
            return obtenerTextoVenta(datosVentas.get(0), true);
        }

        if (posicionVenta == 'U') {
            return obtenerTextoVenta(datosVentas.get(datosVentas.size() - 1), true);
        }
        return "Posicion invalida";
    }

    public String consultarVentasDadoEstado(ArrayList<Venta> datosVentas, char estadoVenta) {
        String texto = "";
        estadoVenta = Character.toUpperCase(estadoVenta);

        for (int i = 0; i < datosVentas.size(); i++) {
            Venta venta = datosVentas.get(i);

            if (venta.getEstado() == estadoVenta) {
                boolean mostrarPaquetes = venta.getEstado() == 'A' || venta.getEstado() == 'P';
                texto = texto + obtenerTextoVenta(venta, mostrarPaquetes) + "\n";
            }
        }

        if (texto.isEmpty()) {
            return "No existen ventas con ese estado";
        }
        return texto;
    }

    public String consultarVentasDadaCategoriaPaquete(ArrayList<Venta> datosVentas, String categoriaPaquete) {
        String texto = "";

        for (int i = 0; i < datosVentas.size(); i++) {
            Venta venta = datosVentas.get(i);
            boolean encontrada = false;

            for (int j = 0; j < venta.getSusPaquetesTuristicos().size(); j++) {
                PaqueteTuristico paquete = venta.getSusPaquetesTuristicos().get(j);

                if (esCategoria(paquete, categoriaPaquete)) {
                    encontrada = true;
                }
            }

            if (encontrada) {
                texto = texto + obtenerTextoVenta(venta, true) + "\n";
            }
        }

        if (texto.isEmpty()) {
            return "No hay ventas para esa categoria";
        }

        return texto;
    }

    public void generarArchivoObjetosVentas(ArrayList<Venta> datosVentas) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("ventas.dat"));
            salida.writeObject(datosVentas);
            salida.close();

            JOptionPane.showMessageDialog(this, "El rchivo de ventas ha sido generado");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Error generando el archivo de ventas");
        }
    }

    public void recuperarVentasDesdeArchivoObjetos() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("ventas.dat"));
            ArrayList<Venta> ventasArchivo = (ArrayList<Venta>) entrada.readObject();
            entrada.close();

            datosVentas.clear();
            datosVentas.addAll(ventasArchivo);

            areaResultados.setText(consultarTodasVentas(datosVentas));
            JOptionPane.showMessageDialog(this, "Ventas recuperadas");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Error recuperando ventas");
        }
    }

    public void actualizarVenta(ArrayList<Venta> datosVentas, int numeroVenta, char operacion) {
        operacion = Character.toUpperCase(operacion);

        if (operacion != 'C' && operacion != 'P') {
            JOptionPane.showMessageDialog(this, "Opcion invalida");
            return;
        }

        for (int i = 0; i < datosVentas.size(); i++) {
            Venta venta = datosVentas.get(i);

            if (venta.getNumero() == numeroVenta) {
                venta.setEstado(operacion);
                areaResultados.setText(obtenerTextoVenta(venta, true));
                JOptionPane.showMessageDialog(this, "Venta actualizada");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Venta no encontrada");
    }

    public void generarArchivoObjetosClientes(ArrayList<Cliente> datosClientes) {
        try {
            datosClientes.clear();

            for (int i = 0; i < datosVentas.size(); i++) {
                Cliente cliente = datosVentas.get(i).getSuCliente();

                if (!existeCliente(datosClientes, cliente)) {
                    datosClientes.add(cliente);
                }
            }

            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
            salida.writeObject(datosClientes);
            salida.close();

            JOptionPane.showMessageDialog(this, "Archivo de clientes ha sido generado");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Error generando el archivo de clientes");
        }
    }

    public void recuperarClientesDesdeArchivoObjetos() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("clientes.dat"));
            ArrayList<Cliente> clientesArchivo = (ArrayList<Cliente>) entrada.readObject();
            entrada.close();

            datosClientes.clear();
            datosClientes.addAll(clientesArchivo);

            areaResultados.setText(obtenerTextoClientes(datosClientes));
            JOptionPane.showMessageDialog(this, "Clientes recuperados");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Error recuperando clientes");
        }
    }

    private Cliente pedirCliente() {
        String tipoTexto = pedirTexto("Tipo identificacion C o N");
        if (tipoTexto == null) {
            return null;
        }

        String numero = pedirTexto("Numero identificacion");
        if (numero == null) {
            return null;
        }

        String nombre = pedirTexto("Nombre completo o razon social");
        if (nombre == null) {
            return null;
        }

        String email = pedirTexto("Email");
        if (email == null) {
            return null;
        }

        String telefono = pedirTexto("Telefono");
        if (telefono == null) {
            return null;
        }

        String contacto = pedirTexto("Nombre de persona a contactar");
        if (contacto == null) {
            return null;
        }

        Double descuento = pedirDecimal("Porcentaje descuento 0.0 a 70.0");
        if (descuento == null) {
            return null;
        }

        char tipo = tipoTexto.charAt(0);
        boolean empresa = Character.toUpperCase(tipo) == 'N';

        return new Cliente(tipo, numero, empresa, nombre, email, telefono, contacto, descuento);
    }

    private ArrayList<PaqueteTuristico> pedirPaquetes() {
        Integer cantidad = pedirEntero("Cantidad de paquetes de la venta");

        if (cantidad == null) {
            return null;
        }

        if (cantidad < 1) {
            throw new IllegalArgumentException("Debe ingresar minimo un paquete");
        }

        ArrayList<PaqueteTuristico> paquetes = new ArrayList<PaqueteTuristico>();

        for (int i = 0; i < cantidad; i++) {
            PaqueteTuristico paquete = pedirPaquete(i + 1);

            if (paquete == null) {
                return null;
            }

            paquetes.add(paquete);
        }

        return paquetes;
    }

    private PaqueteTuristico pedirPaquete(int numeroPaquete) {
        try {
        String categoria = pedirTexto("Paquete " + numeroPaquete + ": U para unico o M para multiple");
        if (categoria == null) {
            return null;
        }

        char tipoCategoria = Character.toUpperCase(categoria.charAt(0));

        if (tipoCategoria != 'U' && tipoCategoria != 'M') {
            throw new IllegalArgumentException("La categoria debe ser U o M");
        }

        String codigo = pedirTexto("Codigo del paquete");
        String nombre = pedirTexto("Nombre del paquete minimo 10 caracteres");
        String tipologia = pedirTexto("Tipo de turismo");
        String descripcion = pedirTexto("Descripcion");
        String origen = pedirTexto("Origen");
        Boolean hotel = pedirBooleano("Incluye hotel S/N");
        Boolean alimentacion = pedirBooleano("Incluye alimentacion S/N");
        Boolean alimentacionTodo = pedirBooleano("Alimentacion completa S/N");
        Boolean vuelo = pedirBooleano("Incluye vuelo S/N");
        Boolean asistencia = pedirBooleano("Incluye asistencia S/N");
        Integer tarifaDia = pedirEntero("Tarifa por dia");
        Integer cantidadUnidades = pedirEntero("Cantidad de unidades");

        int cantidadDestinos = 1;

        if (tipoCategoria == 'M') {
            Integer cantidadPedida = pedirEntero("Cantidad de destinos del paquete multiple");

            if (cantidadPedida == null) {
                return null;
            }

            if (cantidadPedida < 2) {
                throw new IllegalArgumentException("El paquete multiple debe tener minimo 2 destinos");
            }

            cantidadDestinos = cantidadPedida;
        }

        ArrayList<Destino> destinos = pedirDestinos(cantidadDestinos);

        if (destinos == null) {
            return null;
        }

        if (tipoCategoria == 'U') {
            String nombreHotel = pedirTexto("Nombre del hotel");
            String tipoDesayuno = "";

            if (alimentacion) {
                tipoDesayuno = pedirTexto("Tipo de desayuno");
            }

            if (nombreHotel == null || tipoDesayuno == null) {
                return null;
            }

            return new PaqueteTuristicoUnico(nombreHotel, tipoDesayuno, codigo, nombre,
                    tipologia, descripcion, origen, destinos, hotel, alimentacion,
                    alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadUnidades);
        }

        String obsequio = pedirTexto("Obsequio del paquete multiple");

        if (obsequio == null) {
            return null;
        }

        return new PaqueteTuristicoMultiple(obsequio, codigo, nombre, tipologia,
                descripcion, origen, destinos, hotel, alimentacion, alimentacionTodo,
                vuelo, asistencia, tarifaDia, cantidadUnidades);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "No se pudo generar el paquete");
            return null;
        }
    }

    private ArrayList<Destino> pedirDestinos(int cantidadDestinos) {
        ArrayList<Destino> destinos = new ArrayList<Destino>();

        for (int i = 0; i < cantidadDestinos; i++) {
            String nombreLugar = pedirTexto("Destino " + (i + 1) + ": nombre lugar");
            Integer dias = pedirEntero("Destino " + (i + 1) + ": dias permanencia");
            Boolean atractivosIncluidos = pedirBooleano("Atractivos incluidos S/N");
            Integer cantidadAtractivos = pedirEntero("Cantidad de atractivos");

            if (nombreLugar == null || dias == null || atractivosIncluidos == null
                    || cantidadAtractivos == null) {
                return null;
            }

            LinkedList<String> atractivos = new LinkedList<String>();

            for (int j = 0; j < cantidadAtractivos; j++) {
                String atractivo = pedirTexto("Nombre atractivo " + (j + 1));

                if (atractivo == null) {
                    return null;
                }

                atractivos.add(atractivo);
            }

            destinos.add(new Destino(nombreLugar, dias, atractivos, atractivosIncluidos));
        }

        return destinos;
    }

    private String pedirTexto(String mensaje) {
        String dato = JOptionPane.showInputDialog(this, mensaje);

        if (dato == null) {
            areaResultados.setText("cancelado¡");
            return null;
        }

        dato = dato.trim();

        if (dato.isEmpty()) {
            areaResultados.setText("Cancelado¡, falta un dato");
            return null;
        }

        return dato;
    }

    private Integer pedirEntero(String mensaje) {
        String dato = pedirTexto(mensaje);

        if (dato == null) {
            return null;
        }

        try {
            return Integer.parseInt(dato);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("Debe ingresar un numero entero");
        }
    }

    private Double pedirDecimal(String mensaje) {
        String dato = pedirTexto(mensaje);

        if (dato == null) {
            return null;
        }

        try {
            return Double.parseDouble(dato);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("Debe ingresar un numero decimal");
        }
    }

    private Boolean pedirBooleano(String mensaje) {
        String dato = pedirTexto(mensaje);

        if (dato == null) {
            return null;
        }

        dato = dato.toUpperCase();

        if (dato.equals("S")) {
            return true;
        }

        if (dato.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException("Debe responder S o N");
    }

    private String obtenerTextoVenta(Venta venta, boolean mostrarPaquetes) {
        String texto = "";

        texto = texto + "Numero: " + venta.getNumero() + "\n";
        texto = texto + "Fecha generacion: " + formatearFecha(venta.getFechaHoraGeneracion()) + "\n";
        texto = texto + "Fecha actualizacion: " + formatearFecha(venta.getFechaHoraActualizacion()) + "\n";
        texto = texto + "Estado: " + venta.getEstado() + "\n";
        texto = texto + "Datos del cliente:\n" + venta.getSuCliente() + "\n";
        texto = texto + "Cantidad paquetes incluidos: " + venta.getSusPaquetesTuristicos().size() + "\n";
        texto = texto + "Cantidad total unidades paquetes: " + venta.calcularCantidadTotalUnidadesPaquetes() + "\n";
        texto = texto + "Valor total paquetes: " + venta.calcularValorTotalPaquetes() + "\n";
        texto = texto + "Valor descuento: " + venta.calcularValorDescuento() + "\n";
        texto = texto + "Valor total pagar: " + venta.calcularValorTotalPagar() + "\n";

        if (mostrarPaquetes) {
            texto = texto + "Datos de paquetes:\n";

            for (int i = 0; i < venta.getSusPaquetesTuristicos().size(); i++) {
                texto = texto + obtenerTextoPaquete(venta.getSusPaquetesTuristicos().get(i));
            }
        }

        return texto;
    }

    private String obtenerTextoPaquete(PaqueteTuristico paquete) {
        String texto = "";

        texto = texto + "\nPaquete\n";

        if (paquete instanceof PaqueteTuristicoUnico) {
            texto = texto + "Categoria: Unico\n";
        } else {
            texto = texto + "Categoria: Multiple\n";
        }

        texto = texto + paquete + "\n";
        texto = texto + "Destinos:\n";

        for (int i = 0; i < paquete.getSusDestinos().size(); i++) {
            texto = texto + paquete.getSusDestinos().get(i) + "\n";
        }

        if (paquete instanceof PaqueteTuristicoMultiple) {
            PaqueteTuristicoMultiple multiple = (PaqueteTuristicoMultiple) paquete;
            texto = texto + "Destino inicial: " + multiple.obtenerDestinoInicial().getNombreLugar() + "\n";
            texto = texto + "Destino final: " + multiple.obtenerDestinoFinal().getNombreLugar() + "\n";
        }

        texto = texto + "Valor unidad: " + paquete.calcularValorUnidad() + "\n";
        texto = texto + "Valor total: " + paquete.calcularValorTotal() + "\n";

        return texto;
    }

    private String obtenerTextoClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            return "No existen clientes";
        }

        String texto = "";

        for (int i = 0; i < clientes.size(); i++) {
            texto = texto + "Cliente " + (i + 1) + "\n";
            texto = texto + clientes.get(i) + "\n\n";
        }

        return texto;
    }

    private boolean esCategoria(PaqueteTuristico paquete, String categoriaPaquete) {
        String categoria = categoriaPaquete.toUpperCase();

        if ((categoria.equals("U") || categoria.equals("UNICO")) && paquete instanceof PaqueteTuristicoUnico) {
            return true;
        }

        if ((categoria.equals("M") || categoria.equals("MULTIPLE")) && paquete instanceof PaqueteTuristicoMultiple) {
            return true;
        }

        return false;
    }

    private boolean existeCliente(ArrayList<Cliente> clientes, Cliente clienteBuscado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);

            if (cliente.getTipoIdentificacion() == clienteBuscado.getTipoIdentificacion()
                    && cliente.getNumeroIdentificacion().equals(clienteBuscado.getNumeroIdentificacion())) {
                return true;
            }
        }

        return false;
    }

    private String formatearFecha(java.time.LocalDateTime fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
        return fecha.format(formato);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaResultados;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEstado;
    private javax.swing.JButton botonGuardarClientes;
    private javax.swing.JButton botonGuardarVentas;
    private javax.swing.JButton botonNumero;
    private javax.swing.JButton botonPosicion;
    private javax.swing.JButton botonRecuperarClientes;
    private javax.swing.JButton botonRecuperarVentas;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonTodas;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane scrollResultados;
    // End of variables declaration//GEN-END:variables
}
