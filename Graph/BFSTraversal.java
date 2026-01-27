package Graph;

import java.util.*;

public class BFSTraversal {
    private static void bfs(int i, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(! queue.isEmpty())
        {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int e : graph.get(node)){
                if(!visited[e]){
                    queue.add(e);
                    visited[e] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("vertex :");
        int v = sc.nextInt();
        System.out.print(" edges : ");
        int e = sc.nextInt();
        for(int i =0;i<v;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i =0;i< e;i++){
            System.out.print(i+1 + " node :" );
            int j = sc.nextInt();
            int k = sc.nextInt();
            graph.get(j).add(k);
            graph.get(k).add(j);
        }
        System.out.println(graph);
        bfs(0, graph);
    }

}
