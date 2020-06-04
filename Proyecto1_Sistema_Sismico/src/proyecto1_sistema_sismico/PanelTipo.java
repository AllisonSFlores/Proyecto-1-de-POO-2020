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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Allison
 */
public class PanelTipo extends javax.swing.JPanel {
    Registro_sismos listaG = Registro_Singleton.getRegistro_Singleton();
    
   
     public PanelTipo() throws IOException, FileNotFoundException, ParseException {
         initComponents();
         agregargrafica();
     }
     /**
      * Manda los datos a graficar y espera la grafica para annadirla al panel
      */
     private void agregargrafica(){
        ChartPanel contenedor;
        contenedor = graficaTipo(listaG.cant_sismo_tipo_lista());
        
        contenedor.setSize(this.getWidth(),this.getHeight());
        contenedor.setVisible(true);
        this.removeAll();
        this.add(contenedor,BorderLayout.CENTER);
        contenedor.repaint();
        this.revalidate();
        this.repaint();
        
     }
     /**
      * Crea el dataset para la grafica usando el array
      * @param parray
      * @return DefaultPieDataset data
      */
    public DefaultPieDataset data_sismos_tipo(int[] parray){
        
        //Crea la "base de datos" que usa la graafica
        DefaultPieDataset data = new DefaultPieDataset();
        
        //El ultimo dato es la porcion que va a cubrir en el grafico
        data.setValue("Choque de placas", parray[0]);
        data.setValue("Subducción de placa", parray[1]);
        data.setValue("Deformación Interna", parray[2]);
        data.setValue("Téctonico por subducción", parray[3]);
        data.setValue("Téctonico por falla local", parray[4]); 
        return data;
        
    }
    /**
     * Crea la grafica y la agrega a la ventana
     * @param parray : dato a graficar
     * @return chartpanel listo para ser agregado al panel
     */
    public ChartPanel graficaTipo(int []parray){
        DefaultPieDataset data =data_sismos_tipo(parray);
        
        //Se crea la grafica de pastel
        JFreeChart chart = ChartFactory.createPieChart("Sismo por tipo de Origen ", data ,false,true,false);
        
        ChartPanel chartpanel = new ChartPanel(chart,true);
        
        return chartpanel;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(86, 86, 100));
        setMaximumSize(new java.awt.Dimension(1500, 900));
        setPreferredSize(new java.awt.Dimension(1450, 850));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
