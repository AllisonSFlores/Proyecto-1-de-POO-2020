package proyecto1_sistema_sismico;
import java.util.*;
/**
 *
 * @author Allison
 */
public class Sismo {
    //Atributos
    private Date fecha;
    private Calendar hora;
    private float profundidad;
    private TipoOrigen origen;
    private String detalle;
    private float magnitud;
    private float latitud;
    private float longitud;
    private Provincia provincia;
    private String descripcion_detallada;
    
    //Constructores
    public Sismo(){}
    public Sismo(Date pfecha,Calendar phora,float pprofundidad,TipoOrigen porigen,String pdetalle, float pmagnitud, float platitud, float plongitud,Provincia pprovincia,String pdescripcion){
        fecha=pfecha;
        hora=phora;
        profundidad=pprofundidad;
        origen=porigen;
        detalle=pdetalle;
        magnitud=pmagnitud;
        latitud=platitud;
        longitud=plongitud;
        provincia=pprovincia;
        descripcion_detallada=pdescripcion;
    }
    
    /*  METODO A COMPLETAR
    public String mostrar_sismo(latitud,longitud){
    }*/
    
    //SETTERS
    public void setFecha(Date pfecha) {
        fecha = pfecha;
    }

    public void setHora(Calendar phora) {
        hora = phora;
    }

    public void setProfundidad(float pprofundidad) {
        profundidad = pprofundidad;
    }

    public void setOrigen(TipoOrigen porigen) {
        origen = porigen;
    }

    public void setDetalle(String pdetalle) {
        detalle = pdetalle;
    }

    public void setMagnitud(float pmagnitud) {
        magnitud = pmagnitud;
    }

    public void setLatitud(float platitud) {
        latitud = platitud;
    }

    public void setLongitud(float plongitud) {
        longitud = plongitud;
    }

    public void setProvincia(Provincia pprovincia) {
        provincia = pprovincia;
    }

    public void setDescripcion_detallada(String pdescripcion_detallada) {
        descripcion_detallada = pdescripcion_detallada;
    }
    //GETTERS
    public Date getFecha() {
        return fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public TipoOrigen getOrigen() {
        return origen;
    }

    public String getDetalle() {
        return detalle;
    }

    public float getMagnitud() {
        return magnitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public String getDescripcion_detallada() {
        return descripcion_detallada;
    }
}
