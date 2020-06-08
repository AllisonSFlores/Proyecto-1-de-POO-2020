package proyecto1_sistema_sismico;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Allison
 */
public final class Registro_sismos {
  
    ArrayList<Sismo> lista ;   
   

    @SuppressWarnings("Convert2Diamond")
    public Registro_sismos(){
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
    
    /**
     * Cargar en una lista, todos los objetos que se encuentran en el excel
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public ArrayList<Sismo> cargar() throws IOException, FileNotFoundException, ParseException {
        lista = Excel_BD.cargar_Excel();
        return lista;
    }
 
    /**
     * Crea el archivo de excel si no existe y si existe llamara a la funcion que agrega el sismo
     * @param psismo
     * @throws IOException 
     */
    public void crearExcel(Sismo psismo) throws IOException {

        File excelFile = new File("BD.xlsx"); // Referenciando a la ruta y el archivo Excel a crear

        if (excelFile.exists()) { // Si el archivo existe 
            agregar_sismo(psismo);   
    
        }else{
            Excel_BD.crear_Excel();
            agregar_sismo(psismo);
        }  
    }
    /**
     * Agregar un sismo a la lista
     * @param psismo
     * @throws IOException 
     */
    @SuppressWarnings("UnusedAssignment")
    public void agregar_sismo(Sismo psismo) throws IOException{
        lista.add(psismo);  
        Excel_BD.AgregarSismoAExcel(psismo);
        System.out.println("TAMANO LISTA DESPUES DE AGREGAR: "); System.out.println(lista.size());
        JOptionPane.showMessageDialog(null, "AGREGAR_SISMO: "+lista.size());

    }
    /**
     * Modificar la lista de sismos
     * @param psismo :Un sismo y una posicion entera
     * @param pos
     * @throws IOException 
     */
    public void modificar_sismo(Sismo psismo, int pos) throws IOException {
  
        lista.set(pos-1, psismo);
        Excel_BD.ModificarExcel(psismo, pos);
        JOptionPane.showMessageDialog(null, "Modificado correctamente!");
        
    }
    /**
     * Busca los sismo en esa provincia y agrega sus magnitudes en un arreglo
     * @param pprovincia
     * @return magnitudes double []
     */
    public double [] cant_sismos_provincia(String pprovincia){
        int largoMagnitud = 0;
        int array=0;
        
        for (int i =0 ; i<lista.size(); i++){
            if(lista.get(i).getProvincia().nombre.equals(pprovincia)){
                largoMagnitud++;
            }
        }
        double [] magnitudes= new double[largoMagnitud];
        System.out.println(largoMagnitud);
        for (int i = 0 ; i<lista.size();i++){
            Sismo sismo = lista.get(i);
            
            if(sismo.getProvincia().nombre.equals(pprovincia)){
                magnitudes[array]=(double) sismo.getMagnitud();
                array++;        
            }
        }
       return magnitudes;
                
    }
    /**
     * Genera un arreglo de los sismos por mes en el annio recibido
     * @param pannio
     * @return array int []
     */
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
    /**
     * 
     * @param pfecha_inicio
     * @param pfecha_final 
     */
    public void ocurrido_en_rango(Date pfecha_inicio,Date pfecha_final){
        
    }
    
    /**
     * Lee la lista y llena el array con la cantidad dependiendo del tipo de origen
     * @return arra :int []
     */
    public int[] cant_sismo_tipo_lista(){
        
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
    
    
    /**
     * 
     */
    public void clasificacion_por_magnitud(){

    }
    
    Object size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
