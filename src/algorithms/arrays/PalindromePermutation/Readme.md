# Palindrome Permutation
Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase 
that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to
 be limited to just dictionary words.

## Example
Input:      Tact Coa
Output:     True (permutations: "taco cat", "atco cta", etc.)

## Solution
Implementing this algorithm is fairly straightforward. We use a hash table to count how many times each character 
appears. Then, we iterate through the hash table and ensure that no more than one character has an odd count.