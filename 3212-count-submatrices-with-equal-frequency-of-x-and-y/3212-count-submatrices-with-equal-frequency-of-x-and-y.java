class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] sumX = new int[n][m];
        int[][] sumY = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int x = (grid[i][j] == 'X') ? 1 : 0;
                int y = (grid[i][j] == 'Y') ? 1 : 0;

                sumX[i][j] = x;
                sumY[i][j] = y;

                if(i > 0){
                    sumX[i][j] += sumX[i - 1][j];
                    sumY[i][j] += sumY[i - 1][j];
                }
                if(j > 0){
                    sumX[i][j] += sumX[i][j - 1];
                    sumY[i][j] += sumY[i][j - 1];
                }
                if(i > 0 && j > 0){
                    sumX[i][j] -= sumX[i - 1][j - 1];
                    sumY[i][j] -= sumY[i - 1][j - 1];
                }
                if(sumX[i][j] == sumY[i][j] && sumX[i][j] > 0){
                    count++;
                }
            }
        }
        return count;
    }
}