/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package secondlibrary.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import domain.OfertaIntercambio;
import domain.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import servicios.ServicioOfertaIntercambio;

/**
 * FXML Controller class
 *
 * @author ABF26
 */
public class FXMLPerfilUsuarioController implements Initializable {

    public Label lbNombreUsuario;
    public Label lbNombre;
    public Label lbApellidoPaterno;
    public Label lbApellidoMaterno;
    public Label lbMatricula;
    public Rating calificacion;
    public VBox vBox;

    private Usuario usuarioIniciado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    public void inicializarValores(Usuario usuario){
        this.usuarioIniciado = usuario;
        lbNombreUsuario.setText(usuarioIniciado.getNombreUsuario());
        lbNombre.setText(usuarioIniciado.getNombre());
        lbApellidoPaterno.setText(usuarioIniciado.getApellidoPaterno());
        lbApellidoMaterno.setText(usuarioIniciado.getApellidoMaterno());
        lbMatricula.setText(usuarioIniciado.getMatricula());
        cargarPrestamos();
    }

    public void cargarPrestamos(){
        vBox.getChildren().clear();
        try{
            ArrayList<OfertaIntercambio> ofertaIntercambios = ServicioOfertaIntercambio.obtenerIntercambiosPorId(usuarioIniciado.getIdUsuario());
            if(!ofertaIntercambios.isEmpty()){
                System.out.println("no vacio");
            }
            System.out.println("xd");
            for (int i=0 ; i< ofertaIntercambios.size(); i++){
                System.out.println("Intercambios publicados " + ofertaIntercambios.get(i).getIsbnComerciante());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLObjetoLista.fxml"));

                AnchorPane acp = fxmlLoader.load();

                FXMLObjetoListaController objetoListaController = fxmlLoader.getController();
                objetoListaController.setIntercambio(ofertaIntercambios.get(i), usuarioIniciado.getTokenLogin());

                vBox.getChildren().add(acp);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void clicGestionarUsuarios(ActionEvent actionEvent) {
    }

    public void clicEditarCuenta(ActionEvent actionEvent) {
    }

    public void clicEliminarCuenta(ActionEvent actionEvent) {
    }

    public void clicRealizarPublicacion(ActionEvent actionEvent) {
    }
}
