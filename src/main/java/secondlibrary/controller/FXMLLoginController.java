package secondlibrary.controller;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Usuario;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import secondlibrary.util.Utilidades;
import servicios.ServicioUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author ABF26
 */
public class FXMLLoginController implements Initializable {


    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfContrasena;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void clicIniciarSesion(ActionEvent event) {
        ServicioUsuario servicioUsuario = new ServicioUsuario();
        String nombreUsuario = tfUsuario.getText();
        String contrasena = pfContrasena.getText();
        if (!existenCamposVaciosInicioSesion()) {
            try {
                Usuario usuarioLogin = servicioUsuario.iniciarSesion(nombreUsuario, contrasena);
                if (usuarioLogin != null) {
                    Utilidades.cambiarVentana("Inicio", (Node) event.getSource(), "/secondlibrary/view/FXMLMenuPrincipal.fxml");
                } else {
                    Utilidades.mostrarAlertaSimple("Usuario o contraseña incorrectos", "Las credenciales ingresadas no son correctas", Alert.AlertType.INFORMATION);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void clicCrearCuenta(ActionEvent actionEvent) {
        Utilidades.cambiarVentana("Registro de usuario",(Node)actionEvent.getSource(), "/secondlibrary/view/FXMLRegistrarUsuario.fxml");
    }
    
    private boolean existenCamposVaciosInicioSesion(){
        boolean existe = false;
        mensajeAlerta mensajeAlerta = new mensajeAlerta();
        if(tfUsuario.getText().isEmpty()|| pfContrasena.getText().isEmpty()){
            existe = true;
            mensajeAlerta.mostrarAlertaInformacionInvalida("Existen campos vacíos");
        }
        return existe;
    }

}
