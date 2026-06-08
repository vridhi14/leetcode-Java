class Solution {

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            long d = curr.dist;
            int node = curr.node;

            if (d > dist[node]) continue;

            for (Pair nei : adj.get(node)) {

                int adjNode = nei.node;
                long newDist = d + nei.dist;

                if (newDist < dist[adjNode]) {

                    dist[adjNode] = newDist;
                    ways[adjNode] = ways[node];

                    pq.offer(new Pair(adjNode, newDist));
                }

                else if (newDist == dist[adjNode]) {

                    ways[adjNode] =
                            (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}