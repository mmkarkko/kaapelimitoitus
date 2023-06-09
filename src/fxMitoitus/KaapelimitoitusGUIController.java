package fxMitoitus;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.fxml.Initializable;

/**
 * @author Miia Arkko
 * @version 8.3.2023
 *
 */
public class KaapelimitoitusGUIController implements Initializable {

    @FXML private Label textSelite;
    @FXML private Label textTulos;
    
    @FXML private ComboBoxChooser<?> valintaAsennusTapa;
    @FXML private ComboBoxChooser<?> valintaKorjausKerroin;
    @FXML private ComboBoxChooser<?> valintaMateriaali;
    @FXML private ComboBoxChooser<?> valintaSulake;

    
    @FXML void handleLaske(ActionEvent event) {
       laske();
    }

    
    @FXML void handleMateriaali(KeyEvent event) {
        //
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
    
    // ------------------------------------------------------------------
    
    private int tulos;
    
    private void laske() {
    //    
    
    }
      
}