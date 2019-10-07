# Towers of Hanoi

In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto
any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e, each disk sits on
top of an even larger one). You have the following constraints:

1. Only one disk can be moved at a time
2. A disk is slid off the top of one tower onto another tower.
3. A disk cannot be placed on top of a smaller disk.

Write a program to move the disks from the first tower to the last using Stacks.

## Solution

This problem sounds like a good candidate for the Base Case and Build approach.

Let's start with the smallest possible example: n = 1;

Case n = 1. Can we move Disk 1 from Tower 1 to Tower 3? Yes.

1. Move Disk 1 from Tower 1 to Tower 2

2. Move Disk 2 from Tower 1 to Tower 3

3. Move Disk 1 from Tower 2 to Tower 3

Note how in the above steps, Tower 2 acts as a buffer, holding a disk while we move other disks to Tower 3.

Can n = 3. Can we move Disk 1, 2, and 3 from Tower 3? Yes.

1. We know we can move the top two disks from one tower to another (as shown earlier), so let's assume we've already
done that. But instead, let's move them to Tower 2.

2. Move Disk 3 to Tower 3.

3. Move Disk 1 and Disk 2 to Tower 3. We already know how to do this––just repeat what we did in Step 1. Case n = 4
. Can we move Disk 1, 2, 3 and 4 from Tower 1 to Tower 3? Yes.

Case n = 4. Can we moe Disk 1, 2, 3 and 4 from Tower 1 to Tower 3? Yes.

1. Move Disks 1, 2, and 3 to Tower 2. We know how to do that from the earlier examples.

2. Move Disk 4 to Tower 3.

3. Move Disk 1, 2, and 3 back to Tower 3.

Remember that the labels of Tower 2 and Tower 3 aren't important. They're equivalent towers. So, moving disks to
Tower 3 with Tower 2 serving as a buffer is equivalent to moving disks to Tower 2 with Tower 3 serving as a buffer.

