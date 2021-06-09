package pt.ipbeja.estig.po2.boulderdash.model;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 20/05/2021
 */
public class Bonus extends ImmobileObject{
    private int row;
    private int col;

    public Bonus(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
