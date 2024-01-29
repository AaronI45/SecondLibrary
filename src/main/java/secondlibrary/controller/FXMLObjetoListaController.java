package secondlibrary.controller;

import domain.Libro;
import domain.OfertaIntercambio;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import servicios.ServicioLibro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLObjetoListaController implements Initializable {
    public Label lbTitulo;
    public Label lbSubtitulo;
    public Label lbCuerpo;
    public Label lbEstado;
    public ImageView iv;

    private String token;

    private int idIntercambio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setIntercambio(OfertaIntercambio ofertaIntercambio, String token) {
        this.idIntercambio = ofertaIntercambio.getIdOfertaIntercambio();
        this.token = token;
        Libro libro = ServicioLibro.obtenerLibroPorIsbn(ofertaIntercambio.getIsbnComerciante());
        lbTitulo.setText(libro.getTitulo());
        lbSubtitulo.setText(libro.getAutor());
        lbCuerpo.setText(ofertaIntercambio.getFechaDeCreacion());
        lbEstado.setText(ofertaIntercambio.getEstadoIntercambio());
        Image img = new Image(libro.getImagenUrl());
        iv.setImage(img);
    }

    public void clic(MouseEvent mouseEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLListaIntercambiosDisponibles.fxml"));
            Parent vista = fxmlLoader.load();


            FXMLListaIntercambiosDisponiblesController controller = fxmlLoader.getController();
            controller.setValores(idIntercambio, token);

            Stage nuevaVentana = new Stage();
            Scene scene = new Scene(vista);
            nuevaVentana.setTitle("Lista de intercambios disponibles");
            nuevaVentana.setScene(scene);
            nuevaVentana.initModality(Modality.APPLICATION_MODAL);
            nuevaVentana.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
