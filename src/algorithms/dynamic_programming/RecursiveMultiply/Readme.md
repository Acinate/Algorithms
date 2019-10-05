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

Can we do better? Yes.

## Solution #2

If we observe how the recursion operates, we'll notice that we have duplicated work. Consider this example:

```java
    minProduct(17, 23)
        minProduct(8, 23)
            minProduct(4, 23) * 2
                ...
  + minProduct(9, 23)
        minProduct(4, 23)
            ...
      + minProduct(5, 23)
            ...
```

The second call to minProduct(4, 23) is unaware of the prior call, and so it repeats the same work. We should cache
these results.

We can still make this a bit faster.

## Solution #3

One thing we might notice when we look at thid code is that a call to minProduct on an even number is much faster
than one on an odd number. For example, if we call minProduct(30, 35), then we'll just do minProduct(15, 35) and
double the result. However, if we do minProduct(31, 35), then we'll need to call minProduct(15, 35) and minProduct
(16, 35).

This is unecessary. Instead, we can do:

``minProduct(31, 35) = 2 * minProduct(15, 35) + 35``

After all, since 31 = 2*15+1, then 31x35 = 2*15*35+35.

The logic in this final solution is that, on even numbers, we just divide small by 2 and double the result of the
recursive call. On odd numbers, we do the same, but then we also add bigger to this result.

In doing so, we have an unexpected "win". Our minProduct function just recurses straight downwards, with increasingly
small numbers each time. It will never repeat the same cell, so there's no need to cache any information.