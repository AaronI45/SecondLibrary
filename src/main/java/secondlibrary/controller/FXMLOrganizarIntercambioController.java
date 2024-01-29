/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package secondlibrary.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domain.Libro;
import domain.OfertaIntercambio;
import domain.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import secondlibrary.util.Utilidades;
import servicios.ServicioIntercambio;
import servicios.ServicioUsuario;

/**
 * FXML Controller class
 *
 * @author ABF26
 */
public class FXMLOrganizarIntercambioController implements Initializable {

    public ImageView ivLibro;
    public Label lbTituloLibro;
    public Label lbAutores;
    public Label lbEdicion;
    public Label lbNombreComerciante;
    public Label lbMatricula;
    public Rating calificacion;
    public TextField tfIsbn;

    private Libro libroOfertado;
    private Usuario comerciante;
    private int idOferta;
    private String token;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void inicializarValores(Usuario comerciante, Libro libroOfertado, int idOferta, String token) {
        this.comerciante = comerciante;
        this.libroOfertado = libroOfertado;
        this.idOferta = idOferta;
        this.token = token;

        Image img = new Image(libroOfertado.getImagenUrl());
        ivLibro.setImage(img);
        lbTituloLibro.setText(libroOfertado.getTitulo());
        lbAutores.setText(libroOfertado.getAutor());
        lbEdicion.setText(libroOfertado.getEdicion());

        lbNombreComerciante.setText(comerciante.getNombreUsuario());
        lbMatricula.setText(comerciante.getMatricula());

        try {
            float calificacionComerciante = ServicioUsuario.getCalificacionPorId(comerciante.getIdUsuario());
            calificacion.setRating(calificacionComerciante);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void clicVolver(ActionEvent actionEvent) {
        cerrarVentana();
    }

    private void cerrarVentana(){
        Stage ventanaActual = (Stage) tfIsbn.getScene().getWindow();
        ventanaActual.close();
    }

    public void clicOrganizarIntercambio(ActionEvent actionEvent) {
        if (!tfIsbn.getText().isEmpty()) {
            try {
                ServicioIntercambio.crearIntercambio(idOferta, tfIsbn.getText(), token);
                Utilidades.mostrarAlertaSimple("Intercambio organizado",
                        "El intercambio ha sido organizado exitosamente",
                        Alert.AlertType.INFORMATION);
                cerrarVentana();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Utilidades.mostrarAlertaSimple("Por favor ingresa un valor en el ISBN",
                    "Por favor ingrese su ISBN de libro que desea intercambiar",
                    Alert.AlertType.ERROR);
        }
    }
}
