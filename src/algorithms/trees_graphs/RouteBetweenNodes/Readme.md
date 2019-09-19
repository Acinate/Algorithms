# Route Between Nodes

Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

## Solution

This problem can be solved by just simple graph traversal, such as depth-first search or breadth-first search. We
start with one of the two nodes and, during traversal, check if the other node is found. We should mark any node
found in the course of the algorithm as "already visited" to avoid cycles and repetition of the nodes.

It may be worth discussing with your interviewer the tradeoffs between breadth-first search and depth-first search
for this and other problems. For example, depth-first search is a bit simpler to implement since it can be done with
simple recursion. Breadth-first search can also be useful to find the shortest path, whereas depth-first search may
traverse one adjacent node very deeply before ever going onto the immediate neighbors.