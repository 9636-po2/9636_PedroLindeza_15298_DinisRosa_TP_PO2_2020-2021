package pt.ipbeja.estig.po2.boulderdash.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

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

    public static void fileReader(){

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/pt/ipbeja/estig/po2/sokoban/gui/levels/text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Lê 1a linha do ficheiro
        String firstLine = scanner.nextLine();
        //Descobre o tamanho do mapa
        String[] RowColArray = DiscoverRowCol(firstLine);

        String[][] levelStringArray = new String[Integer.parseInt(RowColArray[0])][Integer.parseInt(RowColArray[1])];

        //numero da linha
        int linePosition = 0;

        //reads line by line
        boolean flag = false;
        while (scanner.hasNextLine()) {

            //lineeeeeeeeeee
            String line = scanner.nextLine();

            if (line.charAt(0) == 'J'){
                flag = true;
                System.out.println("HelloJ");

                //resto das letras aqui
            } else if(line.charAt(0) == 'D'){
                flag = true;
                System.out.println("HelloD");
            } else if(line.charAt(0) == 'E'){
                flag = true;
                System.out.println("HelloE");
            } else if(line.charAt(0) == 'I'){
                flag = true;
                System.out.println("HelloI");
            } else if(line.charAt(0) == 'B'){
                flag = true;
                System.out.println("HelloB");
            }

            if (!flag) {
                //print char char
                for (int i = 0;i < line.length(); i++){
                    levelStringArray[linePosition][i] = String.valueOf(line.charAt(i));
                }
            }


            linePosition++;
        }

        //prints Array of array
        for (int row = 0; row < levelStringArray.length; row++) {
            for (int col = 0; col < levelStringArray[row].length; col++) {
                System.out.print(levelStringArray[row][col]);
            }
            System.out.println(" ");
        }
    }

    private static String[] DiscoverRowCol(String firstLine) {
        String[] RowColArray = new String[2];
        String  arow = "";
        String acol = "";
        String number = "";
        boolean flag = false;
        for (int i = 0;i < firstLine.length(); i++){
            if (flag){
                number = number + String.valueOf(firstLine.charAt(i));
            }

            if (firstLine.charAt(i) == ' '){
                arow = number;
                flag = true;
                number = "";
            } else {
                if (!flag){
                    number = number + String.valueOf(firstLine.charAt(i));
                }
            }


        }
        acol = number;

        RowColArray[0] = arow;
        RowColArray[1] = acol;
        return RowColArray;
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
