package proyecto1_sistema_sismico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NataliaVR
 */
public class FormatosUtilitaria {
    
    private static SimpleDateFormat pfecha = new SimpleDateFormat("dd/mm/yyyy");
    private static SimpleDateFormat phora = new SimpleDateFormat("HH:mm:ss");;
    
    
    public static String formatoFecha(Date fecha){
        /*
        Funcion: Pasar un date fecha a un string
        Entradas: un date
        Salidas: un string
        */
        return pfecha.format(fecha);
    }
    
    public static String formatoHora(Date hora){
        /*
        Funcion: Pasar un date hora a un string
        Entradas: un date
        Salidas: un string
        */
        return phora.format(hora);
    }
    
    public static Date convertirAFecha(String fecha) throws ParseException{
        /*
        Funcion: Convertir un string de fecha a date
        Entradas: un string
        Salidas: un date
        */
        return pfecha.parse(fecha);
    }
    
    public static Date convertirAHora(String hora) throws ParseException{
        /*
        Funcion: Convertir un string de hora a date
        Entradas: un string
        Salidas: un date
        */
        return phora.parse(hora);
    }
    
    
   public static boolean validarFecha(String campoFecha) throws ParseException {
        /*
        Funciones: Validar que la fecha sea una fecha valida en el calendario
        Entradas: Ninguna
        Salidas: Ninguna
        */
         try{
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha.setLenient(false);
            fecha.parse(campoFecha);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }

   
    public static boolean validarHora(String campoHora) throws ParseException {
        /*
        Funciones: Validar que la hora sea  valida
        Entradas: Ninguna
        Salidas: Ninguna
        */  
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
