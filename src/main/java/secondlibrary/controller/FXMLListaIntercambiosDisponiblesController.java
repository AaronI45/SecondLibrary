package secondlibrary.controller;

import domain.Intercambio;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import servicios.ServicioIntercambio;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLListaIntercambiosDisponiblesController implements Initializable {
    public VBox vbox;
    private String token;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setValores(int idOferta, String token) {
        this.token = token;
        List<Intercambio> intercambios = ServicioIntercambio.obtenerIntercambiosPorIdOferta(idOferta);
        try {
            for (int i = 0; i < intercambios.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLIntercambioDisponible.fxml"));
                AnchorPane acp = fxmlLoader.load();

                FXMLIntercambioDisponibleController intercambioDisponibleController = fxmlLoader.getController();
                intercambioDisponibleController.setValores(intercambios.get(i), idOferta, token);

                vbox.getChildren().add(acp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

