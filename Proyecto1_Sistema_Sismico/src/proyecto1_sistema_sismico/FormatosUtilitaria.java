package proyecto1_sistema_sismico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NataliaVR
 */
public class FormatosUtilitaria {
    
    private static SimpleDateFormat pfecha = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat phora = new SimpleDateFormat("HH:mm:ss");;
    
    /**
     * Pasa un date fecha a un string
     * @param fecha
     * @return un string
     */
    public static String formatoFecha(Date fecha){

        return pfecha.format(fecha);
    }
    /**
     * Pasa un date hora a un string
     * @param hora
     * @return un string
     */
    public static String formatoHora(Date hora){
        
        return phora.format(hora);
    }
    
    /**
     * Convierte un string de fecha a un date
     * @param fecha
     * @return un date
     * @throws ParseException 
     */
    public static Date convertirAFecha(String fecha) throws ParseException{

        return pfecha.parse(fecha);
    }
    /**
     * Convierte un string de hora a date
     * @param hora
     * @return
     * @throws ParseException 
     */
    public static Date convertirAHora(String hora) throws ParseException{

        return phora.parse(hora);
    }
    
    /**
     * Valida que la fecha sea una fecha valida en el calendario
     * @param campoFecha
     * @return true o false
     * @throws ParseException 
     */
   public static boolean validarFecha(String campoFecha) throws ParseException {

         try{
            pfecha.setLenient(false);
            pfecha.parse(campoFecha);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }

   /**
    * Valida que la hora sea  valida
    * @param campoHora
    * @return
    * @throws ParseException 
    */
    public static boolean validarHora(String campoHora) throws ParseException {
        
        try{
            phora.setLenient(false);
            phora.parse(campoHora);
            return true; 
        }
        catch(ParseException e){
            return false;
        }
        
    }
         
    
}
