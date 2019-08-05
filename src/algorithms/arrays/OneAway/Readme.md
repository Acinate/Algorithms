#One Away
There are three types of edits that can be preformed on strings: insert a character, remove a character, or replace a
 character. Given two strings, write a function to check if they are one edit (or zero edits) away.

## Example
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false

## Solution
This is one of those problems where it's helpful to think about the "meaning" of each of these operations. What does 
it mean for two strings to be one insertion, replacement, or removal away from each other?

* **Replacement:** Consider two strings, such as bale and pale, that are oe replacement away. Yes, that does mean 
that you could replace a character in bale to make pale. But more precisely, it means that they are different only in
 place.
 
* **Insertion:** The strings apple and aple are one insertion away. This means that if you compared the strings, they
 would be identical--except for a shift at some point in the strings.
 
* **Removal:** The strings apple and aple are also one removal away, since removal is just the inverse of insertion.

We can go ahead and implement this algorithm now. We'll merge the insertion and removal check into one step, and 
check the replacement step separately.