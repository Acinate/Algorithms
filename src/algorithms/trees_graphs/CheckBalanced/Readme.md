# Check balanced

In this question, we've been fortunate enough to be told exactly what balanced means: that for each node, the two
subtrees differ in height by no more than one. We can implement a solution based on this definition. We can simply
recurse through the entire tree, and for each node, compute the heights of each subtree.

Although this works, it's not very efficient. On each node, we recurse through its entire subtree. This means that
getHeight is called repeatedly on the same nodes. The algorithm is O(N log N) since each node is "touched" once per
node above it.

We need to cut out some of the calls to getHeight.

If we inspect this method, we may notice that getHeight could actually check if the tree is balanced at the same time
as it's checking heights. What do we do when we discover that the subtree isn't balanced? Just return an error code.

This improved algorithm works by checking the height of each subtree as we recurse down from the roo. On each node
, we recursively get the heights of the left and right subtrees through the checkHeight method. If the subtree is
balanced, then checkHeight will return the actual height of the subtree. If the subtree is not balanced, then
checkHeight will return an error code. We will immediately break and return an error code from the current call.

*Note*: What do we use for an error code? The height of a null tree is generally defined to be -1, so that's not a
great idea for an error code. Instead, we'll use Integer.MIN_VALUE.
 
