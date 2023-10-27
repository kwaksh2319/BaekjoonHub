import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<String> results = new ArrayList<>();
        for (int z = 0; z < T; z++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < x.length(); i++) {
                char c = x.charAt(i);
                if (Character.isDigit(c)) {
                    tmp.append(c);
                } else if (c == ',' || c == ']') {
                    if (tmp.length() > 0) {
                        deque.add(Integer.parseInt(tmp.toString()));
                        tmp.setLength(0);
                    }
                }
            }

            boolean reversed = false;
            boolean error = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reversed = !reversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        results.add("error");
                        error = true;
                        break;
                    }
                    if (reversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (!error) {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(reversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                results.add(sb.toString());
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
