import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Indegree array
        int[] indegree = new int[numCourses];

        // Step 3: Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 4: Queue for nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 5: Process nodes
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 6: Check if all courses processed
        return count == numCourses;
    }
}