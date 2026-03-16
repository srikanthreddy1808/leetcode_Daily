class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                set.add(grid[i][j]);

                for(int k = 1; i - k >= 0 && i + k < rows && j - k >= 0 && j + k < cols; k++){
                    int sum = 0;

                    int r = i - k;
                    int c = j;

                    for(int t = 0; t < k; t++){
                        sum += grid[r][c];
                        r++;
                        c++;
                    }

                    for(int t = 0; t < k; t++){
                        sum += grid[r][c];
                        r++;
                        c--;
                    }

                    for(int t = 0; t < k; t++){
                        sum += grid[r][c];
                        r--;
                        c--;
                    }

                    for(int t = 0; t < k; t++){
                        sum += grid[r][c];
                        r--;
                        c++;
                    }
                    set.add(sum);
                }
            }
        }
        int size = Math.min(3, set.size());
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = set.pollLast();
        }
        return ans;
    }
}