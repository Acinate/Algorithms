# Queue via Stacks

Implement a MyQueue class which implements a queue using two stacks.

## Solution

Since the major difference between a queue and a stack is the order (first-in first-out vs. last-in first-out), we 
know that weed to modify peek() and pop() to go in reverse order. We can use our second stack to reverse the order of
 the elements (by popping s1 and pushing the elements on to s2). In such an implementation, on each peek() and pop() 
 operation, we would pop everything from s1 onto s2, perform the peek / pop operation, and then push everything back.
 
 This will work, but if two pop / peeks are performed back-to-back, we're needlessly moving elements. We can 
 implement a "lazy" approach where we let the elements sit in s2 until we absolutely must reverse the elements.
 
 In this approach, stackNewest has the newest elements on top and stackOldest has the oldest elements on top. When we
  dequeue an element, we want to remove the oldest element first, and so we dequeue from stackOldest. If stackOldest 
  is empty, then we want to transfer all elements from stackNewst into this stack in reverse order. To insert an 
  element, we push onto stackNewest, since it has the newest elements on top.
  