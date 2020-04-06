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
 * @author XT
 */
public class Registro_Singleton {
    //Atributos
    private static Registro_sismos registro; //para el singleton
    
    private Registro_Singleton(){}
    
    public synchronized static Registro_sismos getRegistro_Singleton() throws ParseException, IOException {
        /*
        Funcion: Crear una unica instancia del objeto Registro_sismos
        Entradas: Ninguna
        Salidas: El objeto registro
        */
        if (registro == null){
            registro = new Registro_sismos();
        }
        return registro;
    }
}
