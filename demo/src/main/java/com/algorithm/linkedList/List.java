package com.algorithm.linkedList;

public class List {
    public ListNode root;
    public void add(int val){
        ListNode newNode = new ListNode(val);
        if(this.root==null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
    }
    public void addNode(ListNode newNode){
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
        System.out.println();
    }
}
