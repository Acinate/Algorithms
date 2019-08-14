# Return Kth to Last

Implement an algorithm to find the kth to last element of a singly linked list.

## Example

Linked List:

`1 -> 4 -> 2 -> 3 -> 5`

Input: 

`K = 1`

`K = 0`

Output: 

`3`

`5`

## Solution

We start by counting the length of the list. We use a simple while loop and integer to keep count of the number of 
linked nodes. After getting the length we perform another pass through the list with a different counter variable. As
 we pass through the list we subtract the length of the list from the current count. If the difference equals k we 
 return the node's data. 
 
This algorithm takes O(n) time and O(1) space.