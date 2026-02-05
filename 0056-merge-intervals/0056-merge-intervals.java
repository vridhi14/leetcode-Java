class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        
        // Step 2: Add first interval
        int[] curr = intervals[0];
        res.add(curr);
        
        // Step 3: Iterate and merge
        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            
            // if overlapping: curr.end >= next.start
            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]); // merge
            }
            else {
                curr = next;        // update current 
                res.add(curr);      // add to list
            }
        }
        
        // convert list to array
        return res.toArray(new int[res.size()][]);
    }
}
