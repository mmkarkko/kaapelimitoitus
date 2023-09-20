package fxMitoitus;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author mmkarkko
 * @version 20.9.2023
 *
 */
public class TietojaGUIController implements ModalControllerInterface<String>  {
    
    @FXML private Label labelNimi;
    
        @FXML void handleSulje() {
            ModalController.closeStage(labelNimi);
        }

        @Override
        public String getResult() {
            // TODO Auto-generated method stub
            return null;
        }
    
        @Override
        public void handleShown() {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void setDefault(String arg0) {
            // TODO Auto-generated method stub
            
        }
        
        //  -------------------------------------------------------
        
        
        
        
    }

    




