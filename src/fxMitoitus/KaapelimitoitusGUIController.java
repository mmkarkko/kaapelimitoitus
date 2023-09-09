package fxMitoitus;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.ohj2.Mjonot;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mitoitus.Kaapelimitoitus;
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

    
    @FXML void handleLaske() {
       laske();
    }

    
    @FXML void handleMateriaali() {
        //
    }

    @FXML void handleSulake() {
        //
    }

    @FXML void handleKorjausKerroin() {
        //
    }
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
    
    // ------------------------------------------------------------------
    
    private String tulos;
    private String asennustapa;
    private double korjausKerroin;
    private int sulake;
    private int rivi;
    private int sarake;
    private String[][] taulukko;   
    
    
    private void laske() {
        
        String teksti1;
        String teksti2;

        
        asennustapa = valintaAsennusTapa.getSelectedText();
        teksti1 = valintaKorjausKerroin.getSelectedText();
        teksti2 = valintaSulake.getSelectedText();
        
        
        sulake = Mjonot.erotaInt(teksti2, 0);
        korjausKerroin = Mjonot.erotaDouble(teksti1, 0);
        
        rivi = Kaapelimitoitus.haeRivi(sulake);
        sarake = Kaapelimitoitus.haeSarake(korjausKerroin);
        taulukko = Kaapelimitoitus.haeTaulukko(asennustapa);
        
        tulos = Kaapelimitoitus.haeArvo(taulukko, rivi, sarake);
        laitaTulos(textTulos, tulos);
    
    }
    
    
    /**
     * Asettaa tekstikenttään tuloksen
     * @param tekstikentta
     * @param arvo
     */
    private void laitaTulos(Label tekstikentta, String arvo) {
        tekstikentta.setText(arvo);
    }
      
}