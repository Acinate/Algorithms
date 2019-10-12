# Eight Queens

Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the
same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.

## Solution

We have eight queens which must be lined up on an 8x8 chess board such that none share the same row, column or
diagonal. So, we know that each row and column (and diagonal) must be used exactly once.

Picture the queen that is placed last, which we'll assume is on row 8. (This is an okay assumption to make since the
ordering of placing the queens is irrelevant.) On which cell in row 8 is this queen? There are eight possibilities
, one for each column. 

So if we want to know all the valid ways of arranging 8 queens on an 8x8 chess board, it would be:

```
ways to arrange 8 queens on an 8x8 board =
    ways to arrange 8 queens on an 8x8 board with queen at (7,0) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,1) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,2) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,3) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,4) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,5) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,6) +
    ways to arrange 8 queens on an 8x8 board with queen at (7,7)
```

We can compute each one of these using very similar approach:

```
ways to arrange 8 queens on an 8x8 board with queen at (7, 3) =
    ways to .. with queens at (7, 3) and (6, 0) +
    ways to .. with queens at (7, 3) and (6, 1) +
    ways to .. with queens at (7, 3) and (6, 2) +
    ways to .. with queens at (7, 3) and (6, 4) +
    ways to .. with queens at (7, 3) and (6, 5) +
    ways to .. with queens at (7, 3) and (6, 6) +
    ways to .. with queens at (7, 3) and (6, 7)
```

Note that we don't need to consider combinations with queens at (7, 3) and (6, 3), since this is a violation of the
requirement that every queen is in its own row, column and diagonal.