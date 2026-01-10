package Graph;

//Your Question
//
//If a directed graph has a cycle, and I try to do topological sort:
//
//Will DFS-based topo sort go into an infinite loop?
//
//Will BFS-based topo sort (Kahn’s) return an empty list?
//
//✅ Short, Correct Answer
//Method	What happens if graph has a cycle?
//DFS Topological Sort	❌ Does NOT go infinite
//BFS (Kahn’s Algorithm)	❌ Returns incomplete list (size < V)
//🔴 Important Correction (Very Important)
//
//DFS-based topological sort will NOT go into infinite recursion
//because it uses a visited[] array.
//
//But…
//
//👉 DFS topo sort alone cannot detect cycles unless you explicitly add cycle detection logic.
//
//🔹 Case 1: DFS-Based Topological Sort (with cycle)
//What DFS does
//
//DFS marks nodes as visited
//
//Once visited, it never revisits the same node
//
//So no infinite loop
//
//Problem
//
//DFS topo sort will still push nodes into stack
//
//It may return an order that is INVALID
//
//It does NOT tell you a cycle exists
//
//Example
//0 → 1 → 2
//↑       ↓
//└───────┘
//
//
//DFS topo sort output (example):
//
//[0, 1, 2]  ❌ (invalid topo order)
//
//
//But:
//
//Graph has a cycle
//
//Topological sort should not exist
//
//❗ Conclusion
//
//DFS topo sort silently fails on cyclic graphs unless cycle detection is added
//
//🔹 Case 2: BFS-Based Topological Sort (Kahn’s Algorithm)
//What BFS does
//
//Starts with nodes having indegree = 0
//
//Removes them and reduces indegrees
//
//What happens in a cycle?
//
//No node has indegree = 0
//
//Queue starts empty or becomes empty early
//
//BFS stops
//
//Result
//
//Output list size < V
//
//This clearly indicates a cycle
//
//Example
//0 → 1 → 2 → 0
//
//
//Indegree:
//
//0: 1
//1: 1
//2: 1
//
//
//Queue: ❌ empty
//Output: [] or partial list
//
//❗ Conclusion
//
//BFS topo sort naturally detects cycles
//
//🔹 Final Comparison (Interview Gold)
//Aspect	DFS Topo	BFS (Kahn)
//Infinite loop?	❌ No	❌ No
//Cycle detection	❌ Needs extra logic	✅ Built-in
//Invalid output risk	⚠️ Yes	❌ No
//Interview preference	⚠️ Medium	✅ High
//🧠 Interview One-Liners (MEMORIZE)
//
//✔ “DFS-based topo sort does not detect cycles by default.”
//✔ “Kahn’s algorithm detects cycles when topo size < V.”
//✔ “If a cycle exists, a topological order is impossible.”
//✔ “BFS topo sort is safer for cycle detection.”
//
//🔹 How to Fix DFS Topological Sort?
//
//Add a recursion stack (pathVisited[]):
//
//If you revisit a node in current DFS path → cycle detected
//
//Abort topo sort
//
//(This is how Course Schedule DFS solution works.)