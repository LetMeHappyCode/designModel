package com.algorithm.linkedList;

public class ListCommon {
    public Node root;
    public void add(int val){
        Node newNode = new Node(val);
        if(this.root==null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
    }
    public void print(){
        if(this.root!=null){
            this.root.printNode();
        }
    }
}
