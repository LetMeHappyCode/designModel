package com.algorithm.Tree;

import com.algorithm.Tree.biTree.BiTree;
import com.algorithm.Tree.biTree.BiTreeNode;
import org.junit.Test;

public class printTree {
    /**
     * 递归遍历二叉树
     */

    public void recurionPrintTree(){

    }

    public void preOrderRecur(BiTreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(BiTreeNode head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value+" ");
        preOrderRecur(head.right);
    }

    public void postOrderRecur(BiTreeNode head){
        if (head == null){
            return;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value+" ");
    }

    public static void preOrderUnRecur(AbstractBinarySearchTree.Node head){
        System.out.println("pre-order");
        if (head != null){
        }
    }
    @Test
    public void biTreeTest(){
        BiTree biTree = new BiTree();
        int[] nums = new int[]{1, 2, 4, 0, 0, 0, 3, 0, 0};
        BiTreeNode binTree = biTree.createBinTree(nums, 0);
        preOrderRecur(binTree);
        System.out.println();
        biTree.printTree(binTree);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] nums = new int[]{1, 2, 4, 0, 0, 0, 3, 0, 0};
        tree.createTreeNode(nums);
        tree.printTree();
    }
}
