package proyecto1_sistema_sismico;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Allison
 */
public class Registro_sismos {
    //Atributo
    private ArrayList<Sismo> lista ;
    
    //Constructores

    public Registro_sismos() {
        lista = new ArrayList<Sismo>();
    }
    
    //Metodos
    public void cargar(){
        
    }
    
    public void agregar_sismo(Sismo psismo){
        
        
        SimpleDateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        
        String fileName = "BD.xlsx";
        String filePath =  fileName; //"D:\\SEMESTRE 1 2020\\POO\\PROYECTOS\\Proyecto-1-de-POO-2020\\" +
        //Seteando el nombre de la hoja donde agregaremos los items
        String hoja = "Hoja1"; 
         
        //Creando objeto libro de Excel
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet hoja1 = book.createSheet(hoja);
         
        //Cabecera de la hoja de excel
        String[] header = new String[]{"Fecha", "Hora", "Profundidad","Origen","Detalle","Magnitud","Latitud","Longitud", "Provincia y descripcion Detallada"};
 
        //Contenido de la hoja de excel
        String[][] document = new String[][]{
            {fecha.format(psismo.getFecha()), hora.format(psismo.getHora()), String.valueOf(psismo.getProfundidad()),psismo.getOrigen().name(), psismo.getDetalle(), String.valueOf(psismo.getMagnitud()), String.valueOf(psismo.getLatitud()),String.valueOf(psismo.getLongitud()), psismo.getProvincia().name()+", "+ psismo.getDescripcion_detallada()}
        };
 
        //Aplicando estilo color negrita a los encabezados
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);//Seteando fuente negrita al encabezado del archivo excel
        style.setFont(font);
 
        //Generando el contenido del archivo de Excel
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row = hoja1.createRow(i);//se crea la fila
            
            for (int j = 0; j < header.length; j++) {
                
                if (i == 0) {//Recorriendo cabecera
                    XSSFCell cell = row.createCell(j);//Crear la celda de la cabecera 
                    cell.setCellStyle(style); //annadir estilo a la celda creada anteriormente
                    cell.setCellValue(header[j]);//se ponen los titulos del header
                    
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//Creando celda para el contenido del producto
                    cell.setCellValue(document[i - 1][j]); //AÃ±adiendo el contenido
                }
            }
        }
 
        File excelFile;
        excelFile = new File(filePath); // Referenciando a la ruta y el archivo Excel a crear
        
        try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) {
            if (excelFile.exists()) { // Si el archivo existe lo eliminaremos
                excelFile.delete();
                
            }
            book.write(fileOuS);
            fileOuS.flush();
            fileOuS.close(); 
            System.out.println("Archivo Creado!");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    
    public void modificar_sismo(Sismo psismo){
        
    }
    
    public void cant_sismos_provincia(){
        
    }
    
    public void cant_sismos_mesEnAnnio(String pannio){
        
    }
    
    public void ocurrido_en_rango(Date pfecha_inicio,Date pfecha_final){
        
    }
    
    public void cant_sismos_tipo(){
        
    }
    
    public void clasificacion_por_magnitud(){
        
    }
    
}
