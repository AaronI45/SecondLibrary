package secondlibrary.controller;

import java.net.URL;
import java.util.ResourceBundle;
import services.userService;
iimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
mport javafx.fxml.Initializable;

import javafx.scene.control.Button;
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
    private PasswordField pfPassword;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Button btnCrearCuenta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void clicIniciarSesion(ActionEvent event) {
        userService servicioUsuario = new userService();
        String username = tfUsuario.getText();
        String password = pfPassword.getText();
        
    }

    @FXML
    private void clicCrearCuenta(ActionEvent event) {
    }
    
    
    private boolean existenCamposVaciosInicioSesion(){
        boolean existe = false;
        mensajeAlerta mensajeAlerta = new mensajeAlerta();
        if(tfUsuario.getText().isEmpty()|| pfPassword.getText().isEmpty()){
            existe = true;
            mensajeAlerta.mostrarAlertaInformacionInvalida("Existen campos vacíos");
        }
        return existe;
    }

}
