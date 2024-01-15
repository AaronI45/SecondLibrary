package domain;

public class Intercambio {
    private int idIntercambio;
    private int idComerciante;
    private int idUsuario;
    private String isbnUsuario;
    private String fechaFinalizacion;


    public Intercambio() {
    }
    public Intercambio(int idIntercambio, int idComerciante, int idUsuario, String isbnUsuario, String fechaFinalizacion) {
        this.idIntercambio = idIntercambio;
        this.idComerciante = idComerciante;
        this.idUsuario = idUsuario;
        this.isbnUsuario = isbnUsuario;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getIdIntercambio() {
        return idIntercambio;
    }

    public void setIdIntercambio(int idIntercambio) {
        this.idIntercambio = idIntercambio;
    }

    public int getIdComerciante() {
        return idComerciante;
    }

    public void setIdComerciante(int idComerciante) {
        this.idComerciante = idComerciante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIsbnUsuario() {
        return isbnUsuario;
    }

    public void setIsbnUsuario(String isbnUsuario) {
        this.isbnUsuario = isbnUsuario;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
