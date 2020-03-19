/*
Creado por Natalia Vargas, Allison Solano, Max Lee
Fecha de creación: 20/03/2020
Ultima modifcacion: 20/03/2020
Hecho en Java con NetBeans IDE 8.2
 */
//Paquete al que pertenece este .java
package proyecto1_sistema_sismico;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;



public class Proyecto1_Sistema_Sismico {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // TODO code application logic here
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja1 = libro.createSheet("Hoja de prueba");
        HSSFRow fila =  hoja1.createRow(5);
        HSSFCell celda = fila.createCell(1);
        String txt = "HOLA MUNDO";
        HSSFRichTextString texto = new HSSFRichTextString(txt);
        
        try{
            FileOutputStream arch = new FileOutputStream("sisirve.xlsx");
            libro.write(arch);
            
        }catch(IOException e){
            System.out.println("No sirve");
        
        }

    }
    
}
