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