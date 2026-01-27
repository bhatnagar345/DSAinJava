package Graph;
//Problem (Quick Recap)
//
//You are given a grid where:
//0 → empty cell
//1 → fresh orange
//2 → rotten orange
//Every minute, a rotten orange turns its adjacent (up/down/left/right) fresh oranges rotten.
//👉 Return the minimum time needed to rot all oranges
//👉 If impossible → return -1
//
//🔹 Key Idea (VERY IMPORTANT)
//This is a multi-source BFS problem:
//Put all rotten oranges (2) into a queue initially
//Count total fresh oranges
//BFS level by level:
//Each BFS level = 1 minute
//Rot adjacent fresh oranges
//If fresh oranges remain → -1
import java.util.*;

public class RottenOranges {

    // Function to find minimum time to rot all oranges
    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 &&
                            nr < rows && nc < cols &&
                            grid[nr][nc] == 1) {

                        grid[nr][nc] = 2; // rot it
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) minutes++;
        }

        // Step 3: Check if fresh oranges remain
        return freshCount == 0 ? minutes : -1;
    }

    // Main method
    public static void main(String[] args) {

        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

        System.out.println("Minimum time (Grid 1): " + orangesRotting(grid1));
        System.out.println("Minimum time (Grid 2): " + orangesRotting(grid2));
    }
}
