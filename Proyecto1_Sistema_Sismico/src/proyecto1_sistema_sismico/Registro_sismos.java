package proyecto1_sistema_sismico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Allison
 */
public final class Registro_sismos {
  
    ArrayList<Sismo> lista ;   
    //Para el libro de Excel
    String fileName = "BD.xlsx";
    String filePath =  fileName; 
    String hoja = "Hoja1"; 
    String[] header = new String[]{"Fecha", "Hora", "Profundidad","Origen","Detalle","Magnitud","Latitud","Longitud", "Provincia", "Descripcion Detallada"};
   

    @SuppressWarnings("Convert2Diamond")
    public Registro_sismos() throws IOException, FileNotFoundException, ParseException {
        lista = new ArrayList<Sismo>();
    }

    //Metodos
    /**
     * 
     * @return 
     * @throws java.io.FileNotFoundException
     * @throws IOException
     * @throws java.text.ParseException
     */
 
    public ArrayList<Sismo> cargar() throws FileNotFoundException, IOException, ParseException{
       /*
        Funcion: Cargar en una lista, todos los objetos que se encuentran en el excel
        Entradas: Ninguna
        Salidas: Ninguna
       */
        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
        if (excelFile.exists()) {

            String laFecha = "", laHora = "", profundidad = "", origen = "", detalle = "", magnitud = "", latitud= "", longitud= "", provincia= "", descripcion= "";             
            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook libro = new XSSFWorkbook(file);
            XSSFSheet hojaBD = libro.getSheetAt(0);

            int numFilas = hojaBD.getLastRowNum();

            for (int a = 1; a <= numFilas; a++) {
                Row fila = hojaBD.getRow(a);
                int numCols = fila.getLastCellNum();

                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    switch(b){

                        case 0:
                            laFecha = celda.getStringCellValue();
                            break;

                        case 1:
                            laHora = celda.getStringCellValue();
                            break;

                        case 2:
                            profundidad = celda.getStringCellValue();
                            break;

                        case 3:
                            origen = celda.getStringCellValue();
                            break;

                        case 4:
                            detalle = celda.getStringCellValue();
                            break;

                        case 5:
                            magnitud = celda.getStringCellValue();
                            break;

                        case 6:
                            latitud = celda.getStringCellValue();
                            break;

                        case 7:
                            longitud = celda.getStringCellValue();
                            break;

                        case 8:
                            provincia = celda.getStringCellValue();
                            break;

                        case 9:
                            descripcion = celda.getStringCellValue();
                            break;

                        default:
                            break;

                    }

                }
                //Crear objetos con la informacion del excel
                Sismo nuevoSismo = new Sismo(FormatosUtilitaria.convertirAFecha(laFecha), FormatosUtilitaria.convertirAHora(laHora),
                        Float.parseFloat(profundidad), TipoOrigen.valueOf(origen) ,detalle,Float.parseFloat(magnitud), 
                        Float.parseFloat(latitud),Float.parseFloat(longitud),Provincia.valueOf(provincia), descripcion);
                lista.add(nuevoSismo);

            }

     
        }
        
        return lista;
    }
 
    
    public void crearExcel(Sismo psismo) throws FileNotFoundException, IOException{
        /*
        Funcion: Crea el archivo de excel si no existe y si existe llamara a la funcion que agrega el sismo
        Entradas: Un objeto del tipo Sismo
        Salidas: Ninguna
        */

        File excelFile = new File("BD.xlsx"); // Referenciando a la ruta y el archivo Excel a crear

        if (excelFile.exists()) { // Si el archivo existe 
            agregar_sismo(psismo);   
    
        }else{
            Excel_BD.crear_Excel();
            agregar_sismo(psismo);
        }  
    }
    
    @SuppressWarnings("UnusedAssignment")
    public void agregar_sismo(Sismo psismo) throws FileNotFoundException, IOException{
        
        /*
        Funcion: Agregar un sismo al archivo excel
        Entradas: Un objeto Sismo
        Salidas: Ninguna
        */
        
        lista.add(psismo);  
        Excel_BD.AgregarSismoAExcel(psismo);
        System.out.println("TAMANO LISTA DESPUES DE AGREGAR: "); System.out.println(lista.size());
        JOptionPane.showMessageDialog(null, "AGREGAR_SISMO: "+lista.size());

    }
    
    public void modificar_sismo(Sismo psismo, int pos) throws FileNotFoundException, IOException{
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        
        //FALTA MODIFICAR LA LISTA lista.modificar(psismo,pos) XD
        Excel_BD.ModificarExcel(psismo, pos);
        JOptionPane.showMessageDialog(null, "Modificado correctamente!");
        
    }
    
    public void cant_sismos_provincia(){
         /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        
    }
    public int[] cant_sismos_mesEnAnnio_lista(int pannio){
        int[] array = new int[12];
        for (int i=0 ; i < lista.size() ; i++){
            Sismo sismo = lista.get(i);
            if (sismo.getAnnio() == pannio){
                int mes = sismo.getMes();
                System.out.println("mes: " + mes);
                switch (mes){
                    case 0 :
                        array[0] = array[0]+1;
                        break;
                    case 1 :
                        array[1] = array[1]+1;
                        break;
                    case 2 :
                        array[2] = array[2]+1;
                        break;
                    case 3 :
                        array[3] = array[3]+1;
                        break;
                    case 4 :
                        array[4] = array[4]+1;
                        break;
                    case 5 :
                        array[5] = array[5]+1;
                        break;
                    case 6 :
                        array[6] = array[6]+1;
                        break;
                    case 7 :
                        array[7] = array[7]+1;
                        break;
                    case 8 :
                        array[8] = array[8]+1;
                        break;
                    case 9 :
                        array[9] = array[9]+1;
                        break;
                    case 10 :
                        array[10] = array[10]+1;
                        break;
                    case 11 :
                        array[11] = array[11]+1;
                        break;
                    
                    
                }
            }
        }
        return array;
    }
    public ChartPanel cant_sismos_mesEnAnnio(int pannio){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        int[] array = cant_sismos_mesEnAnnio_lista(pannio);
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(array[0], "Sismos en", "Enero");
        data.addValue(array[1], "Sismos", "Febrero");
        data.addValue(array[2], "Sismos", "Marzo");
        data.addValue(array[3], "Sismos", "Abril");
        data.addValue(array[4], "Sismos", "Mayo");
        data.addValue(array[5], "Sismos", "Junio");
        data.addValue(array[6], "Sismos", "Julio");
        data.addValue(array[7], "Sismos", "Agosto");
        data.addValue(array[8], "Sismos", "Septiembre");
        data.addValue(array[9], "Sismos", "Octubre");
        data.addValue(array[10], "Sismos", "Noviembre");
        data.addValue(array[11], "Sismos", "Diciembre");
        
        
        
        //Se crea la grafica de BARRAS pasandole los datos
        JFreeChart grafica = ChartFactory.createBarChart("Sismos", "Meses", "Cantidad de sismos", data, PlotOrientation.VERTICAL, false, true, false);
        //Panel de la grafica
        ChartPanel contenedor = new ChartPanel(grafica);
        return contenedor;
        
        
    }
    
    public void ocurrido_en_rango(Date pfecha_inicio,Date pfecha_final){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
    }
    public int[] cant_sismo_tipo_lista(){
        /*
        Funcion: Lee la lista y llena el array con la cantidad dependiento del tipo de origen
        Entradas: void
        Salidas: int array 
        */
        int [] array =new int[5];
        for (int i = 0 ; i<lista.size();i++){
            Sismo sismo = lista.get(i);
            TipoOrigen origen = sismo.getOrigen();
            
            if(sismo.getOrigen() == TipoOrigen.CHOQUE_PLACAS){
                array[0] = array[0]+1;
            }
            else if (sismo.getOrigen() == TipoOrigen.SUBDUCCION_PLACA){
                array[1] = array[1]+1;
            }
            else if (sismo.getOrigen() == TipoOrigen.DEFORMACION_INTERNA){
                array[2] = array[2]+1;
            }
            else if(origen == TipoOrigen.TECTONICO_SUBDUCCION){
                array[3] = array[3]+1;
            }
            else {
                array[4] = array[4]+1;
            }
            
        }
        return array;
    }
    public void cant_sismos_tipo(){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        int[] array = this.cant_sismo_tipo_lista();
        
        //Crea la "base de datos" que usa la graafica
        DefaultPieDataset data = new DefaultPieDataset();
        
        //El ultimo dato es la porcion que va a cubrir en el grafico
        data.setValue("Choque de placas", array[0]);
        data.setValue("Subducción de placa", array[1]);
        data.setValue("Deformación Interna", array[2]);
        data.setValue("Téctonico por subducción", array[3]);
        data.setValue("Téctonico por falla local", array[4]); 
        
        //Se crea la grafica de pastel
        JFreeChart chart = ChartFactory.createPieChart("Tipo de Origen ",data,true, false, false);
        chart.removeLegend();
        ChartPanel contenedor = new ChartPanel(chart);
        
        //crea la ventana y le agrega la grafica
        JFrame ventana = new JFrame();
        ventana.add(contenedor);
        ventana.setSize(1000,500);
        ventana.setTitle("Sismos por tipo de origen");
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
    
    public void clasificacion_por_magnitud(){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */

    }

    Object size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
