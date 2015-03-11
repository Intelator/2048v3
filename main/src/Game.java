import java.lang.String;
import java.lang.System;

public class Game {
    private Tiles[][] createNewField (Tiles[][] tile) {
        int i = 0;
        int j = 0;
        while (i<4) {
            while (j<4) {
                tile[i][j].setY(j);
                tile[i][j].setValue(0);
                j++;
            }
            j = 0;
            tile[i][j].setX(i);
            i++;
        }
    }

    private boolean checkPossibility (Tiles[][] tile) {
        isMovesPossible = false;

        int i = 0;
        int j = 0;

        //Проверим наличие пустых клеток
        if (isMovesPossible == false) {
            while (i<4) {
                while (j<4) {
                    if (tile[i][j].getValue() == 0) {
                        isMovesPossible = true;
                        break;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
        }

        //Проверим возможность сдвинуть ячейки по горизонтали
        if (isMovesPossible == false) {
            i = 0;
            j = 0;
            while (i<3) {
                while (j<3) {
                    if (tile[i][j].getValue() == tile[i][j+1].getValue()) {
                        isMovesPossible = true;
                        break;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
        }

        //Проверим возможность сдваинуть ячейки по горизонтали
        if (isMovesPossible == false) {
            i = 0;
            j = 0;
            while (j<3) {
                while (i<3) {
                    if (tile[i][j].getValue() == tile[i+1][j].getValue()) {
                        isMovesPossible = true;
                        break;
                    }
                    i++;
                }
                i = 0;
                j++;
            }
        }

        return isMovesPossible;
    }

    //Определяем движение
    private Tiles[][] findMotion (Tiles[][] tile) {
        if ((caddy.waitForUserInput() != a) & (caddy.waitForUserInput() != s) &
                (caddy.waitForUserInput() != d) & (caddy.waitForUserInput() != w)) {
            System.out.println("Use keys a, s, d, or w!");
            break;
        }

        if (caddy.waitForUserInput() == a) {
            Move.toTheLeft(tile);
        }

        if (caddy.waitForUserInput() == s) {
            Move.toTheDown(tile);
        }

        if (caddy.waitForUserInput() == d) {
            Move.toTheRight(tile);
        }

        if (caddy.waitForUserInput() == w) {
            Move.toTheUp(tile);
        }

        return tile;
    }

    private void main (String[] args) {
        Tiles[][] tile = new Tiles[4][4];
        Helper caddy = new Helper();

        //Заполняем поле нулями
        createNewField(tile);

        //Начинаем игру
        while (isMovesPossible == true) {
            //Создаем случайную плитку
            caddy.createRandomTile(tile);

            //Двигаем плитки в зависимости от ввода
            findMotion(tile);

            //Выводим поле на экран
        }
    }
}