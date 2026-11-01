// Day 03 — Topological Sort using Kahn's Algorithm (BFS) (GeeksforGeeks)
// Same problem as topological_sort_dfs.cpp, solved with the BFS approach.
//
// Kahn's algorithm: repeatedly "peel" nodes with in-degree 0 off a queue.
// Every time a node is popped, decrement the in-degree of its neighbours;
// any neighbour that hits 0 now has all its prerequisites done → enqueue it.
// The pop order IS a valid topological order.
//
// Bonus property DFS can't give for free: if the graph has a cycle, the
// result array ends up shorter than V (some node's in-degree never hits 0).
// result.size() < V  ⇔  cycle exists — cycle detection comes for free!
//
// Time: O(V + E)   Space: O(V + E)

class Solution {
public:
    vector<int> topologicalSort(int V, vector<vector<int>>& edges) {
        // Your code here

        // adjacency list
        // Kahn's algorithm
        vector<int> adj[V];
        vector<int> inDegree(V, 0);

        // find the inDegree of each node
        for (auto edge : edges) {
            //  u --> v
            // edge[0] --> edge[1]
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v);
            inDegree[v]++;
        }

        queue<int> q;

        // put all those nodes into the queue whose inDegree is zero
        for (int i = 0; i < V; i++) {
            if (!inDegree[i]) {
                q.push(i);
            }
        }

        vector<int> result;

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            result.push_back(node);

            for (int neib : adj[node]) {
                inDegree[neib]--;
                if (!inDegree[neib]) {
                    q.push(neib);
                }
            }
        }

        return result;
    }
};
