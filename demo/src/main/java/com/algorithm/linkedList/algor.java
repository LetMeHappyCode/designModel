package com.algorithm.linkedList;

import org.junit.Test;

import java.util.HashMap;

public class algor {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode partition(ListNode head, int x){
        //准备两个链表，分别存放大于x和小于x的节点，并且创建头指针
        ListNode smallNode =new ListNode(0);
        ListNode headSmallNode=smallNode;
        ListNode bigNode = new ListNode(0);
        ListNode headBigNode =bigNode;
        //如果传入的是空链表，或者链表中只有一个节点，则没有分隔的必要，直接返回
        //先判断 head ，再判断head.next
        if ( head==null || head.next == null){
            return head;
        }
        while (head != null){
            if (x>head.val){
                smallNode.next=head;
                smallNode = smallNode.next;
            }else {
                bigNode.next=head;
                bigNode = bigNode.next;
            }
            head=head.next;
        }
        //合并
        bigNode.next = null;
        smallNode.next=headBigNode.next;
        return headSmallNode.next;
    }

    /**
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     */
    @Test
    public void creatLinkedList(){
        List link = new List();
//        link.add(1);
//        link.add(4);
//        link.add(3);
//        link.add(2);
//        link.add(5);
//        link.add(2);
//        int val = link.root.val;
//        System.out.println(val);
//        link.print();
        System.out.println();

        ListNode partition = partition(link.root,3);
        partition.printNode();
    }


    //使用map 深拷贝链表
    public Node copyRandomList(Node head) {
        //准备map，可以存放旧的Node，value存放新的Node
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //遍历所有节点，使用构造方法拷贝val
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //再次遍历，拷贝next 和 random
        cur = head;
        while (cur!= null){
            // map.get(cur.next); 指向源节点的下一个节点
            map.get(cur).next = map.get(cur.next);
            //map.get(cur.random); 指向源节点的random节点
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 因为head 和 cur第一个的地址相同，cur=head，虽然存放的是cur，但是使用head根据地址能够找到第一个节点。
        return map.get(head);
    }


    //判断链表是否有环
    //快慢指针
    public ListNode getLoopNode(ListNode head){
        if (head==null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        //如果快慢指针相遇，说明又有环，但是相遇节点 不是 相交节点
        while (slow!=fast){
            //快指针遇到null，则无环
            if ( fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //快指针重新从头节点开始
        fast = head;
        //慢指针 在相交节点位置，快指针在头节点位置
        //如果，快指针和慢指针 每次移动一个节点，相遇位置就是第一个入环节点
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void getLoopNodeTest(){
        List link1 = new List();
        link1.add(4);
        link1.add(1);
        link1.add(8);
        link1.add(4);
        link1.add(5);
        ListNode head = link1.root;
        ListNode endNode = null;
        ListNode cycleNode = null;
        while (head!=null){
            if (head.next==null){
                endNode = head;
            }
            if (head.val == 8){
                cycleNode = head;
            }
            head = head.next;
        }
        endNode.next = cycleNode;
        ListNode loopNode = getLoopNode(link1.root);
        System.out.println(loopNode.val);
        ;

    }


    //两个无环链表 判断相交节点
    public ListNode noLoop(ListNode head1,ListNode head2){
        if (head1==null || head2==null){
            return null;
        }
        //求出两个链表长度差，长的链表头节点跳过到差值位置，两个链表一起移动，会在相交节点相交
        //n:两个链表的插值
        int n =0;
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        //n:链表1长度减去链表的值
        cur1 = n>0 ? head1:head2; // 谁长，谁的头就变成cur1
        cur2 = cur1==head1 ? head2:head1;     //谁短，谁变成cur2
        n =Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //两个有环链表，返回第一个相交节点，如果不相交返回null
    public ListNode bothLoop(ListNode head1,ListNode loop1,ListNode head2,ListNode loop2){
        //两个链表的，换节点相同，相当于无环链表判断交点
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (loop1 == loop2){
            int n=0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n>0?head1:head2;
            cur2 = cur1 == head1?head2:head1;
            n = Math.abs(n);
            while (n!=0){
                n--;
                cur1= cur1.next;
            }
            while (cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            //从loop1继续 沿着环转一圈，如果发现loop2说明有相交节点，返回那个节点都可以。否则没有相交节点
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    //判断链表是否有环
    //快慢指针
    public boolean hasCycle(ListNode head){
        if (head==null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        //如果快慢指针相遇，说明又有环，但是相遇节点 不是 相交节点
        while (slow!=fast){
            //快指针遇到null，则无环
            if ( fast.next == null || fast.next.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //不存在环的两个单链表相交
    //思路：计算出两个链表长度的差值n，长的链表移动n个位置后，长的链表剩下部分和断链表长度相同，最后一起移动到交点位置。
    public ListNode getIntersectionNode(ListNode head1,ListNode head2){
        if (head1 == head2){
            return head1;
        }
        ListNode cur1 =head1;
        ListNode cur2 = head2;
        int n = 0;
        while (cur1!=null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2!=null){
            n--;
            cur2 = cur2.next;
        }
        //找出head1和head2哪一个长，cur1 长的链表的头节点，cur2做断链表的头节点
        cur1 = n>0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        //长的链表走n步，使剩余长度和断链表相同
        n = Math.abs(n);
        while (n!=0){
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2){
            if (cur1.next==null || cur2==null){
                return null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * [4,1,8,4,5]
     * [5,6,1,8,4,5]
     */
    @Test
    public void getIntersectionNodeTest(){
        List link1 = new List();
        link1.add(4);
        link1.add(1);
        link1.add(8);
        link1.add(4);
        link1.add(5);

        List link2 = new List();
        link2.add(5);
        link2.add(6);
        link2.add(2);
        ListNode head = link1.root;
        while (head.val!=8){
            head = head.next;
        }
        link2.addNode(head);
        link1.print();
        link2.print();
        ListNode intersectionNode = getIntersectionNode(link1.root, link2.root);
        System.out.println(intersectionNode.val);

    }
}
