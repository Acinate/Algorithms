# URLify

Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at 
the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If 
implementing in Java, please use a character array so that you can perform this operation in place.)

## Example
Input:      "Mr John Smith     ", 13
Output:     "Mr%20John%20Smith"

## Solution
The algorithm employs a two-scan approach. In the first scan, we count the number of spaces. By tripling this number,
 we can compute how many extra characters we will have in the final string. In the second pass, which is done in 
 reverse order, we actually edit the string. When we see a space, we replace it with %20. If there is no space, then 
 we copy the original character.