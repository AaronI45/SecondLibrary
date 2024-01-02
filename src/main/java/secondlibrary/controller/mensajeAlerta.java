package secondlibrary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class mensajeAlerta {
    
    @FXML
    public  void mostrarAlertaInformacionInvalida(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información invalida");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @FXML
    public  void mostrarAlertaGuardado(String mensaje){    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información guardada");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
     
    @FXML
    public  void mostrarAlertaError(String mensaje){    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @FXML
    public  void mostrarAlertaEnvioCorreo(){    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Código enviado");
        alert.setContentText("El código ha sido enviado a tu correo, revisa por favor");
        alert.showAndWait();
    }
}
