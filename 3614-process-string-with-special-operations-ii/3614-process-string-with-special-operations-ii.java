class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n];
        long curr = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                curr++;
            }else if(ch == '*'){
                if(curr > 0){
                    curr--;
                }
            }else if(ch == '#'){
                curr *= 2;
            }else{

            }
            len[i] = curr;
        }

        if(k >= curr) return '.';

        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);

            long before = (i == 0) ? 0 : len[i - 1];
            long after = len[i];

            if(ch >= 'a' && ch <= 'z'){
                if(k == before){
                    return ch;
                }
            }else if(ch == '#'){
                if(before > 0){
                    k %= before;
                }
            }else if(ch == '%'){
                k = after - 1 - k;
            }else{

            }
        }
        return '.';
    }
}