# CheckPermutation

Given two strings, write a method to decide if one is a permutation of the other.


## Solution
Like in many questions, we should confirm some details with our interviewer. We should understand if the permutation
comparison is case sensitive. That is: is God a permutation of dog? Additionally, we should ask if whitespace is
significant. We will assume for this problem that the comparison is case sensitive and whitespace is significant. So
"god     " is different than "dog".

Observe first that strings of different lengths cannot be permutations of each other. There are two easy ways to 
solve this problem, both of which use this optimization.

## Solution 1: Sort the strings
If the two strings are permutations, then we know they have the same characters, but in different orders. Therefore, 
sorting the strings will put the characters from two permutations in the same order. We just need to compare the 
sorted versions of the strings.

## Solution 2: Check if the two strings have identical character counts
We can also use the definition of a permutation--two words with the same character counts--to implement this 
algorithm. We create an array (lines 4 - 7) that operates somewhat like a hash table, mapping each character to its 
frequency. We increment through the first string, then decrement through the second string. If the strings are 
permutations, then the array will be all zeroes at the end.

We can terminate early if a value ever turns negative (once negative, the value will stay negative and therefore 
non-zero). If we don't terminate early, then the array must be all zeros. This is because the strings are the same 
lengths and we incremented the same number of times we decremented. The array cannot have any positive values if it 
doesn't have any negative values.