public class Move {
    public  Tiles[][] toTheLeft (Tiles[][] tile) {
        int i = 1;
        int j = 0;
        int k = 0;

        while (j<4) {
            while (i<4) {
                while (k<i) {
                    if (tile[i-k][j].getValue() == 0)
                        break;
                    else if (tile[i-k][j].getValue() == tile[i-k-1][j].getValue()) {
                        tile[i-k-1][j].setValue(tile[i-k-1][j].getValue()*2);
                        tile[i-k][j].setValue(0);
                    } else if (tile[i-k-1][j].getValue() == 0) {
                        tile[i-k-1][j].setValue(tile[i-k][j].getValue());
                        tile[i-k][j].setValue(0);
                    }
                    k++;
                }
                i++;
                k = 0;
            }
            i = 1;
            k = 0;
            j++;
        }

        return tile;
    }

    public  Tiles[][] toTheRight (Tiles[][] tile) {
        int i = 2;
        int j = 0;
        int k = 3;

        while (j<4) {
            while (i>=0) {
                while (k>i) {
                    if (tile[3-k+i][j].getValue() == 0)
                        break;
                    else if (tile[3-k+i][j].getValue() == tile[4-k+i][j].getValue()) {
                        tile[4-k+i][j].setValue(tile[3-k+i][j].getValue()*2);
                        tile[3-k+i][j].setValue(0);
                    } else if (tile[4-k+i][j].getValue() == 0) {
                        tile[4-k+i][j].setValue(tile[3-k+i][j].getValue());
                        tile[3-k+i][j].setValue(0);
                    }
                    k = k - 1;
                }
                i = i - 1;
                k = 3;
            }
            i = 2;
            k = 3;
            j++;
        }

        return tile;
    }

    public  Tiles[][] toTheUp (Tiles[][] tile) {
        int i = 0;
        int j = 1;
        int k = 0;

        while (i<4) {
            while (j<4) {
                while (k<j) {
                    if (tile[i][j-k].getValue() == 0)
                        break;
                    else if (tile[i][j-k].getValue() == tile[i][j-k-1].getValue()) {
                        tile[i][j-k-1].setValue(tile[i][j-k-1].getValue()*2);
                        tile[i][j-k].setValue(0);
                    } else if (tile[i][j-k-1].getValue() == 0) {
                        tile[i][j-k-1].setValue(tile[i][j-k].getValue());
                        tile[i][j-k].setValue(0);
                    }
                    k++;
                }
                j++;
                k = 0;
            }
            i++;
            k = 0;
            j = 1;
        }

        return tile;
    }

    public  Tiles[][] toTheDown (Tiles[][] tile) {
        int i = 0;
        int j = 2;
        int k = 3;

        while (i<4) {
            while (j>=0) {
                while (k>i) {
                    if (tile[i][3-k+j].getValue() == 0)
                        break;
                    else if (tile[i][3-k+j].getValue() == tile[i][4-k+j].getValue()) {
                        tile[i][4-k+j].setValue(tile[i][3-k+j].getValue()*2);
                        tile[i][3-k+j].setValue(0);
                    } else if (tile[i][4-k+j].getValue() == 0) {
                        tile[i][4-k+j].setValue(tile[i][3-k+j].getValue());
                        tile[i][3-k+j].setValue(0);
                    }
                    k = k - 1;
                }
                j = j - 1;
                k = 3;
            }
            j = 2;
            k = 3;
            i++;
        }
    }

    return tile;
}