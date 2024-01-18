package secondlibrary.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;

public class Utilidades {

    public static void mostrarAlertaSimple(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alertaSimple = new Alert(tipo);
        alertaSimple.setTitle(titulo);
        alertaSimple.setContentText(mensaje);
        alertaSimple.setHeaderText(null);
        alertaSimple.showAndWait();
    }

    public static boolean mostrarDialogoConfirmacion(String titulo, String mensaje){
        Alert alertaConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        alertaConfirmacion.setTitle(titulo);
        alertaConfirmacion.setContentText(mensaje);
        alertaConfirmacion.setHeaderText(null);
        Optional<ButtonType> respuesta = alertaConfirmacion.showAndWait();
        return (respuesta.get() == ButtonType.OK);
    }

    public static void cambiarVentana(String titulo, Node origen, String ruta){
        Stage stagePrincipal = (Stage) origen.getScene().getWindow();
        stagePrincipal.setScene(Utilidades.inicializarEscena(ruta));
        stagePrincipal.setTitle(titulo);
        stagePrincipal.show();
    }

    public static Scene inicializarEscena(String ruta) {
        Scene escena = null;
        try
        {
            Parent vista = FXMLLoader.load(Utilidades.class.getResource(ruta));
            escena = new Scene(vista);
        } catch (IOException ex)
        {
            System.err.println("ERROR: " + ex.getMessage());
        }
        return escena;
    }

    public static String obtenerRespuesta (InputStream conexion) throws IOException{
        Reader entrada = new BufferedReader(new InputStreamReader(conexion));
        StringBuilder stringBuilder = new StringBuilder();
        for (int c; (c = entrada.read()) >= 0;){
            stringBuilder.append((char)c);
        }
        conexion.close();
        return stringBuilder.toString();
    }
}
