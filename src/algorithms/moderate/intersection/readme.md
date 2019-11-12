# Intersection

Given two straight line segments (represented as a start point and an end point), compute the point of intersection
, if any.

## Solution

We first need to think about what it means for two line segments to intersect.

For two infinite lines to intersect, they only have to have different slopes. If they the same slope, then they must
be the exact same line (same y-intercept). That is:
 
```aidl
    slope 1 != slope 2
    OR
    slope 1 == slope 2 AND intersect 1 == intersect 2
```

For two straight lines to intersect, the condition above must be true, plus the point of intersection must be within
the ranges of each line segment.

```aidl
    extended infinite segments intersect
    AND
    intersection is within line segment 1 (x and y coordinates)
    AND
    intersection is within line segment 2 (x any y coordinates)
```

What if the two segments represent the same infinite line? In this case, we have to ensure that some portion of their
segments overlap. If we order the line segments by their x locations (start is before end, point 1 is before point 2
), then an intersection occurs only if:

```aidl
    Assume:
        start1.x < start2.x && start1.x < end1.x && start2.x < end2.x
    Then intersection occurs if:
        start2 is between start1 and end1
```

We can now go ahead and implement this algorithm.