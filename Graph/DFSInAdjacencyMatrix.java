package Graph;
//                0 1 2 3 4 5
//            0 [ 0 1 1 0 0 0 ]
//            1 [ 0 0 0 1 0 0 ]
//            2 [ 0 0 0 0 0 0 ]
//            3 [ 0 0 0 0 0 0 ]
//            4 [ 0 0 0 0 0 1 ]
//            5 [ 0 0 0 0 0 0 ]


public class DFSInAdjacencyMatrix {
    static void dfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int v = 0; v < graph.length; v++) {
            // if edge exists and not visited
            if (graph[node][v] == 1 && !visited[v]) {
                dfs(v, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6; // number of nodes (0 to 5)

        // Step 1: Create 2D array (Adjacency Matrix)
        int[][] graph = new int[V][V];

        // Step 2: Add edges
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][3] = 1;
        graph[4][5] = 1;

        // (Optional) If undirected, also add reverse edges
        // graph[1][0] = 1;
        // graph[2][0] = 1;
        // graph[3][1] = 1;
        // graph[5][4] = 1;

        // Step 3: DFS traversal
        boolean[] visited = new boolean[V];

        System.out.print("DFS Traversal starting from node 0: ");
        dfs(0, graph, visited);

        // To cover disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}
