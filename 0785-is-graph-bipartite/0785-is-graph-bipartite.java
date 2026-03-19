class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!bfs(graph, color, i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph, int[] color, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int nei : graph[node]){
                if(color[nei] == -1){
                    color[nei] = 1 - color[node];
                    queue.add(nei);
                }else if(color[nei] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}