public class flood_fill {

    public static void helper(int images[][], int sr, int sc, int color, boolean vis[][], int orgCol) {
        if (sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length || vis[sr][sc]
                || images[sr][sc] != orgCol) {
            return;
        }
        images[sr][sc] = color;
        vis[sr][sc] = true;

        helper(images, sr, sc-1, color, vis, orgCol);
        helper(images, sr, sc+1, color, vis, orgCol);
        helper(images, sr-1, sc, color, vis, orgCol);
        helper(images, sr+1, sc, color, vis, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sc, int sr, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int images[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
       int image[][] = floodFill(images,1,1,2);
       for(int i =0;i<image.length;i++){
        for(int j =0;j<image[i].length;j++){
            System.out.print(image[i][j]+" ");
        }
        System.out.println();
       }
    }
}
