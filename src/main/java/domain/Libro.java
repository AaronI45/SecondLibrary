package domain;

import java.util.List;

public class Libro {
    private String titulo;

    private String autor;
    private String editorial;
    private String edicion;
    private String imagenUrl;
    private String isbn;

    public Libro(String titulo, String autor, String editorial, String edicion, String imagenUrl, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.edicion = edicion;
        this.imagenUrl = imagenUrl;
        this.isbn = isbn;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public String getIsbn() {
        return isbn;
    }
}
