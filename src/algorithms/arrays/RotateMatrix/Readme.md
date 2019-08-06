# Rotate Matrix
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the 
image by 90 degrees. Can you do this in place?

## Example
Input:      

```
abc
abc
abc
```

Output:     

```
aaa
bbb
ccc
```
            

## Solution
How do we perform this four-way edge swap? One option is to copy the top edge to an array, and then move the left to 
the top, the bottom to the left, and so on. This requires O(N) memory, which is actually unnecessary.

A better way to do this is to implement the swap index by index. In this case, we do the following:

```
for i = 0 to n
temp = top[i]
top[i] = left[i]
left[i] = bottom[i]
bottom[i] = right[i]
right[i] = temp
```

We preform such a swap on each layer, starting from the outermost layer and working our way inwards. (Alternatively, 
we could start from the inner layer and work outwards.)

This algorithm is O(N^2), which is the best we can do since any algorithm must touch all N^2 elements.