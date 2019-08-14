# Delete Middle Node

Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily 
the exact middle) of a singly linked list, given only access to that node.

## Example

Input

`a -> b -> c -> d -> e -> f`

Output

Nothing is returned, but the new linked list looks like:

`a -> b -> d -> e -> f`


## Solution

We start by iterating through the list one time to get the length of the list. Once we have the length, we calculate 
the middle of this list by dividing the length by 2. We iterate through the list again keeping count of how many 
nodes we've passed. We we reach the nth node calcuated by dividing length by 2, we delete the node by setting the 
previous value to the next value.

This algorithm takes O(n) time and O(1) space.