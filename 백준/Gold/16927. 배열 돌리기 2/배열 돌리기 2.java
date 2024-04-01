import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int[][] maps;
    public static int[][] copymaps;
    public static int n, m, k;

    public static void prtints(int[][] maps, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotation(int startr, int endr, int startc, int endc) {
        // top
        for (int i = startc + 1; i <= endc; i++) {
            copymaps[startr][i - 1] = maps[startr][i];
        }
        // left
        for (int i = startr; i < endr; i++) {
            copymaps[i + 1][startc] = maps[i][startc];
        }
        // right
        for (int i = startr + 1; i <= endr; i++) {
            copymaps[i - 1][endc] = maps[i][endc];
        }
        // bottom
        for (int i = startc; i < endc; i++) {
            copymaps[endr][i + 1] = maps[endr][i];
        }
        // Update the original map after completing the rotation for the current layer
        for (int i = startr; i <= endr; i++) {
            for (int j = startc; j <= endc; j++) {
                maps[i][j] = copymaps[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        maps = new int[n][m];
        copymaps = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = scan.nextInt();
                maps[i][j] = tmp;
                copymaps[i][j] = tmp;
            }
        }

        int ci = Math.min(n, m) / 2;

        for (int i = 0; i < ci; i++) {
            int parms = (2 * (n - 2 * i) + 2 * (m - 2 * i) - 4);
            int rotations = k % parms; // Calculate rotations for each layer based on its perimeter
            for (int t = 0; t < rotations; t++) {
                rotation(i, n - 1 - i, i, m - 1 - i);
            }
        }

        prtints(maps, n, m);
    }
}
