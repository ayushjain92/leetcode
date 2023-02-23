package tree;

public class Diameter {

    private static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int height = Math.max(1+getHeight(root.left), 1+getHeight(root.right));
        return height;
    }
    private static int getDiameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        int diameter = Math.max(Math.max(getDiameter(root.left), getDiameter(root.right)),
                lh + rh + 1);

        return diameter;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        //root.right.left = new TreeNode(7);

        //System.out.println(getHeight(root));
        System.out.println(getDiameter(root));
    }
}
