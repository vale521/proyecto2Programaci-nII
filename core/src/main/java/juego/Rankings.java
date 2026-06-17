/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package juego;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Rankings extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Rankings.class.getName());
    private Jugador jugador;

    /**
     * Creates new form Rankings
     */
    public Rankings() {
        initComponents();
        actualizarInterfazIdioma();
        Idioma.suscribir(() -> actualizarInterfazIdioma());

        this.setSize(695, 490);
        this.setLocationRelativeTo(null);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jScrollPane4.setOpaque(false);
        jScrollPane4.getViewport().setOpaque(false);

        jTable1.setRowHeight(40);
        jTable4.setRowHeight(40);
    }

    public Rankings(Jugador jugador) {
        initComponents();
        actualizarInterfazIdioma();
        Idioma.suscribir(() -> actualizarInterfazIdioma());

        this.setSize(695, 490);
        this.setLocationRelativeTo(null);
        this.jugador = jugador;
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jScrollPane4.setOpaque(false);
        jScrollPane4.getViewport().setOpaque(false);

        jTable1.setRowHeight(40);
        jTable4.setRowHeight(40);
        cargarRankingGlobal();
        cargarRankingAmigos();
        cargarMiRanking();
        cargarSesionesRecientes();
    }

    public void actualizarInterfazIdioma() {
        if (Idioma.isEspanol()) {
            backEsp.setVisible(true);
            back.setVisible(false);
            jTabbedPane1.setTitleAt(0, "Ranking Global");
            jTabbedPane1.setTitleAt(1, "Amigos");
            jTabbedPane1.setTitleAt(2, "Mi Ranking");
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Posición");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Jugador");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Tiempo Jugado");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Niveles");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Tiempo Prom.");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Puntaje");
            jTable4.getColumnModel().getColumn(0).setHeaderValue("Posición");
            jTable4.getColumnModel().getColumn(1).setHeaderValue("Jugador");
            jTable4.getColumnModel().getColumn(2).setHeaderValue("Tiempo Jugado");
            jTable4.getColumnModel().getColumn(3).setHeaderValue("Niveles");
            jTable4.getColumnModel().getColumn(4).setHeaderValue("Tiempo Prom.");
            jTable4.getColumnModel().getColumn(5).setHeaderValue("Puntaje");
            lblTituloDescripcion.setText("DESCRIPCIÓN");
            lblTituloDatos.setText("DATOS");
            lblTituloCantPartidas.setText("Cantidad de Partidas");
            lblTituloNivelesCompletados.setText("Niveles Completados");
            lblTituloTiempoPromedio.setText("Tiempo Promedio");
            lblTituloFechaRegistro.setText("Fecha de Registro");
            lblTituloPuntajeTotal.setText("Puntaje Total");
            lblTituloTiempoTotal.setText("Tiempo Total");
            lblTituloAct.setText("ACTIVIDAD DE SESIONES RECIENTES");
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Fecha");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Duración");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Logros");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Vidas");
            btnAgregarAmigos1.setText("Agregar Amigo");
        } else {
            back.setVisible(true);
            backEsp.setVisible(false);
            jTabbedPane1.setTitleAt(0, "Global Ranking");
            jTabbedPane1.setTitleAt(1, "Friends");
            jTabbedPane1.setTitleAt(2, "My Ranking");
            jTable1.getColumnModel().getColumn(0).setHeaderValue("PLACE");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("PLAYER");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("TIME PLAYED");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("COMPLETED LEVELS");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("AVERANGE TIME");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("TOTAL SCORE");
            jTable4.getColumnModel().getColumn(0).setHeaderValue("PLACE");
            jTable4.getColumnModel().getColumn(1).setHeaderValue("PLAYER");
            jTable4.getColumnModel().getColumn(2).setHeaderValue("TIME PLAYED");
            jTable4.getColumnModel().getColumn(3).setHeaderValue("COMPLETED LEVELS");
            jTable4.getColumnModel().getColumn(4).setHeaderValue("AVERANGE TIME");
            jTable4.getColumnModel().getColumn(5).setHeaderValue("TOTAL SCORE");
            lblTituloDescripcion.setText("DESCRIPTION");
            lblTituloDatos.setText("DATA");
            lblTituloCantPartidas.setText("Games Played");
            lblTituloNivelesCompletados.setText("Completed Levels");
            lblTituloTiempoPromedio.setText("Average Time");
            lblTituloFechaRegistro.setText("Registration Date");
            lblTituloPuntajeTotal.setText("Total Score");
            lblTituloTiempoTotal.setText("Total Time");
            lblTituloAct.setText("RECENT SESSION ACTIVITY");
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Date");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Duration");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Achivements");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Lives");
            btnAgregarAmigos1.setText("Add Friends");
        }
        jTable1.getTableHeader().repaint();
        jTable2.getTableHeader().repaint();
        jTable4.getTableHeader().repaint();
    }

    public void cargarRankingGlobal() {
        PersistenciaJugador persitenciaJugador = new PersistenciaJugador();
        ArrayList<Jugador> jugadores = persitenciaJugador.obtenerTodosJugadores();
        PersistenciaPartidas persistenciaPartidas = new PersistenciaPartidas();
        for (Jugador jugador : jugadores) {
            ArrayList<ResultadoPartida> partidas = persistenciaPartidas.obtenerPartidas(jugador.getUsername());
            for (ResultadoPartida partida : partidas) {
                jugador.agregarResultado(partida);
            }
        }
        //para ordenar en orden de puntaje
        jugadores.sort((a, b) -> Integer.compare(b.calcularPuntajeTotal(), a.calcularPuntajeTotal()));
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        int posicion = 1;
        for (Jugador jugador : jugadores) {
            modelo.addRow(new Object[]{posicion, jugador.getUsername(), jugador.getCntidadPartidas(), jugador.getNivelesCompletados(), String.format("%.2f", jugador.getTiempoPromedio()), jugador.calcularPuntajeTotal()});
            jugador.setPosicionRanking(posicion);
            posicion++;
        }
    }

    public void cargarRankingAmigos() {
        DefaultTableModel modelo = (DefaultTableModel) jTable4.getModel();
        modelo.setRowCount(0);
        ArrayList<Jugador> amigos = new ArrayList<>();
        PersistenciaPartidas persistenciaPartidas = new PersistenciaPartidas();
        amigos.addAll(jugador.getAmigos());
        for (Jugador amigo : amigos) {
            ArrayList<ResultadoPartida> partidas = persistenciaPartidas.obtenerPartidas(amigo.getUsername());
            for (ResultadoPartida partida : partidas) {
                amigo.agregarResultado(partida);
            }
        }
        //para ordenar en orden de puntaje

        amigos.sort((a, b) -> Integer.compare(b.calcularPuntajeTotal(), a.calcularPuntajeTotal()));
        int posicion = 1;
        for (Jugador amigo : amigos) {
            modelo.addRow(new Object[]{posicion, amigo.getUsername(), amigo.getCntidadPartidas(), amigo.getNivelesCompletados(), String.format("%.2f", amigo.getTiempoPromedio()), amigo.calcularPuntajeTotal()});
            amigo.setPosicionRanking(posicion);
            posicion++;
        }
    }

    public void cargarMiRanking() {
        lblCantPartidas.setText(String.valueOf(jugador.getCntidadPartidas()));
        lblNivelesCompletados.setText(String.valueOf(jugador.getNivelesCompletados()));
        lblTiempoPromedio.setText(String.format("%.2f seg", jugador.getTiempoPromedio()));
        lblFechaRegistro.setText(jugador.getFechaRegistro().toLocalDate().toString());
        lblPuntajeTotal.setText(String.valueOf(jugador.calcularPuntajeTotal()));
        lblTiempoTotal.setText(jugador.getTiempoTotalJugado());
    }

    public void cargarSesionesRecientes() {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setRowCount(0);
        ArrayList<ResultadoPartida> historial = new ArrayList<>(jugador.getHistorialPartidas());
        int inicio = Math.max(0, historial.size() - 3);
        for (int i = historial.size() - 1; i >= inicio; i--) {
            ResultadoPartida partida = historial.get(i);
            String fecha;
            if (partida.getFechaHoraInicioPartida() != null) {
                fecha = partida.getFechaHoraInicioPartida().toLocalDate().toString();
            } else if (partida.getFecha() != null) {
                fecha = partida.getFecha().toLocalDate().toString();
            } else {
                fecha = "Sin fecha";
            }
            String duracion;

            if (partida.getFechaHoraInicioPartida() != null && partida.getFechaHoraFinalPartida() != null) {
                duracion = partida.getTiempoPartida().toMinutes() + " min";
            } else if (partida.getTiempoSegundos() > 0) {
                int minutos = (int) (partida.getTiempoSegundos() / 60);
                int segundos = (int) (partida.getTiempoSegundos() % 60);
                duracion = minutos + " mins " + segundos + " segs";
            } else {
                duracion = "N/A";
            }
            String logro = "Nivel " + partida.getNivelAlcanzado();

            modelo.addRow(new Object[]{fecha, duracion, logro, partida.getVidasRestantes()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        backEsp = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregarAmigos1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTituloDescripcion = new javax.swing.JLabel();
        lblTituloDatos = new javax.swing.JLabel();
        lblTituloCantPartidas = new javax.swing.JLabel();
        lblCantPartidas = new javax.swing.JLabel();
        lblTituloNivelesCompletados = new javax.swing.JLabel();
        lblNivelesCompletados = new javax.swing.JLabel();
        lblTituloTiempoPromedio = new javax.swing.JLabel();
        lblTiempoPromedio = new javax.swing.JLabel();
        lblTituloFechaRegistro = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        lblTituloPuntajeTotal = new javax.swing.JLabel();
        lblPuntajeTotal = new javax.swing.JLabel();
        lblTituloTiempoTotal = new javax.swing.JLabel();
        lblTiempoTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblTituloAct = new javax.swing.JLabel();
        historialEsp = new javax.swing.JButton();
        historial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/back.png"))); // NOI18N
        back.addActionListener(this::backActionPerformed);
        getContentPane().add(back);
        back.setBounds(10, 10, 90, 30);

        backEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/11esp.png"))); // NOI18N
        backEsp.addActionListener(this::backEspActionPerformed);
        getContentPane().add(backEsp);
        backEsp.setBounds(10, 10, 90, 30);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PLACE", "PLAYER", "TIMES PLAYED", "COMPLETED LEVELS", "AVERAGE TIME", "TOTAL SCORE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(3).setMinWidth(130);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 570, 270);

        btnAgregarAmigos1.setText("AgregarAmigo");
        btnAgregarAmigos1.addActionListener(this::btnAgregarAmigos1ActionPerformed);
        jPanel1.add(btnAgregarAmigos1);
        btnAgregarAmigos1.setBounds(10, 290, 570, 27);

        jTabbedPane1.addTab("Global Ranking", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACE", "PLAYER", "TIMES PLAYED", "COMPLETED LEVELS", "AVERAGE TIME", "TOTAL SCORE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setOpaque(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(60);
            jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable4.getColumnModel().getColumn(3).setMinWidth(130);
            jTable4.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(10, 10, 570, 300);

        jTabbedPane1.addTab("Friends", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout(7, 2));

        lblTituloDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloDescripcion.setText("DESCRIPCION");
        lblTituloDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloDescripcion);

        lblTituloDatos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloDatos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloDatos.setText("DATOS");
        lblTituloDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloDatos);

        lblTituloCantPartidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloCantPartidas.setText("Cantidad de partidas");
        lblTituloCantPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloCantPartidas);

        lblCantPartidas.setText("jLabel10");
        lblCantPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblCantPartidas);

        lblTituloNivelesCompletados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloNivelesCompletados.setText("Niveles Completados");
        lblTituloNivelesCompletados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloNivelesCompletados);

        lblNivelesCompletados.setText("jLabel11");
        lblNivelesCompletados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblNivelesCompletados);

        lblTituloTiempoPromedio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloTiempoPromedio.setText("Tiempo promedio");
        lblTituloTiempoPromedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloTiempoPromedio);

        lblTiempoPromedio.setText("jLabel12");
        lblTiempoPromedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTiempoPromedio);

        lblTituloFechaRegistro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloFechaRegistro.setText("Fecha de registro");
        lblTituloFechaRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloFechaRegistro);

        lblFechaRegistro.setText("jLabel13");
        lblFechaRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblFechaRegistro);

        lblTituloPuntajeTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloPuntajeTotal.setText("Puntaje total");
        lblTituloPuntajeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloPuntajeTotal);

        lblPuntajeTotal.setText("jLabel14");
        lblPuntajeTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblPuntajeTotal);

        lblTituloTiempoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTituloTiempoTotal.setText("Tiempo Total");
        lblTituloTiempoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTituloTiempoTotal);

        lblTiempoTotal.setText("jLabel15");
        lblTiempoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTiempoTotal);

        jPanel4.add(jPanel3);
        jPanel3.setBounds(20, 10, 550, 170);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "DURACION", "LOGROS", "VIDAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 210, 550, 100);

        lblTituloAct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloAct.setText("ACTIVIDAD DE SESIONES RECIENTES");
        lblTituloAct.setOpaque(true);
        jPanel4.add(lblTituloAct);
        lblTituloAct.setBounds(20, 190, 330, 20);

        jTabbedPane1.addTab("My Ranking", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(80, 80, 590, 350);

        historialEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/historialesp (2).png"))); // NOI18N
        historialEsp.addActionListener(this::historialEspActionPerformed);
        getContentPane().add(historialEsp);
        historialEsp.setBounds(570, 10, 90, 30);

        historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/historial.png"))); // NOI18N
        historial.addActionListener(this::historialActionPerformed);
        getContentPane().add(historial);
        historial.setBounds(570, 10, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juego/rank (3).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 680, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        Niveles niveles = new Niveles(jugador);
        niveles.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void backEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backEspActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Niveles niveles = new Niveles(jugador);
        niveles.setVisible(true);
    }//GEN-LAST:event_backEspActionPerformed

    private void btnAgregarAmigos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAmigos1ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un jugador");
            return;
        }

        String usernameAmigo = jTable1.getValueAt(fila, 1).toString();
        if (usernameAmigo.equals(jugador.getUsername())) {
            JOptionPane.showMessageDialog(this, "No puedes agregarte a ti mismo. SORRY:(");
            return;
        }
        PersistenciaJugador persistenciaJugador = new PersistenciaJugador();
        Jugador amigo = persistenciaJugador.cargarJugador(usernameAmigo);
        if (amigo == null) {
            JOptionPane.showMessageDialog(this, "NO SE PUDO CARGAR EL JUGADOR. SORRY:(");
        }
        boolean existeAmigo = false;
        for (Jugador amix : jugador.getAmigos()) {
            if (amix.getUsername().equals(amigo.getUsername())) {
                existeAmigo = true;
                break;
            }
        }
        if (existeAmigo == true) {
            JOptionPane.showMessageDialog(this, "Ese jugador ya es tu amix");
            return;
        }
        jugador.getAmigos().add(amigo);
        amigo.getAmigos().add(jugador);
        persistenciaJugador.guardarJugador(jugador);
        persistenciaJugador.guardarJugador(amigo);
        cargarRankingAmigos();
        JOptionPane.showMessageDialog(this, "AMIGO AGREGADO CORRECTAMENTE");
    }//GEN-LAST:event_btnAgregarAmigos1ActionPerformed

    private void historialEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialEspActionPerformed
        // TODO add your handling code here:
        Historial historial = new Historial();
        historial.setVisible(true);
    }//GEN-LAST:event_historialEspActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
        // TODO add your handling code here:
        Historial historial = new Historial();
        historial.setVisible(true);
    }//GEN-LAST:event_historialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Rankings().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton backEsp;
    private javax.swing.JButton btnAgregarAmigos1;
    private javax.swing.JButton historial;
    private javax.swing.JButton historialEsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblCantPartidas;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblNivelesCompletados;
    private javax.swing.JLabel lblPuntajeTotal;
    private javax.swing.JLabel lblTiempoPromedio;
    private javax.swing.JLabel lblTiempoTotal;
    private javax.swing.JLabel lblTituloAct;
    private javax.swing.JLabel lblTituloCantPartidas;
    private javax.swing.JLabel lblTituloDatos;
    private javax.swing.JLabel lblTituloDescripcion;
    private javax.swing.JLabel lblTituloFechaRegistro;
    private javax.swing.JLabel lblTituloNivelesCompletados;
    private javax.swing.JLabel lblTituloPuntajeTotal;
    private javax.swing.JLabel lblTituloTiempoPromedio;
    private javax.swing.JLabel lblTituloTiempoTotal;
    // End of variables declaration//GEN-END:variables
}
