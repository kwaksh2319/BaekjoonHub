import java.util.*;

public class Main {
    static final int MAX = 100001;  // 최대 범위 설정
    static int[] time = new int[MAX];  // 각 위치에 도달하는데 걸린 시간 저장
    static int[] path = new int[MAX];  // 이전 위치 추적

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        Arrays.fill(time, -1);  // 시간 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n] = 0;
        path[n] = -1;  // 시작 위치

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : new int[]{current - 1, current + 1, 2 * current}) {
                if (next >= 0 && next < MAX && time[next] == -1) {
                    q.add(next);
                    time[next] = time[current] + 1;
                    path[next] = current;

                    if (next == k) {
                        System.out.println(time[next]);
                        printPath(n, k);
                        return;
                    }
                }
            }
        }
    }

    private static void printPath(int start, int end) {
        if (end != start) {
            printPath(start, path[end]);
        }
        System.out.print(end + " ");
    }
}
