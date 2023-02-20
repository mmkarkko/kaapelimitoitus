package fxMitoitus;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author miiaa
 * @version 20.2.2023
 *
 */
public class KaapelimitoitusMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("KaapelimitoitusGUIView.fxml"));
            final Pane root = ldr.load();
            //final KaapelimitoitusGUIController kaapelimitoitusCtrl = (KaapelimitoitusGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("kaapelimitoitus.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Kaapelimitoitus");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei kaytossa
     */
    public static void main(String[] args) {
        launch(args);
    }
}