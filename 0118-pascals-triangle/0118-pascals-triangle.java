class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            result.add(generateRow(i));
        }
        return result;
    }
    private List<Integer> generateRow(int row){
        List<Integer> res = new ArrayList<>();
        long ans = 1;
        res.add(1);

        for(int col = 1; col <= row; col++){
            ans *= (row - col + 1);
            ans /= col;
            res.add((int) ans);
        }
        return res;
    }
}