class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxright = -1;

        for(int i = n - 1; i >= 0; i--){
            int curr = arr[i];
            arr[i] = maxright;
            maxright = Math.max(maxright, curr);
        }
        return arr;
    }
}