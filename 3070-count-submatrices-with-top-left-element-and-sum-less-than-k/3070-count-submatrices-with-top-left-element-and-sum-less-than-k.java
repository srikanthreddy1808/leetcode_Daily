class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] prefix = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                prefix[i][j] = grid[i][j];

                if(i > 0) prefix[i][j] += prefix[i - 1][j];
                if(j > 0) prefix[i][j] += prefix[i][j - 1];
                if(i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];

                if(prefix[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}