package Digui;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author He
 * @Date 2020/3/29 9:28
 * @Version 1.0
 */
public class miGong {
    private int[][] migong = new int[7][8];

    public miGong() {
        for (int i = 0; i < 8; i++) {
            migong[0][i] = 1;
            migong[6][i] = 1;
        }
        for (int i = 1; i < 6; i++) {
            migong[i][0] = 1;
            migong[i][7] = 1;
        }
        migong[3][1] = 1;
        migong[3][2] = 1;


    }

    public boolean query(int[][] map, int i, int j) {
        if (map[5][6] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j]=2;
                if (query(map, i + 1, j)) {
                    return true;
                } else if (query(map, i, j + 1)) {
                    return true;
                } else if (query(map, i - 1, j)) {
                    return true;
                } else if (query(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public int[][] getMigong() {
        return migong;
    }


    public void show() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(migong[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

class test {
    public static void main(String[] args) {
        miGong mi = new miGong();
        mi.show();
        System.out.println("===========");
        mi.query(mi.getMigong(),1,1);
        mi.show();
    }
}
