package servicios;

import domain.Intercambio;
import org.json.JSONArray;
import org.json.JSONException;
import secondlibrary.util.Utilidades;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ServicioIntercambio {
    public static int crearIntercambio(int idOferta, String isbnUsuario, String token) throws IOException{
        int respuesta = 0;
        try{
            URL url = new URL("http://127.0.0.1:8081/api/v1/intercambios/");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestProperty("x-token", token);
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestMethod("POST");
            String datos = "{" +
                    "\"Oferta_Intercambio_idOferta_Intercambio\" :" + " " + "\"" + idOferta + "\"" + ", " +
                    "\"isbnUsuario\" :" + " " + "\"" + isbnUsuario + "\"" + "}";
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            respuesta = conexion.getResponseCode();
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            throw new IOException();
        }
        return respuesta;
    }

    public static List<Intercambio> obtenerIntercambiosPorIdOferta(int idOferta) {
        ArrayList<Intercambio> intercambios = new ArrayList<>();
        try{
            URL url = new URL("http://localhost:8081/api/v1/intercambios/oferta/"+ idOferta);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            if(conexion.getResponseCode() == 200){
                String respuesta = Utilidades.obtenerRespuesta(conexion.getInputStream());
                JSONArray arregloIntercambios = new JSONArray(respuesta);
                for (int i = 0; i< arregloIntercambios.length(); i++){
                    int idIntercambio = arregloIntercambios.getJSONObject(i).getInt("idIntercambio");
                    int usuario_idUsuario = arregloIntercambios.getJSONObject(i).getInt("Usuario_idUsuario");
                    String isbnUsuario = arregloIntercambios.getJSONObject(i).getString("isbnUsuario");
                    String fechaDeFinalizacion = arregloIntercambios.getJSONObject(i).getString("fechaDeFinalizacion");

                    Intercambio intercambio = new Intercambio();
                    intercambio.setIdIntercambio(idIntercambio);
                    intercambio.setIdUsuario(usuario_idUsuario);
                    intercambio.setIsbnUsuario(isbnUsuario);
                    intercambio.setFechaFinalizacion(fechaDeFinalizacion);
                    intercambios.add(intercambio);
                }
            }
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException |JSONException ex){
            ex.printStackTrace();
        }
        return intercambios;
    }
}
