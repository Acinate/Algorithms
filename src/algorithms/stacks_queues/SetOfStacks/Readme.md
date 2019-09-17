# Set Of Stacks

Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would 
likely start a new stack when the previous stack exceeds some threhold. Implement a data structure SetOfStacks that 
mimics this. SetOfStacks should be composed of several stacks and should create a new stak once the previous one 
exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop
() should return the same values as it would if there were just a single stack).

#### Follow Up

Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

## Solution

In this problem, we've been told what our data structure should look like:

```java
class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public void push(int v) { ... }
    public int pop() { ... }
}
```

We know that push() should behave identically to a single stack, which means that we need push() to call push() on 
the last stack in the array of stacks. We have to be a bit careful here though: if the last stack is at capacity, we 
need to create a new stack. Our code should look something like this:

```java
void push(int v) {
    Stack last = getLastStack();
    if (last != null && !last.isFull()) {
        // add to last stack
        last.push(v);
    } else {
        // must create new stack
        Stack stack = new Stack(capacity);
        stack.push(v);
        stacks.add(stack);
    }
}
```

What should pop() do? It should behave similarly to push() in that it should operate on the last stack. If the last 
stack is empty (after popping), then we should remove the stack from the list of stacks.
```java
int pop() {
    Stack last = getLastStack();
    if (last == null) throw new EmptyStackException();
    int v = last.pop();
    if (last.size === 0) stacks.remove(stacks.size() - 1);
    return v;
}
```

#### Follow Up

This is a bit trickier to implement, but we can imagine a "rollover" system. If we pop an element from stack 1, we 
need to remove the bottom of stack 2 and push it onto stack 1. We then need to rollover from stack 3 to stack 2, 
stack 4 to stack 3, etc.

You could make an argument that, rather than "rolling over", we should be okay with some stacks not being at full 
capacity. This would improve the time compleicty (by a fair amount, with a large number of elements), but it might 
get us into tricky situations later on if someone assumes that all stacks (other than the last) operate at full 
capacity. There's no "right answer" here; you should discuss this trade-off with your interviewer.