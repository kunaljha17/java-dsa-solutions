//One of the toughest problem of Binary tree .
// here we use Bit manipulation,dp sparse tree concept ,dfs...
//by usingbit manipulation we calculate log how much we need means j max value ... j<log-1 bcz j start from 0 to log -1
//mainly first initialize dp 2d array [node][j] = store 2^j jump ancestor for node.
//first using parent array initially put dp[node][j] jth colomn j =0 means one jump ancestor .
//Column j=1 (2 steps up = jump 1, then jump 1 again):
// up[6][1] = up[ up[6][0] ][0] = up[2][0] = 0
// from node 6, jump 1 step to get node 2 (that's up[6][0]), then from node 2, jump 1 step again to get node 0 (that's up[2][0]). Two 1-step jumps chained together = one 2-step jump

// up[node][0] = parent[node]                          // base case
// up[node][j] = up[ up[node][j-1] ][j-1]               // recurrence



class TreeAncestor {
    private int[][] up;
    private int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++; 

        up = new int[n][LOG];
        for (int[] row : up) Arrays.fill(row, -1);
        for (int i = 0; i < n; i++) up[i][0] = parent[i];

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                } else {
                    up[i][j] = -1;
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG && node != -1; j++) {
            if (((k >> j) & 1) == 1) {
                node = up[node][j];
            }
        }
        return node;
    }
}
