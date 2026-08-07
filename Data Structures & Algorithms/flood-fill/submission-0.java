class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if(currColor != color){
            dfs(image, sr, sc, currColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int currColor, int color){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length ||
           image[r][c] != currColor){
            return;
        }
        image[r][c] = color;
        dfs(image, r-1, c, currColor, color);
        dfs(image, r+1, c, currColor, color);
        dfs(image, r, c-1, currColor, color);
        dfs(image, r, c+1, currColor, color);
    }
}