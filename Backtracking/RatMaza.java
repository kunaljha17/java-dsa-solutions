public class RatMaza {

    public static int numRatMaze(int maze[][], int i, int j) {
        if (i == maze.length - 1 && j == maze.length - 1) {
            return 1;
        }
        if (i == -1 || j == -1 || i == maze.length || j == maze.length) {
            return 0;
        }
        if (maze[i][j] == 0) {
            return 0;
        }
        int w1 = numRatMaze(maze, i, j - 1 );
        int w2 = numRatMaze(maze, i, j + 1 );
        int w3 = numRatMaze(maze, i - 1, j );
        int w4 = numRatMaze(maze, i + 1, j );

        return w1 + w2 + w3 + w4;
    }

    public static void main(String[] args) {
        int n = 4;
        int maze[][] = new int[n][n];
        // initialization maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i == 1 && j == 0 || i == 1 && j == 2 || i == 3 || j == 1) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }

        System.out.println(numRatMaze(maze,0,0));

    }
}
