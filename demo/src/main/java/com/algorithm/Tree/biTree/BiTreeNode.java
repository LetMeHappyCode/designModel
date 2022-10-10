package com.algorithm.Tree.biTree;

public class BiTreeNode {
    public BiTreeNode(Integer value, BiTreeNode parent, BiTreeNode left, BiTreeNode right) {
        super();
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public BiTreeNode(){}
    public BiTreeNode(int value){
        this.value = value;
    }

    public Integer value;
    public BiTreeNode parent;
    public BiTreeNode left;
    public BiTreeNode right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BiTreeNode other = (BiTreeNode) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
