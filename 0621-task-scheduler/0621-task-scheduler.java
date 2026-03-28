class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int maxFreq = freq[25];
        int countMax = 1;

        // Count how many have max frequency
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) countMax++;
            else break;
        }

        return Math.max(
            tasks.length,
            (maxFreq - 1) * (n + 1) + countMax
        );
    }
}