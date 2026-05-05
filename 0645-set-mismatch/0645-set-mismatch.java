class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int duplicate = -1;

        for(int num : nums){
            if(set.contains(num)){
                duplicate = num;
            }
            set.add(num);
        }

        int missing = -1;
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                missing = i;
                break;
            }
        }
        return new int[] {duplicate, missing};
    }
}