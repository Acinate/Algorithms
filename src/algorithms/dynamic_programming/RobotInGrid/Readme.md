# Robot In A Grid

Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two
directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an
algorithm to find a path for the robot from the top left to the bottom right.

## Solution

If we picture this grid, the only way to move to spot (r,c) is by moving to one of the adjacent spots: (r-1,c) or (r
,c-1). So, we need to find a path to either (r-1,c) or (r,c-1).

How do we find a path to those spots? To find a path to (r-1,c) or (r,c-1), we need to move to one of its adjacent
cells. So, we need to find a path to a spot adjacent to (r-1,c), which are coordinates (r-2,c) and (r-1,c-1), or a
spot adjacent to (r,c-1), which are spots (r-1,c-1) and (r,c-2). Observe that we list the point (r-1,c-1) twice; we
'll discuss that issue later.

> Tip: A lot of people use the variable names x and y when dealing with two-dimensional arrays. This can actually
> cause some bugs. People tend to think about x as the first coordinate in the matrix and y as the second coordinate
> (e.g., matrix[x][y]). But, this isn't really correct. The first coordinate is usually though of as the row number
>, which is in fact the y value (it goes vertically!). You should write matrix[y][x]. Or, just make your life easier
> by using r (row) and c (column) instead.

So then, to find a path from the origin, we just work backwards like this. Starting from the last cell, we try to
find a path to each of its adjacent cells.