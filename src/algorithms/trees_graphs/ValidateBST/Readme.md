# Validate BST

Implement a function to check if a binary tree is a binary search tree.

## Solution

We can implement this solution in two different ways. The first leverages the in-order traversal, and the second
builds off the property that left <= current < right.

### Solution #1: In-Order Traversal (Bad solution)

Our first thought might be to do an in-order traversal, copy the elements to an array, and then check to see if the
array is sorted. This solution takes up a bit of extra memory, but it works-mostly.
 
#### ** Conflict **
 
The only problem is that it can't handle duplicate values in the tree properly. For example, the algorithm cannot
distinguish between a tree that has a node with a right child same as its parent, since they have the same in-order
 traversal.
 
### Solution #2: The Min / Max Solution

In the second solution, we leverage the definition of the binary search tree.

What does it mean for a tree to be a binary search tree? We know whats it must, of course, satisfy the condition
`left.data <= current.data < right.data` for each node, but this isn't quite sufficient. Consider the following small
 tree:
 
Although each node is bigger than its left node and smaller than its right node, this is clearly not a binary search
tree since 25 is in the wrong place.
  
More precisely, the condition is that all lfet nodes must be less than or equal to the current node, which must be
less than all the right nodes.

Using this thought, we can approach the problem by passing down the min and max values. As we iterate through the
tree, we verify against progressively narrower ranges.
 
We start with a range of `min = NULL, max = NULL`, which the root obviously meets. (NULL indicates that there is no
mix or max.) We then branch right, checking that the nodes are within the range (min = 20, max = NULL).
 
We proceed through the tree with this new approach. When we branch left, the max gets updated. When we branch right
, the min gets updated. If anything fails these checks, we stop and return false.

The time complexity for this solution is O(N), where N is the number of nodes in the tree. We can prove that this is
the best we can do, since any algorithm must touch all N nodes.
 
Due to the use of recursion, the space complexity is O(log N) on a balanced tree. There are up to O(log N) recursive
calls on the stack since we may recurse up to the depth of the tree.  