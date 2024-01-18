package secondlibrary.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.OfertaIntercambio;
import domain.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import servicios.ServicioOfertaIntercambio;


public class FXMLMenuPrincipalController implements Initializable {


    public TextField tfBusqueda;
    public GridPane gpIntercambios;
    public Label lbNombreUsuario;

    private Usuario usuarioIniciado;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarValores();
    }

    public void inicializarValores(){
        gpIntercambios.getChildren().clear();
        try{
            List<OfertaIntercambio> ofertaIntercambio = ServicioOfertaIntercambio.obtenerIntercambios();
            int columna = 0;
            int fila = 1;
            for (int i=0 ; i< ofertaIntercambio.size(); i++){
                System.out.println("intercambio" + ofertaIntercambio.get(i).getIsbnComerciante());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/secondlibrary/view/FXMLOfertaIntercambio.fxml"));
                AnchorPane acp = fxmlLoader.load();

                FXMLOfertaIntercambioController ofertaController = fxmlLoader.getController();
                ofertaController.setValores(ofertaIntercambio.get(i));

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
}
