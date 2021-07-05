package pt.ipbeja.estig.po2.boulderdash.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.w3c.dom.events.Event;
import pt.ipbeja.estig.po2.boulderdash.model.AbstractPosition;
import pt.ipbeja.estig.po2.boulderdash.model.GameModel;
import pt.ipbeja.estig.po2.boulderdash.model.LevelParser;
import pt.ipbeja.estig.po2.boulderdash.model.Rock;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 20/05/2021
 */
public class Board extends BorderPane {
    private BoulderdashButton[][] buttons;
    private GameModel model;
    private BoulderdashGUI gui;

    public Board(GameModel model) {
        this.model = model;
        buttons = new BoulderdashButton[this.model.getHeight()][this.model.getWidth()];
        GridPane grid = createButtonGrid();
        updateButtonGrid();

        this.setCenter(grid);
    }

    private GridPane createButtonGrid(){
        LevelParser.fileReader();
        GridPane grid = new GridPane();
        BoulderdashButtonHandler handler = new BoulderdashButtonHandler();
        for(int row = 0; row < model.getHeight(); row++){
            for(int col = 0; col < model.getWidth(); col++){
                buttons[row][col] = new BoulderdashButton(row, col);
                buttons[row][col].setPrefSize(50, 50);
                buttons[row][col].setOnAction(handler);
                grid.add(buttons[row][col], col, row);
                drawCellContent(row, col);
            }
        }
        return grid;
    }

    private void drawCellContent(int row, int col) {
        AbstractPosition absPosition = model.getMap()[row][col];
        if(absPosition.isPassable()){
            buttons[row][col].setText("O");
        } else if(absPosition.isWalkable()){
            buttons[row][col].setText("F");
        } else{
            buttons[row][col].setText("W");
        }

        checkForRockford(row, col);
        checkForRock(row, col);
    }

    private void updateButtonGrid() {
        for(int row = 0; row < model.getHeight(); row++){
            for(int col = 0; col < model.getWidth(); col++){
                drawCellContent(row, col);
            }
        }
    }

    private void checkForRockford(int row, int col){
        if(model.getRockford().getRow() == row && model.getRockford().getCol() == col){
            buttons[row][col].setText("J" + buttons[row][col].getText());
        }
    }

    private void checkForRock(int row, int col){
        for(Rock rock : model.getRocks()){
            if(rock.getRow() == row && rock.getCol() == col){
                buttons[row][col].setText("P" + buttons[row][col].getText());
            }
        }
    }

    private class BoulderdashButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            BoulderdashButton button = (BoulderdashButton) event.getSource();
            model.moveRockford(button.getRow(), button.getCol());
            updateButtonGrid();
        }
    }
}
