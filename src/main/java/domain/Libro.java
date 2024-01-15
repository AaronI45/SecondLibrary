package domain;

import java.util.List;

public class Libro {
    private String titulo;

    private List<String> autores;
    private String editorial;
    private String edicion;
    private String imagenUrl;
    private String isbn;

    public Libro(String titulo, List<String> autores, String editorial, String edicion, String imagenUrl, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
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

    public List<String> getAutores() {
        return autores;
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
