package proyecto1_sistema_sismico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Allison
 */
public final class Registro_sismos {
    //Atributos
    ArrayList<Sismo> lista ;
    SimpleDateFormat fecha;
    SimpleDateFormat hora;
   
    //Para el libro de Excel
    String fileName = "BD.xlsx";
    String filePath =  fileName; 
    String hoja = "Hoja1"; 
    String[] header = new String[]{"Fecha", "Hora", "Profundidad","Origen","Detalle","Magnitud","Latitud","Longitud", "Provincia", "Descripcion Detallada"};
   

    @SuppressWarnings("Convert2Diamond")
    public Registro_sismos() throws IOException, FileNotFoundException, ParseException {
        lista = new ArrayList<Sismo>();
        fecha = new SimpleDateFormat("dd/mm/yyyy");
        hora = new SimpleDateFormat("HH:mm:ss");
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
            Sismo nuevoSismo = new Sismo(fecha.parse(laFecha), hora.parse(laHora),Float.parseFloat(profundidad), TipoOrigen.valueOf(origen) ,detalle,Float.parseFloat(magnitud), Float.parseFloat(latitud),Float.parseFloat(longitud),Provincia.valueOf(provincia), descripcion);
            lista.add(nuevoSismo);
        }
        return lista;
     

    }
 
    
    public void crearExcel(Sismo psismo) throws FileNotFoundException, IOException{
        /*
        Funcion: Crea el archivo de excel si no existe y si existe llamara a la funcion que agrega el sismo
        Entradas: Un objeto del tipo Sismo
        Salidas: Ninguna
        */

        //Cabecera de la hoja de excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(hoja);
    
        //Aplicando estilo color negrita a los encabezados
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);//Seteando fuente negrita al encabezado del archivo excel
        style.setFont(font);
        
        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear

        if (excelFile.exists()) { // Si el archivo existe 
            agregar_sismo(psismo);   
    
        }else{
            try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) { //crea el archivo con su ruta
                
                XSSFRow row = hoja1.createRow(0);//se crea una fila

                for (int j = 0; j < header.length; j++) {
                    XSSFCell cell = row.createCell(j);//Crear la celda para el header
                    cell.setCellStyle(style); //annadir estilo a la celda creada anteriormente
                    cell.setCellValue(header[j]);//se ponen los titulos del header

                } 
                
                System.out.println("Archivo Creado!");
                book.write(fileOuS);
                fileOuS.flush();
                fileOuS.close(); 
                agregar_sismo(psismo);
  
            }catch (Exception e) {
            }
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

        //Contenido de la hoja de excel
        String[] document = new String[]{
            fecha.format(psismo.getFecha()), hora.format(psismo.getHora()), String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), psismo.getDetalle(), String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),String.valueOf(psismo.getLongitud()), psismo.getProvincia().name(), psismo.getDescripcion_detallada()}
        ;
        
        //CON ESTO SE SABE CUAL HOJA DE CUAL LIBRO EXCEL DEBE LEER//
        FileInputStream file = new FileInputStream(new File(filePath));
        FileOutputStream fileOuS;
        
        try (XSSFWorkbook libro = new XSSFWorkbook(file)) {
            XSSFSheet hojaBD = libro.getSheetAt(0);
          
            //Generando el contenido del archivo de Excel
            XSSFRow row = hojaBD.createRow(hojaBD.getLastRowNum() + 1);
          
            for (int j = 0; j < header.length; j++) {
                XSSFCell cell = row.createCell(j);//Creando celda para el contenido del producto
                cell.setCellValue(document[j]); //Annadiendo el contenido
            }
            
            fileOuS = null;
            File excelFile = new File(filePath);
            fileOuS= new FileOutputStream(excelFile);
            libro.write(fileOuS);
        }
        fileOuS.close();

        System.out.println("TAMANO LISTA DESPUES DE AGREGAR: "); System.out.println(lista.size());
        JOptionPane.showMessageDialog(null, "AGREGAR_SISMO: "+lista.size());

    }
    
    public void modificar_sismo(Sismo psismo, int pos) throws FileNotFoundException, IOException{
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        String[] document = new String[]{
        fecha.format(psismo.getFecha()), hora.format(psismo.getHora()), String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), psismo.getDetalle(), String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),String.valueOf(psismo.getLongitud()), psismo.getProvincia().name(), psismo.getDescripcion_detallada()};
        
        //CON ESTO SE SABE CUAL HOJA DE CUAL LIBRO EXCEL DEBE LEER//
            
        FileInputStream file = new FileInputStream(new File(filePath));
        FileOutputStream fileOuS;
        
        try (XSSFWorkbook libro = new XSSFWorkbook(file)) {
            XSSFSheet hojaBD = libro.getSheetAt(0);
          
            
            //Generando el contenido del archivo de Excel          
            XSSFRow fila = hojaBD.getRow(pos);
          
            for (int j = 0; j < header.length; j++) {
                XSSFCell cell = fila.createCell(j);//Creando celda para el contenido del producto
                cell.setCellValue(document[j]); //Annadiendo el contenido
            }
            
            fileOuS = null;
            File excelFile = new File(filePath);
            fileOuS= new FileOutputStream(excelFile);
            libro.write(fileOuS);
        }
        fileOuS.close();
        JOptionPane.showMessageDialog(null, "Modificado correctamente!");
        
    }
    
    public void cant_sismos_provincia(){
         /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        
    }
    
    public void cant_sismos_mesEnAnnio(String pannio){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
                
    }
    
    public void ocurrido_en_rango(Date pfecha_inicio,Date pfecha_final){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
    }
    
    public void cant_sismos_tipo(){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
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
