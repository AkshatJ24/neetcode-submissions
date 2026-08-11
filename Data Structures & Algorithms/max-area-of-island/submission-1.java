class Solution {
    int currentIslandArea;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    currentIslandArea = 0;
                    dfs(i, j, grid);
                    max = Math.max(max, currentIslandArea);
                }
            }
        }

        return max;
    }

    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 0; 
        currentIslandArea++; 

        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
    }
}