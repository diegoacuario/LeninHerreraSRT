package vista;

/**
 *
 * @author Ing. Diego
 */
public final class Proces {

    private String nombreDeProceso;
    private int duraEnSegundos;
    private int tLLega;

    public Proces(String nombre, int tiempo,int tLLe ) {
        setStrNombre(nombre);
        setTiempo(tiempo);
        settLLega(tLLe);
    }

    public int obtieneTiempoLLega() {
        return tLLega;
    }

    public void settLLega(int tLLega) {
        this.tLLega = tLLega;
    }

    public String getStrNombre() {
        return nombreDeProceso;
    }

    public void setStrNombre(String strNombre) {
        this.nombreDeProceso = strNombre;
    }

    public int obtieneDuracion() {
        return duraEnSegundos;
    }

    public void setTiempo(int tiempo) {
        this.duraEnSegundos = tiempo;
    }

}
