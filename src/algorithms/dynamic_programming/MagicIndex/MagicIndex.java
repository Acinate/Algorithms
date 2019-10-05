package algorithms.dynamic_programming.MagicIndex;

public class MagicIndex {
    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid-1);
        } else {
            return magicFast(array, mid+1, end);
        }
    }

    public int magicFastNonDistinct(int[] array) {
        return magicFastNonDistinct(array, 0, array.length - 1);
    }

    private int magicFastNonDistinct(int[] array, int start, int end) {
        if (end > start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex-1, midValue);
        int left = magicFastNonDistinct(array,start,leftIndex);
        if (leftIndex >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex+1, midValue);
        return magicFastNonDistinct(array, rightIndex, end);
    }
}
