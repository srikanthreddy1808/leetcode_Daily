class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++){
            row.add(0);
        }

        row.set(0, 1);

        for(int i = 0; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}