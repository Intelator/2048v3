import java.io.IOException;
import java.lang.System;
import java.util.ArrayList;
import java.io.*;

public class Helper {
    //Добавляем все пустые ячейки в список
    private ArrayList countFreeTiles (Tiles[][] tile) {
        ArrayList<Tiles> listOfFreeTiles = new ArrayList<Tiles>();

        int i = 0;
        int j = 0;

        while (i<4) {
            while (j<4) {
                if (tile[i][j].getValue() == 0) {
                    listOfFreeTiles.add(tile[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
        }

        return listOfFreeTiles;
    }

    //Выбираем случайную ячейку из списка, создаем новую плитку
    public void createRandomTile (Tiles[][] tile) {

        int i = 0;
        int j = 0;
        int r = 0;
        int p = 0;

        ArrayList<Tiles> listOfFreeTiles;

        countFreeTiles(tile);

        r = (int) Math.random()*listOfFreeTiles.size()+1;
        p = (int) Math.random();
        if (p<0.1) {
            listOfFreeTiles.get(r).setValue(4);
        } else {
            listOfFreeTiles.get(r).setValue(2);
        }
    }

    //Ожидаем пользовательский ввод
    public String waitForUserInput (String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader (new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine;
    }
}