# Parens

Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n pairs of parentheses.

#### Example

```
Input: 3
Output: ((())), (()()), (())(), ()(()), ()()()
```

## Solution

Our first though here might be to apply a recursive approach where we build the solution for f(n) by adding pairs of
parentheses to f(n-1). That's certainly a good instinct.

Let's consider the solution for n = 3:

``(()())    ((()))      ()(())      (())()      ()()()``

How might we build this from n = 2?

``(())      ()()``

We can do this by inserting a pair of parentheses inside every existing pair of parenthesis, as well as one at the
beginning of the string. Any other places that we could insert parenthese, such as at the end of the string, would
reduce to the earlier cases.

So, we have the following:
```
(()) -> (()()) /* inserted pair after 1st left paren */
     -> ((())) /* inserted pair after 2nd left paren */
     -> ()(()) /* inserted pair at beginning of string */
()() -> (())() /* inserted pair after 1st left paren */
     -> ()(()) /* inserted pair after 2nd left paren */
     -> ()()() /* inserted pair at beginning of string */
```

But wait––we have some duplicate pairs listed. The string `()(())` is listed twice.

If we're going to apply this approach, we'll need to check for duplicate values before adding a string to our list.

