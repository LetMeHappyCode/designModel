package com.algorithm.Tree.biTree;

import com.algorithm.Tree.AbstractBinarySearchTree;

public class BiTree {
    /** Root node where whole tree starts. */
    public BiTreeNode root;

    public void insert(){

    }

    public BiTreeNode createBinTree(int array[], int num) {
        //根节点为第一个数
        BiTreeNode root = new BiTreeNode(array[num]);
        // 左孩子
        if(num * 2 + 1 < array.length){
            root.left = createBinTree(array, num * 2 + 1);
        }

        // 右孩子
        if(num * 2 + 2 < array.length){
            root.right = createBinTree(array, num * 2 + 2);
        }

        return root;
    }

    public void printTree(BiTreeNode root) {
        printSubtree(root);
    }

    public void printSubtree(BiTreeNode node) {
        if (node.right != null) {
            printTree(node.right, true, "");
        }
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, "");
        }
    }

    private void printNodeValue(BiTreeNode node) {
        if (node.value == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.value.toString());
        }
        System.out.println();
    }

    private void printTree(BiTreeNode node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }

}
