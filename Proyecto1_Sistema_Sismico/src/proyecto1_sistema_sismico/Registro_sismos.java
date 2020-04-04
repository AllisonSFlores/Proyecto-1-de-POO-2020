package proyecto1_sistema_sismico;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
    private final ArrayList<Sismo> lista ;
    //Creando objeto libro de Excel
    String fileName = "BD.xlsx";
    String filePath =  fileName; 
    String hoja = "Hoja1"; 
    XSSFWorkbook book = new XSSFWorkbook();
    XSSFSheet hoja1 = book.createSheet(hoja);
    String[] header = new String[]{"Fecha", "Hora", "Profundidad","Origen","Detalle","Magnitud","Latitud","Longitud", "Provincia", "Descripcion Detallada"};
   
    
    //Constructores

    @SuppressWarnings("Convert2Diamond")
    public Registro_sismos() throws IOException, FileNotFoundException, ParseException {
        lista = new ArrayList<Sismo>();
        
    }
    
    //Metodos
  public void cargar() throws FileNotFoundException, IOException, ParseException{
       /*
        Funcion:
        Entradas:
        Salidas:
       */
        String laFecha = "", laHora = "", profundidad = "", origen = "", detalle = "", magnitud = "", latitud= "", longitud= "", provincia= "", descripcion= "";
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
               
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
            //Sismo nuevoSismo = new Sismo(fecha.parse("31/03/2020"), hora.parse("24:02:50"),7, TipoOrigen.CHOQUE_PLACAS ,"detalle",4, 5,6,Provincia.CARTAGO, "descripcion");
            Sismo nuevoSismo = new Sismo(fecha.parse(laFecha), hora.parse(laHora),Float.parseFloat(profundidad), TipoOrigen.valueOf(origen) ,detalle,Float.parseFloat(magnitud), Float.parseFloat(latitud),Float.parseFloat(longitud),Provincia.valueOf(provincia), descripcion);
            lista.add(nuevoSismo);
        }
        System.out.println(lista.size());
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getFecha());
            System.out.println(lista.get(i).getOrigen());
        }
        
 
 }

     
        
    
    public void crearExcel(Sismo psismo) throws FileNotFoundException, IOException{
        /*
        Funcion: Crea el archivo de excel si no existe y si existe llamara a la funcion que agrega el sismo
        Entradas: Un objeto del tipo Sismo
        Salidas: Ninguna
        */

        //Cabecera de la hoja de excel
        
    
        //Aplicando estilo color negrita a los encabezados
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);//Seteando fuente negrita al encabezado del archivo excel
        style.setFont(font);
        
        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear

        if (excelFile.exists()) { // Si el archivo existe 
            agregar_sismo(psismo);   
             //excelFile.delete();
    
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
                 e.printStackTrace();
            }
        }  
    }
    
    public void agregar_sismo(Sismo psismo) throws FileNotFoundException, IOException{
        
        /*
        Funcion: Agregar un sismo al archivo excel
        Entradas: Un objeto Sismo
        Salidas: Ninguna
        */
        
        lista.add(psismo);
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
  
        //Contenido de la hoja de excel
        String[][] document = new String[][]{
            {fecha.format(psismo.getFecha()), hora.format(psismo.getHora()), String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), psismo.getDetalle(), String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),String.valueOf(psismo.getLongitud()), psismo.getProvincia().name(), psismo.getDescripcion_detallada()}
        };
        
        //CON ESTO SE SABE CUAL HOJA DE CUAL LIBRO EXCEL DEBE LEER//
        FileInputStream file = new FileInputStream(new File(filePath));
        FileOutputStream fileOuS;
        
        try (XSSFWorkbook libro = new XSSFWorkbook(file)) {
            XSSFSheet hojaBD = libro.getSheetAt(0);
          
            //Generando el contenido del archivo de Excel
            XSSFRow row = hojaBD.createRow(hojaBD.getLastRowNum() + 1);
          
            for (int j = 0; j < header.length; j++) {
                XSSFCell cell = row.createCell(j);//Creando celda para el contenido del producto
                cell.setCellValue(document[0][j]); //Annadiendo el contenido
            }
            
            fileOuS = null;
            File excelFile = new File(filePath);
            fileOuS= new FileOutputStream(excelFile);
            libro.write(fileOuS);
        }
        fileOuS.close();

        System.out.println("Agregado con exito!");
        System.out.println("TAMANO LISTA DESPUES DE AGREGAR: "); System.out.println(lista.size());

    }
    
    public void modificar_sismo(Sismo psismo){
        /*
        Funcion: 
        Entradas: 
        Salidas: 
        */
        
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
    
}
