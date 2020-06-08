package proyecto1_sistema_sismico;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author XT
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    PanelInicio varpanel;
    //PanelTipo panelTipo;
    Registro_sismos listaG = Registro_Singleton.getRegistro_Singleton();
    
    
    public VentanaPrincipal() throws IOException, FileNotFoundException, ParseException {
        //this.panelTipo= new PanelTipo();
        //panelTipo.setLocation(0,0);
        //panelTipo.setSize(panelTipo.getMaximumSize());
        //panelTipo.setVisible(false);
        
        this.varpanel = new PanelInicio();
        varpanel.setLocation(0,0);
        varpanel.setSize(varpanel.getMaximumSize());
        varpanel.setVisible(true);
        initComponents();
        //Hacer que empiece con el PanelInicio
        panelPrincipal.removeAll();//quita lo que hay en el panelPrincipal
        //panelPrincipal.add(panelTipo,BorderLayout.CENTER);
        panelPrincipal.add(varpanel,BorderLayout.CENTER); //agrega el atributo tipo panelinicio al panelPrincipal en el centro
        panelPrincipal.revalidate();//Le dice al administrador de diseño que vuelva a calcular el diseño
        panelPrincipal.repaint();//Le dice a Swing que un área de la ventana está sucia
     
    }


//Atributos de VentanaPrincipal
        /**
     *Este metodo se debe llamar en constructor de la clase para que corra la interfaz
     * WARNING: El codigo con fondo blanco no se puede modificar porque lo genera netbeans mientras estamos arrastrando
     * cosas de la interfaz c:.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        BarraDelMenu = new javax.swing.JMenuBar();
        menu_mas = new javax.swing.JMenu();
        menu_incio = new javax.swing.JMenuItem();
        menu_acercade = new javax.swing.JMenuItem();
        menu_graficas = new javax.swing.JMenu();
        menu_Graficas = new javax.swing.JMenuItem();
        menu_rango_fecha = new javax.swing.JMenuItem();
        menu_magnitud = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        panelPrincipal.setBackground(new java.awt.Color(86, 86, 100));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(1500, 962));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        BarraDelMenu.setBackground(new java.awt.Color(0, 0, 0));
        BarraDelMenu.setBorder(new javax.swing.border.MatteBorder(null));

        menu_mas.setText("▼");
        menu_mas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menu_incio.setText("Inicio");
        menu_incio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_incioActionPerformed(evt);
            }
        });
        menu_mas.add(menu_incio);

        menu_acercade.setText("Acerca de");
        menu_acercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_acercadeActionPerformed(evt);
            }
        });
        menu_mas.add(menu_acercade);

        BarraDelMenu.add(menu_mas);

        menu_graficas.setText("Estadísticas");
        menu_graficas.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        menu_Graficas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu_Graficas.setText("Gráficas");
        menu_Graficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_GraficasActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_Graficas);

        menu_rango_fecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu_rango_fecha.setText("Tabla de sismos en un rango de fecha");
        menu_rango_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_rango_fechaActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_rango_fecha);

        menu_magnitud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu_magnitud.setText("Tabla de sismos por magnitud");
        menu_magnitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_magnitudActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_magnitud);

        BarraDelMenu.add(menu_graficas);

        setJMenuBar(BarraDelMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Carga un panel en el que se presenta una tabla
 * @param evt 
 */
    private void menu_magnitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_magnitudActionPerformed
         try {
            /*
            Funcion:Ca
            Entradas:
            Salidas:
            */
            
            PanelClasificacionMagnitud varPanelClasificacion = new PanelClasificacionMagnitud();
            varPanelClasificacion.setLocation(70,0);
            varPanelClasificacion.setSize(varPanelClasificacion.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varPanelClasificacion);
            panelPrincipal.validate();
            panelPrincipal.repaint();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_menu_magnitudActionPerformed
    /**
     * Carga un panel que contiene un tabbed pane
     * @param evt :click en menu
     */
    private void menu_GraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_GraficasActionPerformed
        
        
            PanelGrafica varPanelTipo = new PanelGrafica();
            varPanelTipo.setLocation(70,0);
            varPanelTipo.setSize(varPanelTipo.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varPanelTipo);
            panelPrincipal.validate();
            panelPrincipal.repaint();
       
       
    }//GEN-LAST:event_menu_GraficasActionPerformed
    /**
     * carga y despliega el panel de inicio
     * @param evt 
     */
    private void menu_incioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_incioActionPerformed
        
        try {
            varpanel = new PanelInicio();
            varpanel.setLocation(0,0);
            varpanel.setSize(varpanel.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varpanel,BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_menu_incioActionPerformed
    /**
     * Mostrar informacion a cerca del programa
     * @param evt 
     */
    private void menu_acercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_acercadeActionPerformed

        JOptionPane.showMessageDialog(null,"Proyecto 1 de POO GR03.\nNatalia Vargas\nMax Lee\nAllison Solano\nDaniel Madrigal");
    }//GEN-LAST:event_menu_acercadeActionPerformed
/**
     *Carga un panel que presenta la tabla de sismos entre rango de fechas
     * @param evt 
     */
    private void menu_rango_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_rango_fechaActionPerformed
         /*
        Funcion:
        Entradas:
        Salidas:
        */
        try {
            /*
            Funcion:
            Entradas:
            Salidas:
            */
            PanelRangoFecha varPanelRango = new PanelRangoFecha();
            varPanelRango.setLocation(70,0);
            varPanelRango.setSize(varPanelRango.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varPanelRango);
            panelPrincipal.validate();
            panelPrincipal.repaint();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_rango_fechaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VentanaPrincipal().setVisible(true);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDelMenu;
    private javax.swing.JMenuItem menu_Graficas;
    private javax.swing.JMenuItem menu_acercade;
    private javax.swing.JMenu menu_graficas;
    private javax.swing.JMenuItem menu_incio;
    private javax.swing.JMenuItem menu_magnitud;
    private javax.swing.JMenu menu_mas;
    private javax.swing.JMenuItem menu_rango_fecha;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private void setText(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
