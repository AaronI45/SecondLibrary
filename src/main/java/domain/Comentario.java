package domain;

public class Comentario {
    private int idComentario;
    private int idComerciante;
    private int idUsuario;
    private String titulo;
    private float calificacion;
    private String descripcion;

    public Comentario() {
    }

    public Comentario(int idComentario, int idComerciante, int idUsuario, String titulo, float calificacion, String descripcion) {
        this.idComentario = idComentario;
        this.idComerciante = idComerciante;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
}
