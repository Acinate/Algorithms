# First Common Ancestor

Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing
additional nodes in a data structure. NOTE: this is not necessarily a binary search tree.

## Solution

If this were a binary search tree, we could modify the find operation for the two nodes and see where the paths
diverge. Unfortunately, this is not a binary search tree, so we must try other approaches. Let's assume we're
looking for the common ancestor of nodes p and q. One question to ask here is if each node in our tree has a link
to its parents.

### Solution #1: With Links to Parents

If each node has a link to its parent, we could trace p and q's paths up until they intersect. This is essentially
the same problem as question 2.7 which find the intersection of two linked lists. The "linked list" in this case is
the path from each node up to the root.

### Solution #2: With Links to Parents (Better Worst-Case Runtime)

Similar to the earlier approach, we could trace p's path upwards and check if any of the nodes cover q. The first
node that covers q (we already know that every node on this path will cover p) must be the first common ancestor.
 
Observe that we don't need to re-check the entire subtree. As we move from a node x to its parent y, all the nodes
under x have already been checking for q. Therefore, we only need to check the new nodes "uncovered", which will be
the nodes under x's sibling.

For example, suppose we're looking for the first common ancestor of node p = 7 and node q = 17. When we go to p
.parent (5), we uncover the subtree rooted at 3. We therefore need to search this subtree for q. Next, we go to node
1-, uncovering the subtree rooted at 15. We check this subtree for node 17 and voila there it is.
 
To implement this, we can just traverse upwards from p, storing the parent and the sibling nodes in a variable. (The
sibling node is always a child of parent and refers to the newly uncovered subtree.) At each iteration, sibling gets
set to the old parent's sibling node and parent gets set to parent.parent.
  
   