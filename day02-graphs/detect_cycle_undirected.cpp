// Day 02 — Detect Cycle in an Undirected Graph (GeeksforGeeks)
// DFS + parent tracking: during DFS, if we revisit an already-visited
// neighbour that is NOT the node we came from, the edge closes a loop.
// Undirected-only trick — track the immediate parent to skip the edge
// we just traversed, any other `visited` neighbour means a cycle.
//
// Time: O(V + E)   Space: O(V + E)

// recursive helper — returns 1 if a loop is found from `node`
bool findLoop(vector<vector<int>>& adj, vector<bool>& visited, int node, int parent) {
    visited[node] = 1;
    for (int neib : adj[node]) {
        if (neib == parent) {
            continue;
        }
        else if (visited[neib]) {
            return 1;
        }
        else {
            if (findLoop(adj, visited, neib, node))
                return 1;
        }
    }
    return 0;
}

bool isCycle(int V, vector<vector<int>>& edges) {
    // convert the edges vector into adjList
    vector<vector<int>> adj(V);
    vector<bool> visited(V, 0);

    for (int i = 0; i < edges.size(); i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (findLoop(adj, visited, i, -1)) {
                return 1;
            }
        }
    }
    return 0;
}
