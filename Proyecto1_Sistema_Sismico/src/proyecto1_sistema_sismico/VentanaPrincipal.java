/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_sistema_sismico;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author XT
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    PanelInicio varpanel;
    Registro_sismos listaG = Registro_Singleton.getRegistro_Singleton();
    
    public VentanaPrincipal() throws IOException, FileNotFoundException, ParseException {
        
        this.varpanel = new PanelInicio();
        initComponents();

        //Hacer que empiece con el PanelInicio
        varpanel.setLocation(0,0);
        varpanel.setSize(varpanel.getMaximumSize());
        panelPrincipal.removeAll();//quita lo que hay en el panelPrincipal
        panelPrincipal.add(varpanel,BorderLayout.CENTER); //agrega el atributo tipo panelinicio al panelPrincipal en el centro
        panelPrincipal.revalidate();//Le dice al administrador de diseño que vuelva a calcular el diseño
        panelPrincipal.repaint();//Le dice a Swing que un área de la ventana está sucia
     
    }


//Atributos de VentanaPrincipal
        /**
     *Este metodo se debe llamar en constructor de la clase para que corra la interfaz
     * WARNING: El codigo con fondo blanco no se puede modificar porque lo genera netbeans mientra estamos arrastrando
     * cosas de la interfaz.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        BarraDelMenu = new javax.swing.JMenuBar();
        menu_mas = new javax.swing.JMenu();
        menu_incio = new javax.swing.JMenuItem();
        menu_acercade = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        menu_graficas = new javax.swing.JMenu();
        menu_provincia = new javax.swing.JMenuItem();
        menu_tipo = new javax.swing.JMenuItem();
        menu_rango_fecha = new javax.swing.JMenuItem();
        menu_annio = new javax.swing.JMenuItem();
        menu_magnitud = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(1500, 962));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        BarraDelMenu.setBackground(new java.awt.Color(0, 0, 0));
        BarraDelMenu.setBorder(new javax.swing.border.MatteBorder(null));

        menu_mas.setText("☰");

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

        menu_salir.setText("Salir");
        menu_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salirActionPerformed(evt);
            }
        });
        menu_mas.add(menu_salir);

        BarraDelMenu.add(menu_mas);

        menu_graficas.setText(" Gráficas");

        menu_provincia.setText("Sismos por provincia");
        menu_provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_provinciaActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_provincia);

        menu_tipo.setText("Sismos por tipo de origen ");
        menu_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_tipoActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_tipo);

        menu_rango_fecha.setText("Sismos en un rango de fecha");
        menu_rango_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_rango_fechaActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_rango_fecha);

        menu_annio.setText("Sismos por mes en un año");
        menu_annio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_annioActionPerformed(evt);
            }
        });
        menu_graficas.add(menu_annio);

        menu_magnitud.setText("Sismos por magnitud");
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

    private void menu_annioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_annioActionPerformed
        /*
        Funcion:
        Entradas:
        Salidas:
        */
        ChartPanel contenedor = listaG.cant_sismos_mesEnAnnio(2020);
        JFrame ventana = new JFrame();
        ventana.add(contenedor);
        ventana.setSize(1000,500);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null); 
        
        //listaG.cant_sismos_mesEnAnnio("2019");
        
    }//GEN-LAST:event_menu_annioActionPerformed

    private void menu_magnitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_magnitudActionPerformed
        /*
        Funcion:
        Entradas:
        Salidas:
        */
        try {
            PanelMagnitud varpanel2 =new PanelMagnitud();
            varpanel2.setLocation(0,0);
            varpanel2.setSize(varpanel2.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varpanel2,BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menu_magnitudActionPerformed

    private void menu_provinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_provinciaActionPerformed
        /*
        Funcion:
        Entradas:
        Salidas:
        */
       
    }//GEN-LAST:event_menu_provinciaActionPerformed

    private void menu_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_tipoActionPerformed
        /*
        Funcion: Llama la funcion que despliega la grafica
        Entradas: evento 
        Salidas: void
        */
        listaG.cant_sismos_tipo();
        
        
    }//GEN-LAST:event_menu_tipoActionPerformed

    private void menu_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salirActionPerformed
        /*
        Funcion: Cerrar el programa
        Entradas: Ninguna
        Salidas: Ninguna
        */
        System.exit(0); //Termina de correr el programa
    }//GEN-LAST:event_menu_salirActionPerformed

    private void menu_incioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_incioActionPerformed
        /*
        Funcion:
        Entradas:
        Salidas:
        */
        try {
            PanelInicio varpanel5 = new PanelInicio();
            varpanel5.setLocation(0,0);
            varpanel5.setSize(varpanel5.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varpanel5,BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_menu_incioActionPerformed

    private void menu_rango_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_rango_fechaActionPerformed
        /*
        Funcion:
        Entradas:
        Salidas:
        */
        try {
            PanelRangoFecha varpanel6 =new PanelRangoFecha();
            varpanel6.setLocation(0,0);
            varpanel6.setSize(varpanel6.getMaximumSize());
            panelPrincipal.removeAll();
            panelPrincipal.add(varpanel6,BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menu_rango_fechaActionPerformed

    private void menu_acercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_acercadeActionPerformed
        /*
        Funcion: Mostrar informacion a cerca del programa
        Entradas: Ninguna
        Salidas: Ninguna
        */
        JOptionPane.showMessageDialog(null,"Proyecto 1 de POO GR03.\nNatalia Vargas\nMax Lee\nAllison Solano");
    }//GEN-LAST:event_menu_acercadeActionPerformed

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
    private javax.swing.JMenuItem menu_acercade;
    private javax.swing.JMenuItem menu_annio;
    private javax.swing.JMenu menu_graficas;
    private javax.swing.JMenuItem menu_incio;
    private javax.swing.JMenuItem menu_magnitud;
    private javax.swing.JMenu menu_mas;
    private javax.swing.JMenuItem menu_provincia;
    private javax.swing.JMenuItem menu_rango_fecha;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JMenuItem menu_tipo;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private void setText(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
