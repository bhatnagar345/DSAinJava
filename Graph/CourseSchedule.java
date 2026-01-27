package Graph;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an
// array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you
// want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.



//Course Schedule — Problem Explanation (Plain English)
//
//You are given:
//
//numCourses → total number of courses (0 to numCourses-1)
//
//prerequisites[i] = [a, b] →
//👉 to take course a, you must first complete course b
//👉 edge: b → a
//
//What is asked?
//
//Check if all courses can be completed
//
//If there is a cycle → ❌ not possible
//
//If possible → return one valid order to finish all courses
//(this is topological sorting)
//
//🔹 Key Insight (Very Important)
//
//This is a Directed Graph
//
//We need to:
//
//Detect cycle
//
//If no cycle → perform Topological Sort
//
//Best approach: BFS (Kahn’s Algorithm)
//
//🔹 Why BFS / Kahn’s Algorithm?
//
//✔ Directly uses indegree
//✔ Easy cycle detection
//✔ Produces topological order naturally
//
//Courses with indegree = 0 have no prerequisites → can be taken first

import java.util.*;

public class CourseSchedule {

    // Function to check possibility and return course order
    public static List<Integer> findCourseOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build indegree array
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add all indegree-0 nodes to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: BFS (Kahn's Algorithm)
        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);

            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Step 5: Check if all courses are processed
        if (topoOrder.size() != numCourses) {
            // Cycle exists
            return new ArrayList<>(); // not possible
        }

        return topoOrder; // possible, return order
    }

    // Main method
    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        List<Integer> order = findCourseOrder(numCourses, prerequisites);

        if (order.isEmpty()) {
            System.out.println("It is NOT possible to finish all courses (cycle exists).");
        } else {
            System.out.println("It IS possible to finish all courses.");
            System.out.println("One valid course order: " + order);
        }
    }
}

