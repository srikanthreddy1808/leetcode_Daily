class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int[] row : grid) {
            for (int val : row) total += val;
        }

        if (check(grid, total) || check(reverseRows(grid), total)) return true;
        
        int[][] transposed = transpose(grid);
        return check(transposed, total) || check(reverseRows(transposed), total);
    }

    private boolean check(int[][] A, long total) {
        Set<Long> seen = new HashSet<>();
        long top = 0;
        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++) {
            for (int val : A[i]) {
                seen.add(val*1L);
                top += val;
            }
            long bot = total - top;
            long diff = top - bot;

            if (diff == 0 || diff == A[0][0] || diff == A[0][cols - 1] || diff == A[i][0]) {
                return true;
            }

            if (cols > 1 && i > 0 && seen.contains(diff)) {
                return true;
            }
        }
        return false;
    }

    private int[][] transpose(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] res = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) res[j][i] = A[i][j];
        }
        return res;
    }

    private int[][] reverseRows(int[][] A) {
        int[][] res = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[A.length - 1 - i];
        }
        return res;
    }
}