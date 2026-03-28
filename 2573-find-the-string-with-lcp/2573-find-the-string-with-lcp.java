class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        Arrays.fill(s, '#');

        char ch = 'a';
        for(int i = 0; i < n; i++){
            if(s[i] == '#'){
                if(ch > 'z') return "";
                for(int j = i; j < n; j++){
                    if(lcp[i][j] > 0){
                        s[j] = ch;
                    }
                }
                ch++;
            } 
        }

        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(s[i] == s[j])
                dp[i][j] = 1 + dp[i + 1][j + 1];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] != lcp[i][j]){
                    return "";
                }
            }
        }
        return new String(s);
    }
}