package org.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String args[]) {

        //1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = null;
        root.left.left.right = new TreeNode(7);

        System.out.println("MaxWidth = " + getMaxWidth(root));

        //2 7 5 2 6 8 9 -1 7 -1 -1 -1 -1 -1 -1 -1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(8);
        root1.right.right = new TreeNode(9);
        root1.left.left.left = null;
        root1.left.left.right = new TreeNode(7);

        System.out.println("MaxWidth = " + getMaxWidth(root1));

    }

    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //level order traversal

        while(!queue.isEmpty()) {
            int size = queue.size();

            maxWidth = Math.max(maxWidth, size);

            while(size-- > 0) {
                TreeNode node = queue.poll();

                if( node.left != null ) {
                    queue.offer(node.left);
                }

                if( node.right != null ) {
                    queue.offer(node.right);
                }
            }
        }


        return maxWidth;
    }
}

