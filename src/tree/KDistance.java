package tree;

import java.util.Arrays;

public class KDistance {

    private static void printKDown(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        if(k == 0) {
            System.out.println(root.value);
        }

        printKDown(root.left, k-1);
        printKDown(root.right, k-1);
    }
    private static int printKDistanceNodes(TreeNode root, int target, int k) {
        if(root == null) {
            return -1;
        }

        if(root.value == target) {
            printKDown(root, k);
            return 0;
        }

        // root is in left
        int ld = printKDistanceNodes(root.left, target, k);
        if (ld != -1) {
            if(ld+1 == k) {
                System.out.println(root.value);
            } else {
                printKDown(root.right, k - ld - 2);
            }
            return ld+1;
        }

        // root is in right
        int rd = printKDistanceNodes(root.right, target, k);
        if(rd != -1) {
            if(rd+1 == k) {
                System.out.println(root.value);
            } else {
                printKDown(root.left, k -rd -2);
            }
            return rd+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        printKDistanceNodes(root, 8, 2);


    }
}
