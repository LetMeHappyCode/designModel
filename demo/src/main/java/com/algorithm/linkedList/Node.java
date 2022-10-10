package com.algorithm.linkedList;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void addNode(Node newNode){
        if(this.next==null){
            this.next = newNode;
        }else{
            this.next.addNode(newNode);
        }
    }
    public void printNode(){
        System.out.print(this.val + "-->");
        if(this.next!=null){
            this.next.printNode();
        }
    }
}
