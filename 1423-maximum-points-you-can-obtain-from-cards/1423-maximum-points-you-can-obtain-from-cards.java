class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length ; 
        int leftSum = 0 ; 
        for(int i = 0 ; i<k ; i++){
            leftSum += cardPoints[i];
        }
        int rightSum = 0 ; 
        int maxSum = leftSum ; 
        for(int i = k-1 ; i >= 0 ; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[n-(k-i)];

            maxSum = Math.max(maxSum , leftSum + rightSum);
        }
        return maxSum ; 
    }
}