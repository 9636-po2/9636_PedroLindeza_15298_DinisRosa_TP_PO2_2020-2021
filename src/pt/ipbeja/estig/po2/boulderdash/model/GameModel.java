package pt.ipbeja.estig.po2.boulderdash.model;

import java.util.List;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 09/06/2021
 */
public class GameModel {
    private AbstractPosition[][] map;
    private List<Rock> rocks;
    private Rockford rockford;

    public int rockfordDirRow;
    public int rockfordDirCol;

    private int playerLastCol;
    private int playerLastRow;
    public String playerlastposition;

    public Integer rockId = null;

    public GameModel(AbstractPosition[][] map, List<Rock> rocks, Rockford rockford){
        this.map = map;
        this.rocks = rocks;
        this.rockford = rockford;
    }

    public boolean moveRockford(int row, int col) {
        setRockfordDirection(row, col);
        if (isRock(row, col) && this.rockfordIsAdjacent(row, col)) {
            moveRock(row, col);
        }
        if (isValidPos(row, col) && !isRock(row, col)) {
            savePlayerLastPos();
            rockford.goToPosition(row, col);
            //this.saveMovementsOfKeeperAndBoxId();

            return true;
        } else return false;
    }

    public void setRockfordDirection(int row, int col) {
        this.rockfordDirRow = row - rockford.getRow();
        this.rockfordDirCol = col - rockford.getCol();
    }

    public void savePlayerLastPos() {
        this.playerLastRow = rockford.getRow();
        this.playerLastCol = rockford.getCol();

        this.playerlastposition = this.playerLastRow + ", " + this.playerLastCol;
    }

    private boolean isValidPos(int row, int col) {
        if (isWithinBoardLimits(row, col) && rockfordIsAdjacent(row, col) && isWalkable(row, col)) {
            return true;
        } else return false;
    }

    private boolean isRockValidPos(int row, int col) {
        if (isWithinBoardLimits(row, col) && isWalkable(row, col) && isPassable(row, col)) {
            return true;
        } else return false;
    }

    private boolean isWalkable(int row, int col) {
        return map[row][col].isWalkable();
    }

    private boolean isPassable(int row, int col) {
        return map[row][col].isPassable();
    }

    public boolean isRock(int row, int col) {
        for (Rock rock : rocks) {
            if (rock.getRow() == row && rock.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    private boolean rockfordIsAdjacent(int row, int col) {
        if (rockford.getRow() == row && (rockford.getCol() == col + 1 || rockford.getCol() == col - 1)) {
            return true;
        } else if (rockford.getCol() == col && (rockford.getRow() == row + 1 || rockford.getRow() == row - 1)) {
            return true;
        } else return false;
    }

    public boolean checkRockOnRockPos(int row, int col) {
        for (Rock rock : rocks) {
            if (rock.getRow() == row && rock.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    public Rock returnRockToMove(int row, int col) {
        for (Rock rock : rocks) {
            if (rock.getRow() == row && rock.getCol() == col) {
                return rock;
            }
        }
        return null;
    }

    public void moveRock(int row, int col) {
        Rock rock = returnRockToMove(row, col);

        int rockNextRow = rock.getRow() + rockfordDirRow;
        int rockNextCol = rock.getCol() + rockfordDirCol;

        if (this.isRockValidPos(rockNextRow, rockNextCol) && !checkRockOnRockPos(rockNextRow, rockNextCol)) {
            rock.goToPosition(rockNextRow, rockNextCol);
            this.rockId = rock.getId();
        }
    }

    private boolean isWithinBoardLimits(int row, int col) {
        if (row >= 0 && row < getHeight() && col >= 0 && col < getWidth()) {
            return true;
        } else return false;
    }

    public int getHeight() {
        return map.length;
    }

    public int getWidth() {
        return map[0].length;
    }
}
