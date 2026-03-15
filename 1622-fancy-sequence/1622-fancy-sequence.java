class Fancy {

    List<Long> arr;
    long mul = 1;
    long add = 0;
    int MOD = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long stored = ((val - add) % MOD + MOD) % MOD;
        stored = (stored * inv) % MOD;
        arr.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if(idx >= arr.size()) return -1;

        long val = arr.get(idx);
        return (int)((val * mul + add) % MOD);
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        a %= MOD;

        while(b > 0){
            if((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}