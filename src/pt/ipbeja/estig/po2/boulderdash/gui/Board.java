package pt.ipbeja.estig.po2.boulderdash.gui;

import javafx.scene.layout.GridPane;
import pt.ipbeja.estig.po2.boulderdash.model.GameModel;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 20/05/2021
 */
public class Board extends GridPane{
    private BoulderdashButton[][] buttons;
    private GameModel model;
    private BoulderdashGUI gui;

    public Board(GameModel model, BoulderdashGUI gui) {
        this.model = model;
        createButtonGrid(this.model);
    }

    public Board(GameModel model) {
    }

    public void createButtonGrid(GameModel model) {
        this.model = model;
        
    }
}
