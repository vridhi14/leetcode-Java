import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int currDist = curr[1];

            if (currDist > dist[node]) continue;

            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}