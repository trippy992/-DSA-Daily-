# 🧩 DSA Daily

> Daily grind: one (or more) DSA problems solved and committed every day. [Daily problems in C++ and JavaScript — stack-agnostic, grind-agnostic.</br>
> The goal: consistency over intensity.

<div align="center">

![Progress](https://img.shields.io/badge/Problems%20solved-5-00e5ff?style=for-the-badge&labelColor=0d1117)
![Streak](https://img.shields.io/badge/Days%20active-3-ff00cc?style=for-the-badge&labelColor=0d1117)

</div>

## 📒 Progress Log

| Day | Problem | Topic | Solution | Status |
|-----|---------|-------|----------|--------|
| 01 | BFS of Graph | Graphs, Queue | [bfs_of_graph.cpp](day01-bfs-dfs/bfs_of_graph.cpp) | ✅ |
| 01 | DFS of Graph | Graphs, Recursion | [dfs_of_graph.cpp](day01-bfs-dfs/dfs_of_graph.cpp) | ✅ |
| 02 | Detect Cycle in an Undirected Graph | Graphs, DFS + Parent Tracking | [detect_cycle_undirected.cpp](day02-graphs/detect_cycle_undirected.cpp) | ✅ |
| 03 | Topological Sort (DFS) | Graphs, DAG, DFS Post-order | [topological_sort_dfs.cpp](day03-topo-dfs/topological_sort_dfs.cpp) | ✅ |
| 03 | Topological Sort (Kahn's / BFS) | Graphs, DAG, In-degree + Queue | [topological_sort_kahns.cpp](day03-topo-dfs/topological_sort_kahns.cpp) | ✅ |
| 04 | Directed Graph Cycle Detection | Graphs, Kahn's / T.Sort Refusal | [directed_cycle_kahns.cpp](day04-cycle-kahns/directed_cycle_kahns.cpp) | ✅ |

## 📁 Structure

```
DSA-Daily/
├── day01-bfs-dfs/
│   ├── bfs_of_graph.cpp
│   └── dfs_of_graph.cpp
├── day02-graphs/
│   └── detect_cycle_undirected.cpp
├── day03-topo-dfs/
│   ├── topological_sort_dfs.cpp
│   └── topological_sort_kahns.cpp
├── day04-cycle-kahns/
│   └── directed_cycle_kahns.cpp
└── README.md
```

Each `dayNN-topic` folder holds that day's solved problems, one file per problem (or per pattern), with the source platform and approach noted at the top of the file.

## 🔗 The Plan

- 🟢 **Queue:** Graphs → Arrays & Strings → Linked Lists → Trees → DP
- 🟡 **Rule of the repo:** if it got solved, it gets committed. Code + spam-free log.
- 🔴 **No fake commits.** If a day went by without a solve, the log stays honest.
