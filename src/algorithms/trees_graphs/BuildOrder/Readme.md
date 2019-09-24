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

The code below implements this algorithm