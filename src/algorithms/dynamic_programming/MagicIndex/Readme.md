# Magic Index

A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct
integers, write a method to find a magic index, if one exists, in Array A.

Immediately, the brute force solution should jump to mind--and there's no shame in mentioning it. We simply iterate
through the array, looking for an element which matches this conditon.
 
Given that the array is sorted, though, it's very likely that we're supposed to use this condition.

We may recognize that this problem sounds a lot like the classic binary search problem. Leveraging the Pattern
Matching approach for generating algorithms, how might we apply binary search here?

In binary search, we find an element k by comparing it to the middle element, x, and determining if k would land on
the left or right side of x.

Building off this approach, is there a way that we can look at the middle element to determine where a magic index
might be? We can use binary search to navigate through this sorted array of distinct elements. 