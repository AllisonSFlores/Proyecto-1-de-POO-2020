package proyecto1_sistema_sismico;
import javax.swing.JFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.*;
/**
 * @author Allison
 */
public class Grafica {
    Grafica(){
    }
    static DefaultPieDataset data_sismos_tipo(int[] parray){
        /*
        Funcion: Crea el dataset para la grafica usando el array
        Entradas: int[]
        Salidas: DefaultPieDataset data
        */
        
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
    //static PanelTipo graficaTipo(int []parray){
    static ChartPanel graficaTipo(int []parray){
        /*
        Funcion:Crea la grafica y la agrega a la ventana
        Entradas:int [] parray
        Salidas: PanelTipo
        */
        DefaultPieDataset data =data_sismos_tipo(parray);
        
        //Se crea la grafica de pastel
        JFreeChart chart = ChartFactory.createPieChart("Sismo por tipo de Origen ", data ,false,false,false);
        
        ChartPanel contenedor = new ChartPanel(chart,true);
        
        return contenedor;
        //return varPanelTipo;
    }
}
