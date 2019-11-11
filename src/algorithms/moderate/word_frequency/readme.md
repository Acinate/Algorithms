# Word Frequencies

Design a method to find the frequency of occurrences of any given word in a book. What if we were running this
algorithm multiple times?

## Solution Single Query

In this case, we simply go through the book, word by word, and count the number of times that a word appears. This
will take O(n) time. We know we can't do better than that since we must look at every word in the book.
 
## Solution Repetitive Queries

If we're doing the operation repeatedly, then we can probably afford to take some time and extra memory to do pre
-processing on the book. We can create a hash table which maps from a word to its frequency. The frequency of any
word can be easily looked up in O(1) time.
 
  