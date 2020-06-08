/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_sistema_sismico;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Natalia
 */
public class Registro_Singleton {

    private static Registro_sismos registro; 
    
    private Registro_Singleton(){}
    /**
     * Crear una unica instancia del objeto Registro_sismos
     * @return El objeto registro
     * @throws ParseException
     * @throws IOException 
     */
    public synchronized static Registro_sismos getRegistro_Singleton() throws ParseException, IOException {

        if (registro == null){
            registro = new Registro_sismos();
        }
        return registro;
    }
}
