# IsUnique

Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?


## Solution
You should first ask your interviewer if the string is an ASCII string or a Unicode string. We'll assume for simplicity the character set is ASCII.

One solution is to create an array of boolean values, where the flag at index i indicates whether character i in the alphabet is contained in the string. The second time you see this character you can immediately return false.

We can also immediately return false if the string length exceeds the number of unique characters in the alphabet. After all, you can't form a string of 280 unique characters out of a 128-character alphabet.
