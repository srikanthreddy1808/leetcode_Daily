class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, result, visited, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, boolean[] visited, List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            temp.add(nums[i]);

            backtrack(nums, result, visited, temp);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}