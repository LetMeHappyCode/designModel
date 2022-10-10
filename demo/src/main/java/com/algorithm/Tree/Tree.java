package com.algorithm.Tree;

class Tree extends  AbstractBinarySearchTree{
    /**
     * 构造二叉树
     */
    public Node createTreeNode(int[] nums) {
        for (int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
        return this.root;
    }
}
