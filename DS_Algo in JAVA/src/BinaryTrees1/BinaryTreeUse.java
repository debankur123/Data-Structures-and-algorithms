package BinaryTrees1;

public class BinaryTreeUse {

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + ":" + " ");
        if(root.left!=null){
            System.out.print("L" + root.left.data + ", ");
        }
        if(root.right!=null){
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);

        BinaryTreeNode<Integer> rootleft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootright = new BinaryTreeNode<>(3);
        root.left = rootleft;
        root.right = rootright;

        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
        rootleft.right = twoRight;
        rootright.left = threeLeft;

        printTree(root);
    }
}
