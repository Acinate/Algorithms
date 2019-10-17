package algorithms.dynamic_programming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {
    int createStack(ArrayList<Box> boxes) {
        /* Sort in descending order by height. */
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}

class Box {
    int height;
    int width;
    int depth;

    boolean canBeAbove(Box box) {
        return box.height > height && box.width > width && box.depth > depth;
    }
}
