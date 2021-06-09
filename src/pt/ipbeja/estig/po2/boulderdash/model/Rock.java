package pt.ipbeja.estig.po2.boulderdash.model;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 20/05/2021
 */
public class Rock extends MobileObject{
    private int row;
    private int col;
    private int id;

    public Rock(int row, int col, int id){
        this.row = row;
        this.col = col;
        this.id = id;
    }

    public void goToPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getId(){return id;}

}
