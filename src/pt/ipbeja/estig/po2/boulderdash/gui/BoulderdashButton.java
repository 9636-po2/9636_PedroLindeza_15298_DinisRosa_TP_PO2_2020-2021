package pt.ipbeja.estig.po2.boulderdash.gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoulderdashButton extends Button {
    private int row;
    private int col;

    private final ImageView imageView;
    private static final Image WALL = new Image("/resources/Wall.png");

    public BoulderdashButton(int row, int col, ImageView imageView) {
        this.row = row;
        this.col = col;
        this.imageView = imageView;
        this.setGraphic(imageView);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setWall() {
        this.imageView.setImage(WALL);
    }


}
