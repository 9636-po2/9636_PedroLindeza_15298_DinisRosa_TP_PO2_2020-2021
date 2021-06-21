import org.junit.Test;
import pt.ipbeja.estig.po2.boulderdash.gui.Board;
import pt.ipbeja.estig.po2.boulderdash.model.GameModel;
import pt.ipbeja.estig.po2.boulderdash.model.Rockford;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 21/06/2021
 */
public class GameModelTest {
    private GameModel model;
    private Board board;
    private Rockford rockford = Rockford.getInstance();

    @Test
    public void testeA(){
        int row = 1;
        int col = 2;

        boolean freePosition = this.model.isFloor(row, col);
        boolean validMove = this.model.moveRockford(row, col);

        assertTrue(freePosition);
        assertTrue(validMove);
        assertEquals(row, rockford.getRow());
        assertEquals(col, rockford.getCol());

    }
}
