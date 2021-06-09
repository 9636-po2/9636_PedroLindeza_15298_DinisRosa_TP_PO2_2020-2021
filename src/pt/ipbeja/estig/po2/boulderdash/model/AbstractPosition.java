package pt.ipbeja.estig.po2.boulderdash.model;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 20/05/2021
 */
public abstract class AbstractPosition {
    private boolean isWalkable;
    private boolean isPassable;

    public AbstractPosition(boolean isWalkable, boolean isPassable){
        this.isWalkable = isWalkable;
        this.isPassable = isPassable;
    }

    public boolean isWalkable(){
        return isWalkable;
    }

    public boolean isPassable(){
        return isPassable;
    }
}
