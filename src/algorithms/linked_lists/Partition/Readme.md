# Partition

Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
 than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than 
 x (see below). The partition element x can appear anywhere in the "right partition"; It does not need to appear 
 between the left and right partitions. 
 
 ## Example
 
 Input:
 
 `3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]`
 
 Output:
 
 `3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8`
 
 ## Solution
 
We can create two different linked lists: one for elements less than x, and one for elements greater than or equal to x.

We iterate through the linked list, inserting elements into our before list or our after list. Once we reach the end 
of the linked list and have completed this splitting, we merge the two lists.

This approach is mostly "stable" in that elements stay in their original order, other than the necessary movement 
around the partition.