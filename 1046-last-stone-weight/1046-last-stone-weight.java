class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.offer(stone); 
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int secound = pq.poll();

            if( first != secound){
                pq.offer(first - secound);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek(); 
    }
}