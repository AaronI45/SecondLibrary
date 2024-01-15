package domain;

public class OfertaIntercambio {
    private int idOfertaIntercambio;
    private int idComeciante;
    private String isbnComerciante;
    private String estadoIntercambio;
    private String estadoLibro;
    private String fechaDeCreacion;

    public OfertaIntercambio() {
    }

    public OfertaIntercambio(int idOfertaIntercambio, int idComeciante, String isbnComerciante, String estadoIntercambio, String estadoLibro, String fechaDeCreacion) {
        this.idOfertaIntercambio = idOfertaIntercambio;
        this.idComeciante = idComeciante;
        this.isbnComerciante = isbnComerciante;
        this.estadoIntercambio = estadoIntercambio;
        this.estadoLibro = estadoLibro;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public int getIdOfertaIntercambio() {
        return idOfertaIntercambio;
    }

    public void setIdOfertaIntercambio(int idOfertaIntercambio) {
        this.idOfertaIntercambio = idOfertaIntercambio;
    }

    public int getIdComeciante() {
        return idComeciante;
    }

    public void setIdComeciante(int idComeciante) {
        this.idComeciante = idComeciante;
    }

    public String getIsbnComerciante() {
        return isbnComerciante;
    }

    public void setIsbnComerciante(String isbnComerciante) {
        this.isbnComerciante = isbnComerciante;
    }

    public String getEstadoIntercambio() {
        return estadoIntercambio;
    }

    public void setEstadoIntercambio(String estadoIntercambio) {
        this.estadoIntercambio = estadoIntercambio;
    }

    public String getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
}
