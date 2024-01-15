package servicios;

import domain.Usuario;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;


public class ServicioUsuario {
    
    public int registrarUsuario(Usuario nuevoUsuario) throws IOException{
        int respuesta = 0;
        try{
            URL url = new URL("http://127.0.0.1:8081/api/v1/usuarios/");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            String datos = "{ " +
                    "\"nombreUsuario\":" + " " + "\"" + nuevoUsuario.getNombreUsuario() + "\"" + ", " +
                    "\"Tipo_Usuario_idTipo_Usuario\":" + " " + "\"" + nuevoUsuario.getIdUsuario() + "\"" + ", " +
                    "\"contrasena\":" + " " + "\"" + nuevoUsuario.getContrasena() + "\"" + ", " +
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
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException();
        }
        return respuesta;
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) throws IOException {
        Usuario usuario = null;
        try {
            URL url = new URL("http://127.0.0.1:8081/api/v1/usuarios/login");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            String datos = "{ " +
                    "\"nombreUsuario\":" + " " + "\"" + nombreUsuario + "\"" + ", " +
                    "\"contrasena\":" + " " + "\"" + contrasena + "\"" +
                    "}";
            System.out.println(datos);
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes("UTF-8"));
            output.flush();
            output.close();;
            if (conexion.getResponseCode() == 200) {
                JSONObject respuestaJsonObjeto = getJsonObject(conexion);
                int idUsuario = respuestaJsonObjeto.getInt("idUsuario");
                int estadoUsuario = respuestaJsonObjeto.getInt("Estado_usuario_idEstado_usuario");
                int tipoUsuario = respuestaJsonObjeto.getInt("Tipo_Usuario_idTipo_Usuario");
                String nombreUsuarioLogin = respuestaJsonObjeto.getString("nombreUsuario");
                String nombre = respuestaJsonObjeto.getString("nombre");
                String apellidoPaterno = respuestaJsonObjeto.getString("apellidoPaterno");
                String apellidoMaterno = respuestaJsonObjeto.getString("apellidoMaterno");
                String matricula = respuestaJsonObjeto.getString("matricula");
                String correo = respuestaJsonObjeto.getString("correo");
                String token = conexion.getHeaderField("x-token");

                usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                usuario.setIdEstadoUsuario(estadoUsuario);
                usuario.setIdRol(tipoUsuario);
                usuario.setNombreUsuario(nombreUsuarioLogin);
                usuario.setNombre(nombre);
                usuario.setApellidoPaterno(apellidoPaterno);
                usuario.setApellidoMaterno(apellidoMaterno);
                usuario.setMatricula(matricula);
                usuario.setCorreo(correo);
                usuario.setTokenLogin(token);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException();
        }
        return usuario;
    }

    private static JSONObject getJsonObject(HttpURLConnection conexion) throws IOException {
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
        return respuestaJsonObjeto;
    }
}
