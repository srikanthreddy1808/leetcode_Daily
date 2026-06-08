class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> great = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                less.add(nums[i]);
            }else if(nums[i] == pivot){
                equal.add(nums[i]);
            }else{
                great.add(nums[i]);
            }
        }
        int idx = 0;
        for(int num : less){
            result[idx++] = num;
        }
        for(int num : equal){
            result[idx++] = num;
        }
        for(int num : great){
            result[idx++] = num;
        }
        return result;
    }
}