# Paths with Sum

You are given a binary tree in which each node contains an integer value (which might be positive or negative
). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end
at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

## Solution

Let's pick a potential sum--say, 8--and then draw a binary tree based on this. This tree intentionally has a number
of paths with this sum.

One option is the brute force approach.

### Solution #1: Brute Force

In the brute force approach, we just look at all the possible paths. To do this, we traverse to each node. At each
node, we recursively try all paths downwards, tracking the sum as we go. As soon as we hit our target sum, we
increment the total.

The time complexity of this algorithm is O(N log N)

### Solution #2: Optimized

In analyzing the last solution, we may realize that we repeat some work. For a path such as 10 -> 5 -> 3 -> 2, we
traverse this path (or parts of it) repeatedly. We do it when we start with node 10, then when we go to node 5
(looking at 5, then 3, then -2), then when we go to node 3, and then finally when we go to node -2. Ideally, we'd
like to reuse this work.

Let's isolate a given path and treat it as just an array. Consider a (hypothetical, extended) path like:

What we're really saying then is: How many contiguous subsequences in this array sum to a target sum such as 8? In
other words, for each y, we're trying to find the x values below. (Or, more accurately, the number of x values below.)
 
If each value knows its running sum (the sum of values from s through itself), then we can find this pretty easily
. We just need to leverage this simple equation. runningSum = runningSum - targetSum. We then look for the values of
x where this is true.

Since we're just looking for the number of paths, we can use a hash table. As we iterate through the array, build a
hash table that maps from a runningSum to the number of times we've seen that sum. Then, for each y, look up running
Sum - targetSum in the hash table. The value in the hash table will tell you the number of paths with sum targetSum
that end at y.

The value of runningSum is 24. If targetSum is 8, then we'd look up 16 in the hash table. This would have a value of
2 (originating from index 2 and index 5). As we can see above, indexes 3 through 7 and indexes 6 through 7 have sums
of 8.
  
Now that we've settled the algorithm for an array, let's review this on a tree. We take a similar approach.

We traverse through the tree using depth-first search. As we visit each node:

1. Track its runningSum. We'll take this in as a parameter and immediately increment it by node.value.
2. Look up runningSum - targetSum in the hash table. The value there indicates the total number. Set totalPaths to
 this value.
3. If runningSum == targetSum, then there's one additional path that starts at the root. Increment totalPaths.
4. Add runningSum to the hash table (incrementing the values if it's already there).
5. Recurse left and right, counting the number of paths with sum targetSum.
6. After we're done recursing left and right, decrement the value of runningSum in the hash table. This is
essentially backing out of our work; it reverses the changes to the hash table so that other nodes don't use it
(since we're now done with node).

The runtime for this algorithm is O(N). 