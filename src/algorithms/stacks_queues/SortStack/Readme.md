# Sort Stack

Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
 stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the
  following operations: push, pop, peek, and isEmpty.
  
## Solution

One approach is to implement a rudimentary sorting algorithm. We search through the entire stack to find the minimum
element and then push that onto a new stack. Then, we find the new minimum element and push that. This will actually
require a total of three stacks. s1 is the original stack, s2 is the final sorted stack, and s3 acts as a buffer
during our searching of s1. To search s1 for each minimum, we need to pop elements from s1 and push them onto the
buffer, s3.
    
Unfortunately, this requires two additional stacks, and we can only use one. Can we do better? Yes.

Rather than searching for the minimum repeatedly, we can sort s1 by inserting each element from s1 in order into s2
. How would this work?

Imagine we have the following stacks, where s2 is "sorted" and s1 is not:

| s1  | s2  |
|:---:|:---:|
|     |  12 |
|  5  |  8  |
| 10  |  3  |
|  7  |  1  |

When we pop 5 from s1, we need to find the right place in s2 to insert this number. In this case, the correct place
is on s2 just above 3. How do we get it there? We can do this by popping 5 from s1 and holding it in a temporary
variable. Then, we move 12 and 8 over to s1 (by popping them from s2 and pushing them onto s1) and then push 5 onto
s2.

#### Step 1:

| s1  | s2  |
|:---:|:---:|
|     |  12 |
|    |  8  |
| 10  |  3  |
|  7  |  1  |

tmp = 5;

#### Step 2:

| s1  | s2  |
|:---:|:---:|
|  8  |     |
| 12  |     |
| 10  |  3  |
|  7  |  1  |

tmp = 5;

#### Step 3:

| s1  | s2  |
|:---:|:---:|
|  8  |     |
| 12  |  5  |
| 10  |  3  |
|  7  |  1  |

Note that 8 and 12 are still in s1 and that's okay! We just repeat the same steps for those two numbers as we did for
5, each time popping off the top of s1 and putting it into the "right place" on s2. (Of course, since 8 and 12 were
moved from s2 to s1 precisely because they were larger than 5, the "right place" for these elements will be right
on top of 5. We won't need to muck around with s2's other elements, and the inside of the below while loop will
not be run when tmp is 8 or 12.)

This algorithm is O(N^2) time and O(N) space.

If we were allowed to use unlimited stacks, we could implement a modified quicksort or mergesort.

With the mergesort solution, we would create two extra stacks and divide the stack into two parts. We would
recursively sort each stack, and then merge them back together in sorted order into the original stack. Note that
this would require the creation of two additional stacks per level of recursion.

With the quicksort solution, we would create two additional stacks and divide the stack into the two stacks based on
a pivot element. The two stacks would be recursively sorted, and then merged back together into the original stack
. Like the earlier solution, this one involves creating two additional stacks per level of recursion.