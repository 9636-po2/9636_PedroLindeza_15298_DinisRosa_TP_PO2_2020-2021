package pt.ipbeja.estig.po2.boulderdash.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 05/07/2021
 */
public class BoulderdashStart extends Application {
    @Override
    public void start(Stage primaryStage) {
        BoulderdashGUI gui = new BoulderdashGUI();
        Scene scene = new Scene(gui);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
