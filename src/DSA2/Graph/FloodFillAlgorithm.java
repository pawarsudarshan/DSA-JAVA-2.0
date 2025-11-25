package DSA2.Graph;

public class FloodFillAlgorithm {
    public static void main(String[] args) {

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        dfs(image,sr,sc, color, newColor,visited);
        return image;
    }
    public void dfs(int[][] image, int row, int col,int color, int newColor, boolean[][] visited) {
        if(visited[row][col]) return;
        if(image[row][col] != color) return;

        visited[row][col] = true;
        image[row][col] = newColor;

        // Left
        if(col-1>=0){
            dfs(image,row,col-1, color, newColor,visited);
        }

         // Right
         if(col+1<image[0].length){
             dfs(image,row,col+1, color, newColor,visited);
         }

        // Up
        if(row-1>=0){
            dfs(image,row-1,col, color, newColor,visited);
        }

        // Down
        if(row+1<image.length){
            dfs(image,row+1,col, color, newColor,visited);
        }
    }
}
