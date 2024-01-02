package services;

import domain.user;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.System.Logger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class userService {
    
    public int registrarUsuario(user nuevoUsuario) throws IOException{
        int respuesta = 0;
        try{
            URL url = new URL("http://127.0.0.1:3306/user");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            String datos = "{" + 
                            "\"nombre\":"+ " " + "\"" + user.getNombre() + "\"" + ", " +
                            "\"correoElectronico\":"+ " " + "\"" + user.getCorreo() + "\"" + ", " +
                            "\"contrasenia\":"+ " " + "\"" + user.getContrasenia()+ "\"" + 
                            "}"; //Cómo es toda la consulta? xd
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            respuesta = conexion.getResponseCode();
        } catch(MalformedURLException ex){
            Logger.getLogger(ServicioAdministrador.class.getName()).log(.SEVERE, null, ex);
        } catch(IOException ex){
            throw new IOException();
        }
        return respuesta;
    }
    
    public int cerrarSesionUsuario(String correo) throws IOException{
        int respuesta = 0;
         try{
            URL url = new URL("http://127.0.0.1:9090/user/login/" + correo);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("PUT");
            respuesta = conexion.getResponseCode(); 
        }catch (MalformedURLException ex) {
            Logger.getLogger(ServicioAdministrador.class.getName()).log(.SEVERE, null, ex);
        } catch (IOException ex) {
            throw new IOException();
        }
        return respuesta;
    }
    
    public int modificarConsumidor(user usuario, int idUsuario) throws IOException{
        int respuesta = 0;
        try{
            URL url = new URL("http://127.0.0.1:9090/user/idUser/" + idUsuario);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("PUT");
            String datos = "{" + 
                            "\"nombre\":"+ " " + "\"" + usuario.getNombre() + "\"" + ", " +
                            "\"correoElectronico\":"+ " " + "\"" + usuario.getCorreo() + "\"" + ", " +
                            "\"contrasenia\":"+ " " + "\"" + usuario.getContrasenia() + "\"" + ", " +
                            "\"token\":"+ " " + "\"" + usuario.getToken()+ "\"" + 
                            "}";
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            respuesta = conexion.getResponseCode(); 
        }catch (MalformedURLException ex) {
            Logger.getLogger(ServicioAdministrador.class.getName()).log(.SEVERE, null, ex);
        } catch (IOException ex) {
            throw new IOException();
        }
        return respuesta;
}
