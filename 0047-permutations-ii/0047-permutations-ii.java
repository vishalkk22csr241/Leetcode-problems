class Solution {
    private void permuteUniqueHelper(int[] nums, List<List<Integer>> result, List<Integer> current, Set<Integer> visited) {
        if(nums.length == current.size()) {
            result.add(new ArrayList(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                current.add(nums[i]);

                permuteUniqueHelper(nums, result, current, visited);

                current.remove(current.size() - 1);
                visited.remove(i);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        permuteUniqueHelper(nums, result, new ArrayList(), new HashSet<Integer>());
        return result;
    } 
}