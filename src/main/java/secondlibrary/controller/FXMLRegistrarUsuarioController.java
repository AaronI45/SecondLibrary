package secondlibrary.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import secondlibrary.util.Utilidades;

public class FXMLRegistrarUsuarioController {
    public void clicRegistrar(ActionEvent actionEvent) {
    }

    public void clicCuentaExistente(ActionEvent actionEvent) {
        Utilidades.cambiarVentana("Inicio de sesión", (Node) actionEvent.getSource(),"/secondlibrary/view/FXMLLogin.fxml");
    }
}
