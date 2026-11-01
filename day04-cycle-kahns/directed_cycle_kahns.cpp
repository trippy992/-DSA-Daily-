// Day 04 — Detect Cycle in a DIRECTED Graph (Kahn's Algorithm) (GeeksforGeeks)
// The trick previewed in day03's header comment, raised to a full solution:
// run Kahn's in-degree peeling and count what got popped. Every node that
// belongs to (or depends on) a cycle never reaches in-degree 0, so it
// never enters the queue. If the peeling consumes ALL nodes, the graph is
// a DAG — if result.size() < V, a cycle exists (and one entry per cycle).
//
// This is the topological sort's refusal to be meaningful on cyclic input,
// turned into a boolean detector.
//
// Time: O(V + E)   Space: O(V + E)

bool isCyclic(int V, vector<vector<int>>& edges) {
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

    return result.size() != V ? 1 : 0;
}
