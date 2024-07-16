import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long[] tree;
    static long[] lazy;

    public static void initTree(long[] arr) {
        buildTree(0, n - 1, 1, arr);
    }

    public static long buildTree(int start, int end, int node, long[] arr) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = buildTree(start, mid, node * 2, arr) + buildTree(mid + 1, end, node * 2 + 1, arr);
    }

    public static void updateRange(int start, int end, int node, int rangeStart, int rangeEnd, long diff) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (rangeStart > end || rangeEnd < start) {
            return;
        }

        if (rangeStart <= start && end <= rangeEnd) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }

        int mid = (start + end) / 2;
        updateRange(start, mid, node * 2, rangeStart, rangeEnd, diff);
        updateRange(mid + 1, end, node * 2 + 1, rangeStart, rangeEnd, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long queryRange(int start, int end, int node, int queryStart, int queryEnd) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (queryStart > end || queryEnd < start) {
            return 0;
        }

        if (queryStart <= start && end <= queryEnd) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return queryRange(start, mid, node * 2, queryStart, queryEnd) + queryRange(mid + 1, end, node * 2 + 1, queryStart, queryEnd);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[n * 4];
        lazy = new long[n * 4];

        initTree(arr);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                long d = Long.parseLong(st.nextToken());
                updateRange(0, n - 1, 1, b, c, d);
            } else if (type == 2) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                long result = queryRange(0, n - 1, 1, b, c);
                System.out.println(result);
            }
        }

    }
}
