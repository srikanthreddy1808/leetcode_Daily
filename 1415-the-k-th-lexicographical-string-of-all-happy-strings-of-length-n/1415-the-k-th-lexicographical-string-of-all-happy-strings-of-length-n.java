class Solution {
    String result = "";
    int count = 0;
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, k, ' ');
        return result;
    }
    private void dfs(StringBuilder sb, int n, int k, char prev){
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
            }
            return;
        }

        for(char c = 'a'; c <= 'c'; c++){
            if(c != prev){
                sb.append(c);
                dfs(sb, n, k, c);
                sb.deleteCharAt(sb.length() - 1);
                if(!result.isEmpty()) return;
            }
        }
    }
}