class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);

        int sum = 0;
        int sign = 1;

        for(char ch : s.toCharArray()){
            sum += sign * (ch - '0');
            sign *= -1;
        }
        return sum;
    }
}