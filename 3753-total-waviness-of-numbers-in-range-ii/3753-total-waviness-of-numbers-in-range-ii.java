class Solution {

    class Pair {
        long count;
        long sum;

        Pair(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        digits = String.valueOf(x).toCharArray();

        int n = digits.length;

        memo = new Pair[n][11][11][2][2];

        return dfs(0, 10, 10, 0, 1).sum;
    }

    private Pair dfs(int pos,
                     int prev2,
                     int prev1,
                     int started,
                     int tight) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (memo[pos][prev2][prev1][started][tight] != null) {
            return memo[pos][prev2][prev1][started][tight];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int nextTight =
                (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair child =
                    dfs(pos + 1, 10, 10, 0, nextTight);

                totalCount += child.count;
                totalSum += child.sum;

            } else {

                int add = 0;

                if (started == 1 && prev2 != 10) {

                    if ((prev1 > prev2 && prev1 > digit) ||
                        (prev1 < prev2 && prev1 < digit)) {
                        add = 1;
                    }
                }

                int newPrev2;
                int newPrev1;

                if (started == 0) {
                    newPrev2 = 10;
                    newPrev1 = digit;
                } else {
                    newPrev2 = prev1;
                    newPrev1 = digit;
                }

                Pair child =
                    dfs(pos + 1,
                        newPrev2,
                        newPrev1,
                        1,
                        nextTight);

                totalCount += child.count;

                totalSum += child.sum;
                totalSum += (long) add * child.count;
            }
        }

        return memo[pos][prev2][prev1][started][tight] =
            new Pair(totalCount, totalSum);
    }
}