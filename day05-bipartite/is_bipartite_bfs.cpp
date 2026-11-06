// Day 05 — Check if a Graph is Bipartite (BFS 2-coloring) (GeeksforGeeks)
// Color the graph with two colors while running BFS. A graph is bipartite
// exactly when it can be 2-colored such that no edge joins two nodes of the
// same color — equivalently, an undirected graph is bipartite iff it has no
// odd-length cycle.
//
// Every neighbour of a node must take the OPPOSITE color. If a neighbour is
// already colored and its color matches the current node's, that edge closes
// an odd cycle, so a valid 2-coloring does not exist.
//
// The graph need not be connected, so the BFS is started once from every
// still-uncolored node — otherwise an odd cycle in a separate component
// would go unnoticed.
//
// Time: O(V + E)   Space: O(V + E)

class Solution {
  public:
    bool isBipartite(int V, vector<vector<int>> &edges) {
        // Code here
        vector<int>adj[V];
        // first create the adjacency list

        for(auto edge: edges){
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        vector<int>color(V,-1);
        queue<int>q;

        // the graph can be disconnected, so start a BFS from every uncolored node
        for(int start = 0; start < V; start++){
            if(color[start] != -1) continue;

            // assign color 0 to the start node and push it into the queue
            color[start] = 0;
            q.push(start);

            while(!q.empty()){
                int node = q.front();
                q.pop();

                // Look at its all neibour node
                // if we haven't assigned any color to its neib node, assign opposite color to them
                // if neib color is already assigned, if node and neib color is same, biparite is not possible
                for(int neib: adj[node]){
                    if(color[neib]==-1){
                        color[neib] = (color[node]+1)%2;
                        q.push(neib);
                    }
                    else if(color[neib]==color[node]){
                        return 0;
                    }
                }
            }
        }

        return 1;
    }
};
