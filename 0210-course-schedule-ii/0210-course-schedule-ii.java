class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Indegree array
        int[] indegree = new int[numCourses];

        // Build graph + indegree
        for(int[] edge : prerequisites) {

            int course = edge[0];
            int prereq = edge[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        // Step 3: Queue for indegree 0 nodes
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 4: Store topological order
        int[] ans = new int[numCourses];

        int index = 0;

        // Step 5: BFS
        while(!q.isEmpty()) {

            int node = q.poll();

            ans[index++] = node;

            for(int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Step 6: Check cycle
        if(index == numCourses) {
            return ans;
        }

        return new int[0];
    }
}