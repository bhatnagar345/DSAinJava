package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    public  static void dfs(int start, boolean[] v, List<List<Integer>> graph){
        v[start] = true;
        System.out.print(start + " ");
        for(int e : graph.get(start)){
            if(!v[e]){
                dfs(e,v,graph);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add undirected edges
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3); // This edge forms a cycle
        adj.get(2).add(4); adj.get(4).add(2);

        boolean[] visited = new boolean[V];
        dfs(0,visited,adj);
    }
}
