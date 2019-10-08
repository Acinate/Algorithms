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

#### Approach 2: Building from permutations of all n-1 character substrings.

Base Case: single-character strings

The only permutation of a1 is the string a1. So:

P(a1) = a1

Case: two-character strings

P(a1a2) = a1a2 and a2a1.
P(a2a3) = a2a3 and a3a2.
P(a1a3) = a1a3 and a3a1.

Case: three-character strings

Here is where the cases get more interesting. How can we generate all permutations of three character strings, such
as a1a2a3, given the permutations of two-character strings?
 
Well, in essence, we just need to "try" each character as the first character and then append the permutations.

P(a1a2a3) = {a1 + P(a2a3)} + {a2 + P(a1a3)} + {a3 + P(a1a2)}
    
{a1 + P(a2a3)} -> a1a2a3, a1a3a2
{a2 + P(a1a3)} -> a2a1a3, a2a3a1
{a3 + P(a1a2)} -> a3a1a2, a3a2a1

Now that we can generate all permutations of three-character strings, we can use this tot generate permutations of
four-character strings.
 
P(a1a2a3a4) = {a1 + P(a2a3a4)} + {a2 + P(a1a3a4)} + {a3 + P(a1a2a4)} + {a4 + P(a1a2a3)}
