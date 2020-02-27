package Unit4;

import java.util.Random;

public class Binarytree {
    public static void main(String[] args) {

        TreeNode root = null;
        for (int i = 0; i < 1023; i++) {
            Random r = new Random();
            treeInsert(r.nextInt());
        }

        int leaves = countLeaves(root);
        int depths = sumDepth(root, 0);
        int maxDepth = maxDepth(root, 0);

        System.out.println("Sum of leaves:         " + leaves);

        System.out.println("Max depth of leaves:  " + maxDepth);


        try {
            int averageDepth = depths / leaves;
            System.out.println("Average depth of leaves:  " + averageDepth);
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException occured!");
        }
    }

    public static int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        } else if (node.right == null && node.left == null) {
            return depth;
        } else {
            int right = maxDepth(node.right, depth + 1);
            int left = maxDepth(node.left, depth + 1);
            return Math.max(right, left);
        }
    }


    public static int sumDepth(TreeNode node, int depth) {

        if (node == null) {
            return 1;
        } else if (node.right == null && node.left == null) {
            return depth;
        } else {
            int right = sumDepth(node.right, depth + 1);
            int left = sumDepth(node.left, depth + 1);

            return right + left;
        }
    }

    public static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.right == null && node.left == null) {
            return 1;
        } else {
            return countLeaves(node.right) + countLeaves(node.left);
        }
    }

    /**
     * Copy the TreeNode class from textbook
     */
    public static class TreeNode {

        int item;
        TreeNode left;
        TreeNode right;

        TreeNode(int str) {

        }
    }

    /**
     * copied the tree insert method from textbook.
     *
     * @param newItem
     */
    private static void treeInsert(int newItem) {
        TreeNode root = new TreeNode(newItem);
        if (root == null) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem < runner.item) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.right;
            }

        }
    }

}
