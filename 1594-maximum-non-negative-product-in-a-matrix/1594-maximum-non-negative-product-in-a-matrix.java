class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[][] maxDP = new long[n][m];
        long[][] minDP = new long[n][m];

        maxDP[0][0] = grid[0][0];
        minDP[0][0] = grid[0][0];

        for(int i = 1; i < n; i++){
            maxDP[i][0] = maxDP[i - 1][0] * grid[i][0];
            minDP[i][0] = maxDP[i][0];
        }

        for(int j = 1; j < m; j++){
            maxDP[0][j] = maxDP[0][j - 1] * grid[0][j];
            minDP[0][j] = maxDP[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                long val = grid[i][j];

                long a = maxDP[i - 1][j] * val;
                long b = minDP[i - 1][j] * val;
                long c = maxDP[i][j - 1] * val;
                long d = minDP[i][j - 1] * val;

                maxDP[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDP[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        long res = maxDP[n - 1][m - 1];
        if(res < 0) return -1;

        return (int)(res % 1000000007);
    }
}