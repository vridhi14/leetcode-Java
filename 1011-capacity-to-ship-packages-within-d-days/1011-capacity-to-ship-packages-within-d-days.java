class Solution {
    public int numOfDay(int[] weights , int capacity){
        int day = 1 ; 
        int load = 0 ; 
        for(int i = 0 ; i<weights.length ; i++){
            if(weights[i] + load > capacity){
                day++ ; 
                load = weights[i];
            }
            else {
                load = load + weights[i];
            }
        }
        return day ; 
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low<=high){
            int mid = (low+high)/2 ; 

            int numOfDays = numOfDay(weights,mid );

            if(numOfDays <= days){
                high = mid -1 ; 
            }
            else { 
                low = mid + 1 ; 
            }
        }
        return low ; 
    }
}