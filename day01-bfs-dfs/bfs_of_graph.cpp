// Day 01 — BFS of Graph (GeeksforGeeks)
// Level-by-level traversal from node 0 using a queue.

class Solution {
public:
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        // create a queue and visited array of size V
        queue<int> q;
        vector<bool> visited(V, 0);

        // push 0 into the queue and mark it visited
        q.push(0);
        visited[0] = 1;

        vector<int> result;

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            result.push_back(node);

            // enqueue all unvisited neighbours
            for (int neighbour : adj[node]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = 1;
                    q.push(neighbour);
                }
            }
        }
        return result;
    }
};
