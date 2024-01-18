package servicios;

import domain.Libro;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import secondlibrary.util.Utilidades;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class ServicioLibro {
    public static Libro obtenerLibroPorIsbn(String isbn) {
        Libro libroEncontrado = null;
        try {
            URL url = new URL("https://api2.isbndb.com/book/" + isbn);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("Authorization", "51338_263bca0ac8ea693171ea0ac17771d185");
            conexion.setRequestMethod("GET");
            if(conexion.getResponseCode() == 200){
                JSONObject respuesta = new JSONObject(Utilidades.obtenerRespuesta(conexion.getInputStream()));
                JSONObject libro = respuesta.getJSONObject("book");
                String titulo = libro.getString("title");
                String autor = libro.getJSONArray("authors").toList().getFirst().toString();
                String editorial = libro.getString("publisher");
                String edicion = libro.getString("edition");
                String imagenUrl = libro.getString("image");

                libroEncontrado = new Libro(titulo, autor, editorial, edicion, imagenUrl, isbn);
            }
        }catch (MalformedURLException ex){
            Logger.getLogger(ServicioLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (IOException | JSONException ex){
            ex.printStackTrace();
        }
        return libroEncontrado;
    }
}
