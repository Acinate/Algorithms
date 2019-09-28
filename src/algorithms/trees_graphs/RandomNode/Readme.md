# Random Node

You are implementing a binary search tree class from scratch, which, in addition to insert, find, and delete, has a
method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen
. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
 
## Solution

We're going to explore many solutions until we get to an optimal one that works.

One thing we should realize here is that the question was phrased in a very interesting way. The interviewer did not
simply say, "Design an algorithm to return a random node from a binary tree." We were told that this is a class that
we're building from scratch. There is a reason the question was phrased that way. We probably need access to some
part of the internals of the data structure.

### Solution #1

Rather than just continuing to brainstorm new solutions, let's see if we can fix some of the issues in the previous
solutions. To do so, we must diagnose--deely--the root problem in a solution. 

Let's look at our previous option. It fails because the probabilities aren't evenly distributed accross the options
. Can we fix that while keeping the basic algorithm the same?

We can start with the root. With what probability should we return the root? Since we have N nodes, we must return
the root node with 1/N probability. (In fact, we must return each node with 1/N probability. After all, we have N
nodes and each must have equal probability. The total must be 1 (100%), therefore each must have 1/N probability.)
  
We've resolved the issue with the root. Now what about the rest of the problem? With what probability should we
traverse left versus right? It's not 50/50. Even in a balanced tree, the number of nodes on each side might not be
equal. If we have more nodes on the left than the right, then we need to go left more often.

One way to think about it is that the odds of picking something--anything--from the left must be the sum of each
individual probability. Since each node must have probability 1/N, the odds of picking something from the left must
have probability LEFT_SIZE * 1/N. This should therefore be the odds of going left.
  
Likewise, the odds of going right should be RIGHT_SIZE * 1/N.
  
This means that each node must know the size of the nodes on the left and the size of the nodes on the right
. Fortunately, our interviewer has told us that we're building this tree class from scratch. It's easy to keep track
of this size information on inserts and deletes. We can just store a size variable in each node. Increment size on
inserts and decrement it on deletes.  