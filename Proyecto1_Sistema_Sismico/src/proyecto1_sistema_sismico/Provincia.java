package proyecto1_sistema_sismico;

/**
 *
 * @author Allison
 */
public enum Provincia {
    
    SAN_JOSE("San José"), ALAJUELA("Alajuela"), CARTAGO("Cartago"), HEREDIA("Heredia"), PUNTARENAS("Puntarenas"), LIMON("Limón"),GUANACASTE("Guanacaste"), SIN_ASIGNAR("Sin asignar");
    
    public String nombre ;

    private Provincia (String pnombre){
        nombre = pnombre;
    }

    public String getName() {
        return nombre;
    }

    @Override
    public String toString(){
    //para llenar combo box
        return nombre;
    }
}
    
    
    
