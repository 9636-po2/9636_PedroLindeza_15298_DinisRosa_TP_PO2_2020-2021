package pt.ipbeja.estig.po2.boulderdash.model;

import java.util.List;

/**
 * @author Pedro Lindeza, 9636 & Dinis Rosa, 15298
 * @version 05/07/2021
 */
public class LevelParser {
    private static AbstractPosition[][] map;
    private static List<Rock> rocks;
    private static Rockford rockford;

    public static GameModel parse(){
        buildBoardFromLevel();
        return new GameModel(map, rocks, rockford);
    }

    /*private static int getLevelWidth() {
        int width = level[0].length();
        for (int i = 1; i < level.length; i++) {
            if (level[i].length() > width) {
                width = level[i].length();
            }
        }
        return width;
    }*/

    private static void buildBoardFromLevel() {
    }

    public static GameModel buildSampleLevel() {
        return new GameModel(map, rocks, rockford);
    }
}
