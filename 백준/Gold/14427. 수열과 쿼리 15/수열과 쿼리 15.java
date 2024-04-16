import java.util.*;
import java.io.*;

public class Main {
    static class SegmentTree {
        long[] tree;
        int[] indexTree;
        int n;

        public SegmentTree(long[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            indexTree = new int[4 * n];
            build(arr, 0, n - 1, 1);
        }

        private void build(long[] arr, int start, int end, int node) {
            if (start == end) {
                tree[node] = arr[start];
                indexTree[node] = start;
                return;
            }
            int mid = (start + end) / 2;
            build(arr, start, mid, node * 2);
            build(arr, mid + 1, end, node * 2 + 1);
            if (tree[node * 2] <= tree[node * 2 + 1]) {
                tree[node] = tree[node * 2];
                indexTree[node] = indexTree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
                indexTree[node] = indexTree[node * 2 + 1];
            }
        }

        public void update(int start, int end, int node, int idx, long value) {
            if (start == end) {
                tree[node] = value;
                indexTree[node] = start;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(start, mid, node * 2, idx, value);
            } else {
                update(mid + 1, end, node * 2 + 1, idx, value);
            }
            if (tree[node * 2] <= tree[node * 2 + 1]) {
                tree[node] = tree[node * 2];
                indexTree[node] = indexTree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
                indexTree[node] = indexTree[node * 2 + 1];
            }
        }

        public int getMinIndex() {
            return indexTree[1] + 1;  // Convert to 1-based index
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        SegmentTree segTree = new SegmentTree(arr);

        int m = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1;  // 1-based to 0-based index
                long value = Long.parseLong(st.nextToken());
                segTree.update(0, n - 1, 1, index, value);
            } else if (type == 2) {
                output.append(segTree.getMinIndex()).append('\n');
            }
        }
        System.out.print(output);
    }
}
