class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) right = Math.max(right, p);

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, mid, h))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int p : piles)
            hours += (p + speed - 1) / speed; // ceil

        return hours <= h;
    }
}
