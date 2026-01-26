class Solution {
    public boolean check(int[] nums) {
        int count = 0; 
        int n = nums.length;

        for(int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        // also check the last and first element
        if (nums[n - 1] > nums[0]) {
            count++;
        }

        // after checking everything, now return
        return count <= 1;
    }
}
