class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        for(int[] row : visited){
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, k, 0});
        visited[0][0] = k;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int r = curr[0], c = curr[1], rem = curr[2], steps = curr[3];

            if(r == n - 1 && c == m - 1) return steps;

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int newK = rem - grid[nr][nc];

                if(newK < 0) continue;

                if(visited[nr][nc] >= newK) continue;

                visited[nr][nc] = newK;
                queue.offer(new int[] {nr, nc, newK, steps + 1});
            }
        }
        return -1;
    }
}