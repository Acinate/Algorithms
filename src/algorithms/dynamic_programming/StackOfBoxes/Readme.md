# Stack of Boxes

You have a stock of n boxes, with widths w, heights h, and depths d. The boxes cannot be rotated and can only be
stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height
, and depth. Implement a method to compute the height of the tallest possible stack. The height of a stack is the
sum of the heights of each box.

## Solution

To tackle this problem, we need to recognize the relationship between the different sub-problems.

### Solution #1

Imagine we had the following boxes: b1, b2, ..., bn. The biggest stack that we can build with all the boxes equals
the max of (biggest stack with bottom b1, biggest stack with bottom b2, ..., biggest stack with bottom bn). That is
, if we experimented with each box as a bottom and built the biggest stack possible with each, we would find the
biggest stack possible.


But, how would we find the biggest stack with a particular bottom? Essentially the same way. We experiment with
different boxes for the second level, and so on for each level.

Of course, we only experiment with valid boxes. If bs is bigger than b1, then there's no point in trying to build a
stack that looks like {b1, bs, ...}. We already know b1 can't be below bs.

We can perform a small optimization here. The requirements of this problem stipulate that the lower boxes must be
strictly greater than the higher boxes in all dimensions. Therefore, if we sort (descending order) the boxes on a
dimension––any dimension––then we know we don't have to look backwards in the list. The box b1 cannot be on top of
box bs, since its height (or whatever dimension we sorted on) is greater than bs's height.

