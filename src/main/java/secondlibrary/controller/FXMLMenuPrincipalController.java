package secondlibrary.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.OfertaIntercambio;
import domain.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import secondlibrary.util.Utilidades;
import servicios.ServicioOfertaIntercambio;


public class FXMLMenuPrincipalController implements Initializable {


    public TextField tfBusqueda;
    public GridPane gpIntercambios;
    public Label lbNombreUsuario;

    private Usuario usuarioIniciado;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void inicializarValores(){
        gpIntercambios.getChildren().clear();
        try{
            List<OfertaIntercambio> ofertaIntercambio = ServicioOfertaIntercambio.obtenerIntercambios();
            int columna = 0;
            int fila = 1;
            for (int i=0 ; i< ofertaIntercambio.size(); i++){
                System.out.println("intercambio " + ofertaIntercambio.get(i).getIsbnComerciante());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLOfertaIntercambio.fxml"));
                AnchorPane acp = fxmlLoader.load();

                FXMLOfertaIntercambioController ofertaController = fxmlLoader.getController();
                ofertaController.setValores(ofertaIntercambio.get(i), usuarioIniciado.getTokenLogin());

                if(columna == 4){
                    columna = 0;
                    fila++;
                }

                gpIntercambios.add(acp, columna++, fila);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inicializarUsuario(Usuario usuarioLogin){
        this.usuarioIniciado = usuarioLogin;

        lbNombreUsuario.setText(usuarioIniciado.getNombre());
    }
    public void clicBuscar(MouseEvent mouseEvent) {
        //TODO
    }

    public void verPerfil(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLPerfilUsuario.fxml"));
            Parent vista = fxmlLoader.load();

            FXMLPerfilUsuarioController controller = fxmlLoader.getController();
            controller.inicializarValores(usuarioIniciado);

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Perfil de usuario");
            nuevaVentana.setScene(new Scene(vista));
            nuevaVentana.initModality(Modality.APPLICATION_MODAL);
            nuevaVentana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarSesion(ActionEvent actionEvent) {
        Utilidades.cambiarVentana("Inicio de sesión", (Node) actionEvent.getSource(),"/secondlibrary/view/FXMLLogin.fxml");
    }
}
