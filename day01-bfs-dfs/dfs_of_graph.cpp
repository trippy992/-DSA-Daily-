// Day 01 — DFS of Graph (GeeksforGeeks)
// Depth-first traversal from node 0 using recursion.

// recursive helper
void DFS(vector<int> adj[], int node, vector<bool>& visited, vector<int>& result) {
    // base case — already visited
    if (visited[node] == 1) {
        return;
    }

    visited[node] = 1;
    result.push_back(node);

    // recurse into every unvisited neighbour
    for (int neib : adj[node]) {
        if (!visited[neib]) {
            DFS(adj, neib, visited, result);
        }
    }
}

vector<int> dfsOfGraph(int V, vector<int> adj[]) {
    vector<int> result;
    vector<bool> visited(V, 0);

    DFS(adj, 0, visited, result);

    return result;
}
