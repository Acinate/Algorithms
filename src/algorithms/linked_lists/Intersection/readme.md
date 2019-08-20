# Intersection

Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the 
intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact
same node (by reference) as the jth node of the second linked list, then they are intersecting.
 
## Example

Input:

`[3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1], [4 -> 6 -> 7 -> 2 -> 1]`

Output:

`true`

## Solution

### Determining if there's an intersection

How would we detect if two linked lists intersect? One approach would be to use a hash table and just throw all the 
linked lists nodes into there. We would need to be careful to reference the linked lists by their memory location, 
not by their value.

There's an easier way though. Observe that two intersecting linked lists will always have the same last node. 
Therefore, we can just traverse to the end of each linked list and compare the last nodes.

How do we find where the intersection is, though?

### Finding the intersecting node

One thought is that we could traverse backwards throuh each linked list. When the linked lists "split", that's the 
intersection. Of course, you can't really traverse backwards through a singly linked list.

If the linked lists were the same length, you could just traverse through them at the same time. When they collide, 
that's your intersection.

When they're not the same length, we'd like to just "chop off" - or ignore - those excess nodes.

How can we do this? Well, if we know the lengths of the two linked lists, then the difference between those two 
linked lists will tell us how much to chop off.

We can get the lengths at the same time as we get the tails of the linked lists (which we used in the first step to 
determine if there's an intersection).

### Putting it all together

We now have a multistep process.

1. Run through each linked list to get the lengths and the tails.
2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
3. Set two pointers to the start of each linked list.
4. On the longer linked list, advance its pointer by the difference in lengths.
5. Now, traverse on each linked list until the pointers are the same.