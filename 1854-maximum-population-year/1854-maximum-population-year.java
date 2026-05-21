class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];

        for(int[] log : logs){
            int birth = log[0];
            int death = log[1];

            years[birth - 1950]++;

            years[death - 1950]--;
        }

        int maxpop = 0;
        int currpop = 0;
        int ans = 1950;

        for(int i = 0; i < 101; i++){
            currpop += years[i];

            if(currpop > maxpop){
                maxpop = currpop;
                ans = i + 1950;
            }
        }
        return ans;
    }
}