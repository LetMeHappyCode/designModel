package com.algorithm.linkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public int getVal(){
        return this.val;
    }
    public void addNode(ListNode newNode){
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
