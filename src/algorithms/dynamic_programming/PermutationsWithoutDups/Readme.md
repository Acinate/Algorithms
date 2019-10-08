# Permutations without Dups

Write a method to compute all permutations of a string of unique characters.

## Solution

Like in many recursive problems, the Base Case and Build approach will be useful. Assume we have a string S
represented by the characters ```a1, a2, ..., an```.
 
#### Approach 1: Build from permutations of first n-1 characters.

Base Case: permutations of first character substring

The only permutation of a1 is the string a1. So:

```P(a1) = a1```

Case: permutations of a1, a2

```p(a1, a2) = [a1, a2], [a2, a1]```

Case: permutations of a1, a2, a3

```P(a1, a2, a3) = [a1, a2, a3], [a1, a3, a2], [a2, a1, a3], [a2, a3, a1], [a3, a1, a2], [a3, a2, a1]```

Case: permutations of a1, a2, a3, a4

This is the first interesting case. How can we generate permutations of a1a2a3a4 from a1a2a3?

Each permutation of a1a2a3a4 represents an ordering of a1a2a3. For example a2a4a1a3 represents the order a2a1a3.

Therefore, if we took all the permutations of a1a2a3 and added a4 into all possible locations, we would get all
permutations of a1a2a3a4.
 
```
[a1,a2,a3] -> [a4,a1,a2,a3], [a1,a4,a2,a3], [a1,a2,a4,a3], [a1,a2,a3,a4]
[a1,a3,a2] -> [a4,a1,a3,a2], [a1,a4,a3,a2], [a1,a3,a4,a2], [a1,a3,a2,a4]
[a3,a1,a2] -> [a4,a3,a1,a2], [a3,a4,a1,a2], [a3,a1,a4,a2], [a3,a1,a2,a4]
[a2,a1,a3] -> [a4,a2,a1,a3], [a2,a4,a1,a3], [a2,a1,a4,a3], [a2,a1,a3,a4]
[a2,a3,a1] -> [a4,a2,a3,a1], [a2,a4,a3,a1], [a2,a3,a4,a1], [a2,a3,a1,a4]
[a3,a2,a1] -> [a4,a3,a2,a1], [a3,a4,a2,a1], [a3,a2,a4,a1], [a3,a2,a1,a4]
```