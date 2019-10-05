# Recursive Multiply

Write a recursive function to multiply two positive integers without using the * operator (or / operator). You can
use addition, subtraction, and bit shifting, but you should minimize the number of those operations.

## Solution

Let's pause for a moment and think about what it means to do multiplication.

> This is a good approach for a lot of interview questions. It's often useful to think aboput what it really means to
> do something, even when it's pretty obvious.

We can think about multiplying 8x7 as doing 8+8+8+8+8+8+8 (or adding 7 eight times). We can also think about it as
the number of squares in an 8x7 grid.

## Solution #1

How would we count the number of squares in this grid? We could just count each cell. That's pretty slow, though.

Alternatively, we could count half the squares and then double it (by adding this count to itself). To count half the
squares, we repeat the same process.

Of course, this "doubling" only works if the number is in fact even, When it's not even, we need to do the counting
/summing from scratch.