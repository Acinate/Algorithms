# Coins

Given an infinite number of quarters (25 cents), dimes (10 cents), nickles (5 cents), and pennies (1 cent), write
code to calculate the number of ways of representing n cents.

## Solution

This is a recursive problem, so let's figure out how to compute makeChange(n) using prior solutions (i.e., sub
-problems).

Let's say n = 100. We want to compute the number of ways of making change for 100 cents. What is the relationship
between this problem and its sub-problems?
 
We know that making change for 100 cents will involve either 0, 1, 2, 3, or 4 quarters. So:

```
makeChange(100) = makeChange(100 using 0 quarters) +
                  makeChange(100 using 1 quarter)  +
                  makeChange(100 using 2 quarters) +
                  makeChange(100 using 3 quarters) +
                  makeChange(100 using 4 quarters) +
                  1
```

Note that the final statement from above, makeChange(100 using 4 quarters), equals 1. We call this "fully reduced."

Now what? We've used up all our quarters, so now we can start applying our next biggest denomination: dimes.

Our approach for quarters applies to dimes as well, but we apply this for each of the four of five parts of the above
statement. So, for the first part, we get the following statements.

```
makeChange(100 using 0 quarters) = makeChange(100 using 0 quarters, 0 dimes) +
                                   makeChange(100 using 0 quarters, 1 dime)  +
                                   makeChange(100 using 0 quarters, 2 dimes) +
                                   ...
                                   makeChange(100 using 0 quarters, 10 dimes)

makeChange(75 using 0 quarters) = makeChange(75 using 0 quarters, 0 dimes) +
                                   makeChange(75 using 0 quarters, 1 dime)  +
                                   makeChange(75 using 0 quarters, 2 dimes) +
                                   ...
                                   makeChange(75 using 0 quarters, 7 dimes)

makeChange(50 using 0 quarters) = makeChange(50 using 0 quarters, 0 dimes) +
                                   makeChange(50 using 0 quarters, 1 dime)  +
                                   makeChange(50 using 0 quarters, 2 dimes) +
                                   ...
                                   makeChange(50 using 0 quarters, 5 dimes)

makeChange(25 using 0 quarters) = makeChange(25 using 0 quarters, 0 dimes) +
                                   makeChange(25 using 0 quarters, 1 dime)  +
                                   makeChange(25 using 0 quarters, 2 dimes)
```

Each one of these, in turn, expands out once we start applying nickels. We end up with a tree-like recursive
structure where each call expands out to four or more calls.

The base case of our recursion is the fully reduced statement. For example, makeChange(50 using 0 quarters, 5 dimes
) is fully reduced to 1, since 5 dimes equals 50 cents.

To make this algorithm even more efficient, we can store previous computed values. We'll need to store a mapping from
each pair (amount, index) to the precomputed result.