class Solution {
    public int minimumCost(int[] cost) {
        int count = 0;
        int ans = 0;

        Arrays.sort(cost);

        for(int i = cost.length - 1; i >= 0; i--){
            count++;

            if(count % 3 == 0){
                continue;
            }

            ans += cost[i];
        }
        return ans;
    }
}