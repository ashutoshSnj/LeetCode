package Daily_Question;

import java.util.PriorityQueue;
import java.util.Comparator;
public class Swim_in_Rising_Water {
    private static class Node {
        int r, c, h;
        Node(int r, int c, int h) {
            this.r = r; this.c = c; this.h = h;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        pq.add(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;

        int ans = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            ans = Math.max(ans, cur.h);

            if (cur.r == n - 1 && cur.c == n - 1) {
                return ans;
            }

            for (int[] d : dirs) {
                int nr = cur.r + d[0];
                int nc = cur.c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.add(new Node(nr, nc, grid[nr][nc]));
                }
            }
        }
        return ans;
    }
}
