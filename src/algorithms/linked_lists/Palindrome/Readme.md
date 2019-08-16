# Palindrome

Implement a function to check if a list is a palindrome

## Example

Input:

`1 -> 2 -> 3 -> 2 -> 1`

Output:

`true`

## Solution

Create another linked list that is the exact reverse of the original linked list. Then iterate through the original 
list comparing each node to that of the reversed linked list, return true if all nodes are the same.

