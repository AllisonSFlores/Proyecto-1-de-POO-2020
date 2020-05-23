/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_sistema_sismico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nvvar
 */
public class Excel_BD {
    
    private static String fileName = "BD.xlsx";
    private static String filePath =  fileName; 
    private static String hoja = "Hoja1"; 
    private static String[] header = new String[]{"Fecha", "Hora", "Profundidad","Origen","Detalle","Magnitud","Latitud","Longitud", "Provincia", "Descripcion Detallada"};

   public static void crear_Excel(){
       
        //Cabecera de la hoja de excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(hoja);
    
        //Aplicando estilo color negrita a los encabezados
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);//Seteando fuente negrita al encabezado del archivo excel
        style.setFont(font);
        
        File excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
 
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
            
  
            }catch (Exception e) {
            }
        
   
   }
    
    
    
    
    public static void AgregarSismoAExcel(Sismo psismo) throws FileNotFoundException, IOException{
    
    //Contenido de la hoja de excel
        String[] document = new String[]{
            FormatosUtilitaria.formatoFecha(psismo.getFecha()), FormatosUtilitaria.formatoHora(psismo.getHora()), 
            String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), psismo.getDetalle(), 
            String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),String.valueOf(psismo.getLongitud()),
            psismo.getProvincia().name(), psismo.getDescripcion_detallada()}
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

    
    }
    
    
    public static void ModificarExcel(Sismo psismo, int pos) throws FileNotFoundException, IOException{
        
        String[] document = new String[]{
            FormatosUtilitaria.formatoFecha(psismo.getFecha()), FormatosUtilitaria.formatoHora(psismo.getHora()), 
            String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), 
            psismo.getDetalle(), String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),
            String.valueOf(psismo.getLongitud()), psismo.getProvincia().name(), psismo.getDescripcion_detallada()};
        
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
    
    }
}
