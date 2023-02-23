package tree;

public class MaxSumLeafToRoot {
    static TreeNode targetLeaf = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);

        maxSum(root);
    }

    private static int maxSum(TreeNode root) {
        targetLeaf(root, 0, Integer.MIN_VALUE);
        System.out.println(targetLeaf.value);
//        System.out.println(root.value);
//        System.out.println(root.left.value);
//        System.out.println(root.right.value);
//        System.out.println(root.left.left.value);
//        System.out.println(root.left.right.value);
        //System.out.println(root.right == targetLeaf);
        rootToLeafPath(root, new int[100], 0);

        return 0;
    }

    private static void targetLeaf(TreeNode root, int currSum, int maxSum) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            currSum = currSum + root.value;
            if(currSum > maxSum) {
                targetLeaf = root;
            }
        }

        targetLeaf(root.left, currSum + root.value, maxSum);
        targetLeaf(root.right, currSum + root.value, maxSum);
    }

    private static void rootToLeafPath(TreeNode root, int[] path, int index) {
        if(root == null) {
            return;
        }

        path[index] = root.value;

        if (root.left == null && root.right == null) {
            // if leaf
            if (root == targetLeaf) {
                for (int i = index; i >= 0; i--) {
                    System.out.print(path[i] + " ,");
                }
                return;
            }
        }

        //path[index] = root.value;
        rootToLeafPath(root.left, path, index+1);
        rootToLeafPath(root.right, path, index+1);
    }
}
