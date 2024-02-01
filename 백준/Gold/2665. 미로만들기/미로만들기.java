import java.util.*;

public class Main {
    private int x;
    private int y;

    public Main(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine(); 

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] maps = new int[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = scan.nextLine();
            for (int j = 0; j < tmp.length(); j++) {
                maps[i][j] = tmp.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }

        Queue<Main> queue = new LinkedList<>();
        queue.add(new Main(0, 0));
        dist[0][0] = 0; 

        while (!queue.isEmpty()) {
            Main current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.getX() + dx[i];
                int ny = current.getY() + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                	continue; 
                } 

                int nextDist = dist[current.getX()][current.getY()];
                if (maps[nx][ny] == 0) {
                	nextDist += 1; 
                }

                if (dist[nx][ny] == -1 || dist[nx][ny] > nextDist) {
                    dist[nx][ny] = nextDist;
                    queue.add(new Main(nx, ny));
                }
            }
        }

        System.out.println(dist[n - 1][n - 1]); 
    }
}