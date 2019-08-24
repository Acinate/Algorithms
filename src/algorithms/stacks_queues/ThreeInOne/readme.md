# Three In One

Describe how you could use a single array to implement three stacks.

## Solution

Like many problems, this one somewhat depends on how well we'd like to support these stacks. If we're okay with 
simply allocating a fixed amount of space for each stack, we can do that. This may mean though that one stack runs of
out of space, while the others are nearly empty.

Alternatively, we can be flexible in our space allocation, but this significantly increases the complexity of the 
problem.

### Approach 1: Fixed Division

We can divide the array in three equal parts and allow the individual stack to grow in that limited space. Note: We 
will use the notation "[" to mean inclusive of an end point and "(" to mean exclusive of an end point.

* For stack 1, we will use [0, n/3).
* For stack 2, we will use [n/3, (2n)/3).
* For stack 3, we will use [(2n)/3, n).

If we had additional information about the expected usages of the stacks, then we could modify this algorithm 
accordingly. For example, if we expected Stack 1 to have many more elements than Stack 2, we could allocate more 
space to Stack 1 and less space to Stack 2.