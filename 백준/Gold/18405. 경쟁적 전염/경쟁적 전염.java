import java.util.*;

public class Main {
    private int x;
    private int y;
    private int data;

    public Main(int x, int y, int data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public int I() {
        return this.x;
    }

    public int J() {
        return this.y;
    }

    public int Data() {
        return this.data;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] maps = new int[n][n];
        Queue<Main>[] virusQueues = new LinkedList[k + 1];
        for (int i = 1; i <= k; i++) {
            virusQueues[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = scan.nextInt();
                if (maps[i][j] != 0) {
                    virusQueues[maps[i][j]].add(new Main(i, j, maps[i][j]));
                }
            }
        }

        int s = scan.nextInt();
        int x = scan.nextInt() - 1;
        int y = scan.nextInt() - 1;

        int[] diri = {1, -1, 0, 0};
        int[] dirj = {0, 0, 1, -1};
        int sec = 0;

        while (sec < s) {
            for (int v = 1; v <= k; v++) {
                int size = virusQueues[v].size();
                for (int i = 0; i < size; i++) {
                    Main virus = virusQueues[v].poll();

                    for (int d = 0; d < 4; d++) {
                        int tmpdiri = virus.I() + diri[d];
                        int tmpdirj = virus.J() + dirj[d];

                        if (tmpdiri < 0 || tmpdirj < 0 || tmpdiri >= n || tmpdirj >= n || maps[tmpdiri][tmpdirj] != 0) {
                            continue;
                        }

                        maps[tmpdiri][tmpdirj] = virus.Data();
                        virusQueues[v].add(new Main(tmpdiri, tmpdirj, virus.Data()));
                    }
                }
            }
            sec++;
        }

        System.out.println(maps[x][y]);
    }
}