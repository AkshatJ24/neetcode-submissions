class Solution {
    static class Pair{
        int row;
        int col;
        int t;
        Pair(int row, int col, int t){
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int freshcnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                } else if(grid[i][j] == 1){
                    freshcnt++;
                }
            }
        }

        int cntRotted = 0;
        int t = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int currTime = curr.t;
            t = Math.max(currTime, t);
            for(int i = 0; i < 4; i++){
                int row = r + dRow[i];
                int col = c + dCol[i];
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                    grid[row][col] = 2;
                    cntRotted++;
                    q.add(new Pair(row, col, currTime + 1));
                }
            }
        }

        return (cntRotted == freshcnt ? t : -1);
    }
}
