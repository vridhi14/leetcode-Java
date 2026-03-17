import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Try forming groups
        for (int num : hand) {
            if (map.get(num) == 0) continue;

            // Try to create group from num → num + groupSize - 1
            for (int i = 0; i < groupSize; i++) {
                int curr = num + i;

                if (!map.containsKey(curr) || map.get(curr) == 0) {
                    return false;
                }

                map.put(curr, map.get(curr) - 1);
            }
        }

        return true;
    }
}