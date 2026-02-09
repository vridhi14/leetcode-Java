import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // important to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));  // add current subset
        
        for (int i = index; i < nums.length; i++) {

            // SKIP duplicates on the same level
            if (i > index && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);  // choose
            backtrack(i + 1, nums, temp, result);  // explore
            temp.remove(temp.size() - 1);  // un-choose
        }
    }
}
