# Paint Fill

Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen
(represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the
color changes from the original color.

## Solution

First, let's visualize how this method works. When we call paintFill (i.e., "click" paint fill in the image editing
application) on, say, a green pixel, we want to "bleed" outwards. Pixel by pixel, we expand outwards by calling
paintFill on the surrounding pixel. When we hit a pixel that is not green, we stop.

 