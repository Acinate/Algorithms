# Stacks and Queues

### Implementing a Stack

The stack data structure is precisely what it sounds like: a stack of data. In certain types of problems, it can be 
favorable to store data in a stack rather than in an array.

A stack uses LIFO (Last In First Out) ordering. That is, as in a stack of dinner plates, the most recent item added 
to the stack is the first item to be removed.

It uses the following operations:

* pop(): Remove the top item from the stack.
* push(item): Add an item to the top of the stack.
* peek(): Return the top of the stack.
* isEmpty(): Return true if and only if the stack is empty.

Unlike an array, a stack does not offer constant-time access to the ith item. However, it does allow constant-time 
adds and removes, as it doesn't require shifting elements around.

We have provided simple sample code in `Stack` to implement a stack. Note that a stack can also be implemented using a 
linked list, if items were added and removed from the same side.

One case where stacks are often useful is in certain recursive algorithms. Sometimes you need to push temporary data 
onto a stack as you recurse, but then remove them as you backtrack (for example, because the recursive check failed).
A stack offers an intuitive way to do this.
 
A stack can also be used to implement a recursive algorithm iteratively. (This is a good exercise! Take a simple 
recursive algorithm and implement it iteratively.)

### Implementing a Queue

A queue implements FIFO (First In First Out) ordering. As in a line or queue at a ticket stand, items are removed 
from the data structure in the same order that they are added.

It uses the operations:

* add(item): Add an item to the end of the list.
* remove(): Remove the first item in the list.
* peek(): Return the top of the queue.
* isEmpty(): Return true if and only if the queue is empty.

A queue can also be implemented with a linked list. In fact, they are essentially the same thing, as long as items 
are added and removed from opposite sides.

It is especially easy to mess up the updating of the first and last nodes in a queue. Be sure to double check this.

One place where queues are often used is in breadth-first search or in implementing a cache.

In breadth-first search, for example, we used a queue to store a list of the nodes that we need to process. Each time
we process a node, we add its adjacent nodes to the back of the queue. This allows us to process nodes in the order 
in which they are viewed.