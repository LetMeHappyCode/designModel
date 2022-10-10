package com.algorithm.Tree;

public class printTree {
    /**
     * 递归遍历二叉树
     */
    public void recurionPrintTree(){

    }

    public void preOrderRecur(){

    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] nums = new int[]{1, 2, 4, 0, 0, 0, 3, 0, 0};
        tree.createTreeNode(nums);
        tree.printTree();
    }
}
