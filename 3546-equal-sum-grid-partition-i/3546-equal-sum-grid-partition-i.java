class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum += grid[i][j];
            }
        }
        if(sum % 2 != 0) return false;

        long topSum = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                topSum += grid[i][j];
            }
            if(topSum == sum - topSum){
                return true;
            }
        }

        long leftSum = 0;
        for(int j = 0; j < m - 1; j++){
            for(int i = 0; i < n; i++){
                leftSum += grid[i][j];
            }
            if(leftSum == sum - leftSum){
                return true;
            }
        }
        return false;
    }
}