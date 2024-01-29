package secondlibrary.controller;

import domain.Intercambio;
import domain.Libro;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import secondlibrary.util.Utilidades;
import servicios.ServicioIntercambio;
import servicios.ServicioLibro;
import servicios.ServicioOfertaIntercambio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLIntercambioDisponibleController implements Initializable {

    public Label lbTitulo;
    public Label lbSubtitulo;
    public Label lbCuerpo;
    public Label lbEstado;
    private Intercambio intercambio;
    private int idOferta;
    private String token;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setValores(Intercambio intercambio, int idOferta, String token) {
        this.intercambio = intercambio;
        this.idOferta = idOferta;
        this.token = token;

        Libro libro = ServicioLibro.obtenerLibroPorIsbn(intercambio.getIsbnUsuario());
        lbTitulo.setText(libro.getTitulo());
        lbSubtitulo.setText(libro.getAutor());
        Image img = new Image(libro.getImagenUrl());
        lbCuerpo.setText(intercambio.getFechaFinalizacion());
    }


    public void clic(MouseEvent mouseEvent) {

        boolean confirmacion = Utilidades.mostrarDialogoConfirmacion("Confirmación", "¿Desea aceptar el intercambio?");
        if (confirmacion) {
            try {
                ServicioOfertaIntercambio.editarEstadoPorId(idOferta, token);
                Utilidades.mostrarAlertaSimple("Información", "Intercambio aceptado", Alert.AlertType.INFORMATION);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
