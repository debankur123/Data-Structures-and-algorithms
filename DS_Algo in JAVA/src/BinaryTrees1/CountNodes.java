package BinaryTrees1;

import java.util.Scanner;

public class CountNodes {
    public static BinaryTreeNode<Integer> takeInputs(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data " + " ");
        }else{
            if(isLeft){
                System.out.println("Enter left child of " + " "+ parentData);
            }else{
                System.out.println("Enter right child of " +" "+ parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeInputs(false,rootData,true);
        BinaryTreeNode<Integer> rightChild = takeInputs(false,rootData,false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftNodeCount = countNodes(root.left);
        int rightNodeCount = countNodes(root.right);
        return 1+leftNodeCount+rightNodeCount;
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + ":");
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
        BinaryTreeNode<Integer> root = takeInputs(true,0,true);
        printTree(root);
        System.out.println("The number of nodes are :" + countNodes(root));
    }
}
