# Zero Matrix

Write an algorithm such that if an element in a MxN matrix is 0, its entire row and column are set to 0.

## Example

Input

```
1 2 3 4
1 0 3 4
0 2 3 4
1 2 3 4
```

Output

```
0 0 3 4
0 0 0 0
0 0 3 4
0 0 3 4
```

## Solution

Create two integer arrays made up of zeros. Inside a double for loop, check if element is a 0, if so save the x index
 in our x array and y index in our y array. Do another pass through the array, if the current element's x matches our
  x array to one, then nullify the column.