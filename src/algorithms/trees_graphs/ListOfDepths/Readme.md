# List of Depths

Given a binary tree, design an algorithm which creates linked list of all the nodes at each depth (e.g., if you have
a tree with depth D, you'll have D linked lists).
 
## Solution
Though we might think at first glace that this problem requires a level-by-level traversal, this isn't actually
necessary. We can traverse the graph any way that we'd like, provided we know which level we're on as we do so.

We can implement a simple modification of the pre-order traversal algorithm, where we pass in level + 1 to the next
recursive call. `createLevelLinkedListDFT` implements this using depth-first search.

