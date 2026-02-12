class Solution { 

    private int sumOfD(int[] nums, int mid){
        int sum = 0; 
        for(int num : nums){
            sum += (num + mid - 1) / mid;   // integer ceil
        }
        return sum; 
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = high; 

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(sumOfD(nums, mid) <= threshold){
                ans = mid; 
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
}
