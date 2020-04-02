
package proyecto1_sistema_sismico;

/**
 *
 * @author Allison
 */
public enum TipoOrigen {
    SUBDUCCION_PLACA("Subducción de placa"), CHOQUE_PLACAS("Choque de placas"), TECTONICO_SUBDUCCION("Téctonico por subducción"), 
    DEFORMACION_INTERNA("Deformación Interna"),TECTONICO_POR_FALLA_LOCAL("Téctonico por falla local");
    
    public String tipo;

    private TipoOrigen(String ptipo){
        tipo = ptipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString(){
    //para llenar combo box
        return tipo;
    }
    
}
