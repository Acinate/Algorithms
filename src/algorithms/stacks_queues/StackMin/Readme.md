# Stack Min

How would you design a stack which, in addition to push and pop, has a function min which returns the minimum 
element? Push, pop and min should all operate in O(1) time.

## Solution

If we kept track of the minimum at each state, we would be able to easily know the minimum. We can do this by having 
each node record what the minimum beneath itself is. Then, to find the min, you just look at twhat the top element 
thinks is the min.