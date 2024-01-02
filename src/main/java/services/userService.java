package services;

import domain.Usuario;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import java.util.*;


public class userService {
    
    public int registrarUsuario(Usuario nuevoUsuario) throws IOException{
        int respuesta = 0;
        try{
            URL url = new URL("http://127.0.0.1:8081/usuarios/");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            String datos = "{ " +
                    "\"nombreUsuario\":" + " " + "\"" + nuevoUsuario.getNombreUsuario() + "\"" + ", " +
                    "\"Tipo_Usuario_idTipo_Usuario\":" + " " + "\"" + nuevoUsuario.getTipoUsuario() + "\"" + ", " +
                    "\"contrasena\":" + " " + "\"" + nuevoUsuario.getContrasenia() + "\"" + ", " +
                    "\"nombre\":" + " " + "\"" + nuevoUsuario.getNombre() + "\"" + ", " +
                    "\"apellidoPaterno\":" + " " + "\"" + nuevoUsuario.getApellidoPaterno() + "\"" + ", " +
                    "\"apellidoMaterno\":" + " " + "\"" + nuevoUsuario.getApellidoMaterno() + "\"" + ", " +
                    "\"matricula\":" + " " + "\"" + nuevoUsuario.getMatricula() + "\"" + ", " +
                    "\"correo\":" + " " + "\"" + nuevoUsuario.getCorreo() + "\"";
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            respuesta = conexion.getResponseCode();
        } catch(MalformedURLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException();
        }
        return respuesta;
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasenia) throws IOException {
        Usuario usuario = null;
        try {
            URL url = new URL("http://127.0.0.1:8081/usuarios/login/");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            String datos = "{ " +
                    "\"nombreUsuario\":" + " " + "\"" + nombreUsuario + "\"" + ", " +
                    "\"contrasena\":" + " " + "\"" + contrasenia + "\"" + "}";
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();
            if (conexion.getResponseCode() == 200) {
                Reader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                StringBuilder sb = new StringBuilder();
                for (int c; (c = entrada.read()) >= 0; ) {
                    sb.append((char) c);
                }
                String respuestaJson = sb.toString();
                JSONObject respuestaJsonObjeto = new JSONObject(respuestaJson);
                int idUsuario = respuestaJsonObjeto.getInt("idUsuario");
                int estado = respuestaJsonObjeto.getInt("Estado_usuario_idEstado_usuario");
                int tipoUsuario = respuestaJsonObjeto.getInt("Tipo_Usuario_idTipo_Usuario");
                String nombre = respuestaJsonObjeto.getString("nombre");
                String apellidoPaterno = respuestaJsonObjeto.getString("apellidoPaterno");
                String apellidoMaterno = respuestaJsonObjeto.getString("apellidoMaterno");
                String matricula = respuestaJsonObjeto.getString("matricula");
                String correo = respuestaJsonObjeto.getString("correo");
                String token = respuestaJsonObjeto.getString("token");
                usuario = new Usuario(idUsuario, estado,
                        tipoUsuario, nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, matricula, correo, token);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException();
        }
        return usuario;
    }
}
