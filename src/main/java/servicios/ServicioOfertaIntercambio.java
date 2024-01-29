package servicios;

import domain.OfertaIntercambio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import secondlibrary.util.Utilidades;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioOfertaIntercambio {
    public static ArrayList<OfertaIntercambio> obtenerIntercambios () throws IOException {
        ArrayList<OfertaIntercambio> ofertaIntercambios = new ArrayList<>();
        try {
            URL url = new URL("http://127.0.0.1:8081/api/v1/ofertaIntercambios/");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            if (conexion.getResponseCode() == 200){
                JSONArray arregloOInter = new JSONArray(Utilidades.obtenerRespuesta(conexion.getInputStream()));
                for (int i = 0; i< arregloOInter.length(); i++){
                    JSONObject oferta = arregloOInter.getJSONObject(i);
                    int idOferta = oferta.getInt("idOferta_Intercambio");
                    int idComerciante = oferta.getInt("Comerciante_idComerciante");
                    String isbnComerciante = oferta.getString("isbnComerciante");
                    String estadoIntercambio = oferta.getString("estadoIntercambio");
                    String estadoLibro = oferta.getString("estadoLibro");
                    String fechaCreacion = oferta.getString("fechaDeCreacion");

                    OfertaIntercambio oInterAux = new OfertaIntercambio();
                    oInterAux.setIdOfertaIntercambio(idOferta);
                    oInterAux.setIdComeciante(idComerciante);
                    oInterAux.setIsbnComerciante(isbnComerciante);
                    oInterAux.setEstadoIntercambio(estadoIntercambio);
                    oInterAux.setEstadoLibro(estadoLibro);
                    oInterAux.setFechaDeCreacion(fechaCreacion);
                    ofertaIntercambios.add(oInterAux);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServicioOfertaIntercambio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(ServicioOfertaIntercambio.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException();
        }
        return ofertaIntercambios;
    }

    public static ArrayList<OfertaIntercambio> obtenerIntercambiosPorId(int idUsuario) throws IOException{
        ArrayList<OfertaIntercambio> ofertaIntercambios = new ArrayList<>();
        try {
            URL url = new URL("http://127.0.0.1:8081/api/v1/ofertaIntercambios/comerciante/" + idUsuario);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            System.out.println(conexion.getResponseCode());
            if (conexion.getResponseCode() == 200){
                JSONArray arregloOInter = new JSONArray(Utilidades.obtenerRespuesta(conexion.getInputStream()));
                for (int i = 0; i< arregloOInter.length(); i++){
                    JSONObject oferta = arregloOInter.getJSONObject(i);
                    int idOferta = oferta.getInt("idOferta_Intercambio");
                    int idComerciante = oferta.getInt("Comerciante_idComerciante");
                    String isbnComerciante = oferta.getString("isbnComerciante");
                    String estadoIntercambio = oferta.getString("estadoIntercambio");
                    String estadoLibro = oferta.getString("estadoLibro");
                    String fechaCreacion = oferta.getString("fechaDeCreacion");

                    OfertaIntercambio oInterAux = new OfertaIntercambio();
                    oInterAux.setIdOfertaIntercambio(idOferta);
                    oInterAux.setIdComeciante(idComerciante);
                    oInterAux.setIsbnComerciante(isbnComerciante);
                    oInterAux.setEstadoIntercambio(estadoIntercambio);
                    oInterAux.setEstadoLibro(estadoLibro);
                    oInterAux.setFechaDeCreacion(fechaCreacion);
                    ofertaIntercambios.add(oInterAux);
                }
            }
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException | JSONException ex){
            throw new IOException();
        }
        return ofertaIntercambios;
    }

    public static int editarEstadoPorId(int idOferta, String token) throws IOException {
        int respuesta = 0;
        try {
            URL url = new URL("http://localhost:8081/api/v1/ofertaIntercambios/" + idOferta);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("PATCH");
            conexion.setRequestProperty("x-token", token);
            conexion.setRequestProperty("Content-Type", "application/json");
            String datos = "{" +
                    "\"estado\" :" + " " + "\" Finalizado \"" + "}";
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            respuesta = conexion.getResponseCode();
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException | JSONException ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
}
