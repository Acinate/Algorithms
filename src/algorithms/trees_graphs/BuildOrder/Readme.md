# Build Order

You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
project is dependent on the first projects). All of a project's dependencies must be built before the project is
. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.

## Example

**Input**

projects: `a,b,c,d,e,f`

dependencies: `(a,d), (f,b), (b,d), (f,a), (d,c)`

**Output** 

`f, e, a, b, d, c`

## Solution

Visualizing the information as a graph probably works best. Be careful with the direction of the arrows. In the graph
below, an arrow from d to g means that d must be compiled before g. You can also draw them in the opposite direction
, but you need to be consistent and clear about what you mean. Let's draw a fresh example.

## Solution 1

Where do we start? Are there any nodes that we can definitely compile immediately?

Yes. Nodes with no incoming edges can be built immediately since they don't depend on anything. Let's add all such
nodes to the build order. In the earlier example, this means we have an order f,d or (d,f).
 
Once we've done that, it's irrelevant that some nodes are dependent on d and f since d and f have already been built
. We can reflect this new state by removing d and f's outgoing edges.

build order: `f, d`

Next, we know that c, b, and g are free to build since they have no incoming edges. Let's build those and then remove
their outgoing edges.

build order: `f, d, c, b, g`

Project a can be built next, so let's do that and remove its outgoing edges. This leaves just e. We build that next
, giving us a complete build order.

build order: `f, d, c, b, g, a, e`

Did this algorithm work, or did we just get lucky? Let's think about the logic.

1. We first added the nodes with no incoming edges. If the set of projects can be built, there must be some "first
" project, and that project can't have any dependencies. If a project has no dependencies (incoming edges), then we
certainly can't break anything by building it first.

2. We removed all outgoing edges from these roots. This is reasonable. Once those root projects were built, it doesn
't matter if another project depends on them. 
 
3. After that, we found the nodes that now have no incoming edges. Using the same logic from steps 1 and 2, it's okay
if we build these. Now we just repeat the same steps: find the nodes with no dependencies, add them to the build
order, remove their outgoing edges, and repeat.

4. What if there are nodes remaining, but all have dependencies (incoming edges)? This means there's no way to build
the system. We should return an error.

The implementation follows this approach very closely.

Initialization and setup:

1. Build a graph where each project is a node and its outgoing edges represent the projects that depend on it. That
is, if A has an edge to B (a -> B), it means B has a dependency on A and therefore A must be built before B. Each
node also tracks the number of incoming edges.

2. Initialize a buildOrder array. Once we determine a project's build order, we add it to the array. We also continue
to iterate through the array, using a toBeProcessed pointer to point to the next node to be fully processed.

3. Find all the nodes with zero incoming edges and add those to a buildOrder array. Set a toBeProcessed pointer to
 the beginning of the array.
 
 Repeat until toBeProcessed is at the end of the buildOrder:
 
1. Read node at toBeProcessed.

- If node is null, then all remaining nodes have a dependency and we have detected a cycle.

2. For each child of node

- Decrement child.dependencies (the number of incoming edges).
- If child.dependencies is zero, add child to the end of buildOrder.

3. Increment toBeProcessed

## Solution 2

Alternatively, we can use depth-first search (DFS) to find the build path.

Suppose we picked an arbitrary node (say b) and performed a depth-first search on it. When we get to the end of a
path and can't go any further (which will happen at h and e), we know that those terminating nodes can be the last
projects to be built. No projects depend on them.

Now, consider what happens at node a when we return from the DFS of e. We know a's children need to appear after a in
the build order. So, once we return from search a's children (and therefore they have been added), we can choose to
add a to the front of the build order.

Once we return from a, and complete the DFS of b's other children, then everything that must appear after b is in the
list. Add b to the front.

Let's mark these nodes as having been built too, just in case someone else needs to build them.

Now what? We can start with any old node again, doing a DFS on it and then adding the node to the front of the build
queue when the DFS is completed.

In an algorithm like this, we should think about the issue of cycles. There is no possible build order if there is a
cycle. But still, we don't want to get stuck in an infinite loop just because there's no possible solution.

A cycle will happen if, while doing a DFS on a node, we run back into the same path. What we need therefore is a
signal that indicates "I'm still processing this node, so if you see the node again, we have a problem."
 
What we can do for this is to mark each node as a "partial" (or "is visiting") state just before we start the DFS on
it. If we see any node whose state is partial, then we know we have a problem. When we're done with this node's DFS
, we need to update the state.

We also need a state to indicate "I've already processed/built this node" so we don't rebuild the node. Our state
therefore can have three options: COMPLETED, PARTIAL AND BLANK.

 