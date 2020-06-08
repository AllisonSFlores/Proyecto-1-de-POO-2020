package proyecto1_sistema_sismico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;


/**
 * @author Allison
 */
public class PanelProvincia extends javax.swing.JPanel {
    
    ChartPanel contenedor;
    
    public PanelProvincia()throws IOException, FileNotFoundException, ParseException  {
        
        initComponents();
        empezar(jComboBoxProvinciaG.getSelectedItem().toString());
        
        
    }
    /**
     * recibe la provincia y espera  a que se haga la grafica para insertarla al panel
     * @param pprovincia :La provincia que se busca
     */
    private void empezar(String pprovincia){
        try{
            
            Registro_sismos listaG = Registro_Singleton.getRegistro_Singleton();
            double [] pvector = listaG.cant_sismos_provincia(pprovincia);
            //double [] pvector = {1,1,1,3,4,4};
            JPanel chart = crearHistograma(pvector);
        
            jPanelGrafica.removeAll();
            jPanelGrafica.add(chart);
            jPanelGrafica.revalidate();
            jPanelGrafica.repaint();
        } catch (IOException | ParseException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    /**
     * Crea la estructura de con los datos que requiere el histograma
     * @param pvector :datos a graficar
     * @return JFreeChart chart : datos
     */
    private  IntervalXYDataset crearDataset(double []pvector) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Sismos", pvector, 25);
        
        return dataset;
    }
    /**
     * crea un histograma con los datos que recibe
     * @param pdataset : estructura con los datos a graficar
     * @return chart grafica ya hecho
     */
    private  JFreeChart crearChart(IntervalXYDataset pdataset) {
        JFreeChart chart = ChartFactory.createHistogram("Frecuencia de sismos por rangos ","Magnitudes","Frecuencia",pdataset,PlotOrientation.VERTICAL,true,true,false);

        return chart;
    }
    /**
     * Agrega un histograma a un ChartPanel y la grafica queda lista
     * @param pvector   :datos a graficar
     * @return ChartPanel : grafica lista
     */
    public  JPanel crearHistograma(double []pvector) {
        JFreeChart chart = crearChart(crearDataset(pvector));
        return new ChartPanel(chart);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxProvinciaG = new javax.swing.JComboBox<>();
        jPanelGrafica = new javax.swing.JPanel();

        setBackground(new java.awt.Color(86, 86, 100));
        setMaximumSize(new java.awt.Dimension(1500, 962));
        setPreferredSize(new java.awt.Dimension(900, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxProvinciaG.setBackground(new java.awt.Color(86, 86, 100));
        jComboBoxProvinciaG.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBoxProvinciaG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José", "Cartago", "Heredia", "Alajuela", "Puntarenas", "Guanacaste", "Limón" }));
        jComboBoxProvinciaG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProvinciaGActionPerformed(evt);
            }
        });
        add(jComboBoxProvinciaG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 1350, 40));

        jPanelGrafica.setBackground(new java.awt.Color(86, 86, 100));
        jPanelGrafica.setLayout(new javax.swing.BoxLayout(jPanelGrafica, javax.swing.BoxLayout.LINE_AXIS));
        add(jPanelGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 1350, 760));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxProvinciaGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProvinciaGActionPerformed
        jPanelGrafica.removeAll();
        empezar(jComboBoxProvinciaG.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxProvinciaGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxProvinciaG;
    private javax.swing.JPanel jPanelGrafica;
    // End of variables declaration//GEN-END:variables
}
