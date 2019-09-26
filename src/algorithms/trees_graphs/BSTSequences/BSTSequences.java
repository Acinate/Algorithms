package algorithms.trees_graphs.BSTSequences;

import algorithms.trees_graphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {
    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);

        // Recurse on left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // Weave together each list from the left and right side
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right: rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                              ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to prefix. Removing the head will damage
        *  first, so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with the second, damaging and then restoring the list. */
        int headSecond = second.removeFirst();
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
