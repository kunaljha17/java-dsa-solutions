//this get beast 100% on leetcode and good code 



class Solution {
    public void floodfillHelper(int[][] image, int sr, int sc, int color ,boolean vis[][],int currColor){
        if(sr<0 ||sr>=image.length||sc<0||sc>=image[0].length) return;
        if(vis[sr][sc] ||image[sr][sc]!=currColor) return;
       
        image[sr][sc] = color;
        vis[sr][sc] =true;
        floodfillHelper(image,sr-1,sc,color,vis,currColor);//up
        floodfillHelper(image,sr+1,sc,color,vis,currColor);//down
        floodfillHelper(image,sr,sc-1,color,vis,currColor);//left
        floodfillHelper(image,sr,sc+1,color,vis,currColor);//right
        
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        int currColor = image[sr][sc];
        floodfillHelper(image ,sr,sc,color,vis,currColor);
        return image;
    }
}
