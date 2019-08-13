# Remove Dups

Write code to remove duplicates from an unsorted linked list.

FOLLOW UP

How would you solve this problem if a temporary buffer is not allowed?

## Example

Input: 
```
1 -> 2 -> 2 -> 1 -> 3 -> 2 -> 5 -> 1 -> 4 -> 5 -> 3
```

Output: 
```
1 -> 2 -> 3 -> 5 -> 4
```



## Solution
In order to remove duplicates from a linked list, we need to be able to track duplicates. A simple hash table will 
work well here.

In the first solution, we simply iterate through the linked list, adding each element to a hash table. When we 
discover a duplicate element, we remove the element and continue iterating. We can do this all in one pass since we 
are using a linked list.

If we don't have a buffer, we can iterate with two pointers: current which iterates through the linked list, and 
runner which checks all subsequent nodes for duplicates.
