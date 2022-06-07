package BinaryTrees1;

import java.util.Scanner;

public class isBalancedImproved {
    public static BinaryTreeNode<Integer> takeInputs(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            System.out.println("The root data is :" + " ");
        }else{
            if(isLeft){
                System.out.println("Enter left child of :" + parentData);
            }else{
                System.out.println("Enter right child of :" + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if(rootData==-1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeInputs(false,rootData,true);
        BinaryTreeNode<Integer> rightChild = takeInputs(false,rootData,false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
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

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root == null){
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }
        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1+Math.max(leftOutput.height,rightOutput.height);
        if(Math.abs(leftOutput.height-rightOutput.height)>1){
            isBal = false;
        }
        if(!leftOutput.isBalanced || rightOutput.isBalanced){
            isBal = false;
        }
        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputs(true,0,true);
        printTree(root);
        System.out.println("Is balanced is : " + isBalancedBetter(root).isBalanced);
    }
}
