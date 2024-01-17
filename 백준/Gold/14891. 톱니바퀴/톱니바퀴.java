
import java.util.Scanner;

public class Main {
    private static int[][] gears = new int[4][8];

    // 톱니바퀴를 시계 방향으로 회전
    public static void reverseClocks(int gearNum) {
        int firstnum = gears[gearNum][0];
        for (int j = 1; j < 8; j++) {
            gears[gearNum][j - 1] = gears[gearNum][j];
        }
        gears[gearNum][7] = firstnum;
    }

    // 톱니바퀴를 반시계 방향으로 회전
    public static void clocks(int gearNum) {
        int lastnum = gears[gearNum][7];
        for (int j = 7; j > 0; j--) {
            gears[gearNum][j] = gears[gearNum][j - 1];
        }
        gears[gearNum][0] = lastnum;
    }

    // 톱니바퀴 상태 출력
    public static void Prints() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(gears[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 점수 계산
    public static void Score() {
        int sc = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == 1) {
                sc += (1 << i);
            }
        }
        System.out.println(sc);
    }

    // 주어진 방향에 따라 톱니바퀴 이동 확인
    public static void checkingmove(int num, int dir, boolean[] visited) {
        if (num < 0 || num > 3) {
            return;
        }

        visited[num] = true;

        if (num > 0 && !visited[num - 1]) {
            if (gears[num][6] != gears[num - 1][2]) {
                checkingmove(num - 1, -dir, visited);
            }
        }

        if (num < 3 && !visited[num + 1]) {
            if (gears[num][2] != gears[num + 1][6]) {
                checkingmove(num + 1, -dir, visited);
            }
        }

        if (dir == 1) {
            clocks(num);
        } else {
            reverseClocks(num);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 사용자 입력을 통한 톱니바퀴 상태 설정
        for (int i = 0; i < 4; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < str.length(); j++) {
                gears[i][j] = str.charAt(j) - '0';
            }
        }
      //  Prints();

        // 회전 명령의 횟수 입력 받기
        int k = scan.nextInt();
        for (int i = 0; i < k; i++) {
            int gearNum = scan.nextInt() - 1;
            int dir = scan.nextInt();
            boolean[] visited = new boolean[4];
            checkingmove(gearNum, dir, visited);
           // Prints();
        }
        Score();

        scan.close();
    }
}


