package Daily_Question;
import java.util.PriorityQueue;
public class Trapping_Rain_Water_II {
    private static class Cell {
        int row, col, height;
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : dirs) {
                int nr = cell.row + dir[0];
                int nc = cell.col + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    water += Math.max(0, cell.height - heightMap[nr][nc]);
                    pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], cell.height)));
                }
            }
        }

        return water;
    }
}

