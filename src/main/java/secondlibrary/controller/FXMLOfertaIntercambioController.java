package secondlibrary.controller;

import domain.Libro;
import domain.OfertaIntercambio;
import domain.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import servicios.ServicioLibro;
import servicios.ServicioUsuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLOfertaIntercambioController implements Initializable {
    public ImageView ivLibro;
    public Label lbTituloLibro;
    public Label lbAutor;
    public Label lbComerciante;

    private Libro libroIntercambio;
    private Usuario comerciante;
    private OfertaIntercambio ofertaIntercambio;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setValores(OfertaIntercambio oferta){
        this.ofertaIntercambio = oferta;
        try{
            libroIntercambio = ServicioLibro.obtenerLibroPorIsbn(oferta.getIsbnComerciante());
            Image img = new Image(libroIntercambio.getImagenUrl());
            ivLibro.setImage(img);
            lbTituloLibro.setText(libroIntercambio.getTitulo());
            lbAutor.setText(libroIntercambio.getAutor());
            comerciante = ServicioUsuario.getUsuarioPorId(ofertaIntercambio.getIdComeciante());
            System.out.println("Comerciante" +comerciante.getNombre());
            lbComerciante.setText(comerciante.getNombreUsuario());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void clicOferta(MouseEvent mouseEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLOfertaIntercambioDetalle.fxml"));

        FXMLOrganizarIntercambioController controller = fxmlLoader.getController();
    }
}
