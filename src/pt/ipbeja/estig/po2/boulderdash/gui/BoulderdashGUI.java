package pt.ipbeja.estig.po2.boulderdash.gui;

import javafx.scene.layout.BorderPane;
import pt.ipbeja.estig.po2.boulderdash.model.GameModel;
import pt.ipbeja.estig.po2.boulderdash.model.LevelParser;

public class BoulderdashGUI extends BorderPane {
    private GameModel model;
    private Board board;

    public BoulderdashGUI(){
        this.model = LevelParser.buildSampleLevel();
        this.board = new Board(model);
        this.setCenter(board);
    }
}
