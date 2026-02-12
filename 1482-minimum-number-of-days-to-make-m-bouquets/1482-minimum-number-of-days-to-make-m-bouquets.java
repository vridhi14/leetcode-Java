class Solution {

    public int canMakeMBouquet(int[] bloomDay, int mid, int k){
        int bouquetCount = 0;
        int consecutiveCnt = 0;
        int n = bloomDay.length;

        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= mid){
                consecutiveCnt++;
            } else {
                consecutiveCnt = 0;
            }

            if(consecutiveCnt == k){
                bouquetCount++;
                consecutiveCnt = 0;
            }
        }
        return bouquetCount;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long)m * k > n) return -1;

        int start = 1;
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int result = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(canMakeMBouquet(bloomDay, mid, k) >= m){
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
