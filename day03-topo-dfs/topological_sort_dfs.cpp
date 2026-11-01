// Day 03 — Topological Sort of a DAG using DFS (GeeksforGeeks)
// Classic DFS finishing-time trick: for every edge u->v, the DFS from u
// finishes AFTER exploring v, so appending `node` to `result` in
// post-order and then REVERSING gives a valid topological order.
//
// One important assumption: works only when the graph is a DAG.
// On a graph with a cycle the result is still returned but is not
// meaningful — detect cycles separately (Day 02/09 pairing 👀).
//
// Time: O(V + E)   Space: O(V + E)

class Solution {
public:
    void topSort(vector<int> adj[], int node, vector<bool>& visited, vector<int>& result) {
        visited[node] = 1;
        for (int neib : adj[node]) {
            if (!visited[neib]) {
                topSort(adj, neib, visited, result);
            }
        }
        result.push_back(node);
    }

    vector<int> topologicalSort(int V, vector<vector<int>>& edges) {
        // Your code here

        // adjacency list
        vector<int> adj[V];
        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
        }

        vector<bool> visited(V, 0);
        vector<int> result;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(adj, i, visited, result);
            }
        }

        reverse(result.begin(), result.end());

        return result;
    }
};
