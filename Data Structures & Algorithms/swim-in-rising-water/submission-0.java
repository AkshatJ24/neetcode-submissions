class Solution {
    static class Cell {
        int r, c, time;

        Cell(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new Cell(0, 0, grid[0][0]));
        visited[0][0] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int time = curr.time;

            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int nextTime = Math.max(time, grid[nr][nc]);
                    pq.add(new Cell(nr, nc, nextTime));
                }
            }
        }

        return -1;
    }
}