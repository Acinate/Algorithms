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

