package com.algorithm.Tree;

import com.algorithm.Tree.biTree.BiTree;
import com.algorithm.Tree.biTree.BiTreeNode;
import org.junit.Test;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.yaml.snakeyaml.events.Event;

import java.awt.*;
import java.util.*;

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

    public static void preOrderUnRecur(BiTreeNode head){
        System.out.println("pre-order");
        if (head != null){
            Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+" ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public void posOrderUnRecur(BiTreeNode head){
        System.out.println("pos-oreder");
        if (head != null){
            Stack<BiTreeNode> s1 = new Stack<BiTreeNode>();
            Stack<BiTreeNode> s2 = new Stack<BiTreeNode>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value+" ");
            }

        }
    }

    public void inOrderUnRecur(BiTreeNode head){
        System.out.println();
        System.out.println("in-order");
        if (head!=null){
            Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
            while (!stack.isEmpty() || head!=null){
                //节点进站时，有左子树，吧左子树放入栈
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }
                //如果某个斜着一条线的左子树全部入栈，head指向为空则出栈,然后head指向右子树，
                // 如果右子树为空，则下一个循环继续出栈，如果不为空，则循环加载全部右子树节点上斜着一条线上的全部左子树
                else {
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
    }

    //二叉树的宽度优先遍历(栈队列，先进先出)
    public void width(BiTreeNode head){
        System.out.println();
        if (head==null){
            return;
        }
        //队列
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.value+" ");
            if (head.left!=null){
                queue.add(head.left);
            }
            if (head.right != null){
                queue.add(head.right);
            }
        }
    }


    //计算最大宽度的行，使用map(有待巩固)
    public void maxWidthRow(BiTreeNode head){
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(head);
        //map ： key->BiTreeNode节点，value-> 节点在第几行
        HashMap<BiTreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        //第几行
        int curLevel = 1;
        //当前行有几个节点
        int curLevelNode = 0;
        int max = Integer.MIN_VALUE;
        int maxRowIndex = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            BiTreeNode cur = queue.poll();
            //获取节点 在第几行
            int curNodeLevel = levelMap.get(cur);
            //如果节点在当前行，当前行 节点数量加一个
            if (curNodeLevel == curLevel){
                curLevelNode ++ ;
            }
            //如果节点不在当前行,说明这一行的节点已经遍历完毕，统计最大值，然后前往下一行
            else {
                max = Math.max(max,curLevelNode);
                if (curLevelNode==max){
                    maxRowIndex = curLevel;
                }
                curLevel++;
                curLevelNode=1;
            }
            //宽度遍历
            if (cur.left != null) {
                levelMap.put(cur.left,curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right!=null){
                levelMap.put(cur.right,curNodeLevel+1);
                queue.add(cur.right);
            }
        }
        System.out.println("最大节点数量:"+max+"最大行"+maxRowIndex);

    }

    //中序遍历判断是否是搜索二叉树
    public  static int preValue = Integer.MIN_VALUE;
    public boolean checkBST(BiTreeNode head){
        if (head == null){
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        //判断 左子树是否是搜索二叉树
        if (!isLeftBst){
            return false;
        }
        // 根据中序遍历顺序（左中右），搜索树是（左 < 中 < 右）,此处判断是否符合，不符合则不是搜索二叉树
        if (head.value <= preValue){
            return false;
        }
        //说明此节点符合搜索二叉树的规则（左 < 中 < 右）,指针移动到当前节点，留给下一个节点判断规则
        else {
            preValue = head.value;
        }
        //先判断左子树，在判断右子树。
        return checkBST(head.right);
    }

    //非递归方式，中序遍历判断是否是搜索二叉树
    public boolean checkUnRecurBST(BiTreeNode head){
        if (head!=null){
            int preValue = Integer.MIN_VALUE;
            Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
            stack.push(head);
            while (!stack.isEmpty()){
                if (head.left!=null){
                    stack.push(head.left);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    if (preValue >= head.value){
                        return false;
                    }else {
                        preValue = head.value;
                    }
                    if (head.right!=null){
                        stack.push(head.right);
                        head = head.right;
                    }

                }
            }
        }
        return true;
    }

    //判断是否是 完全二叉树
    //使用 宽度遍历
    public boolean isCBT(BiTreeNode head){
        System.out.println();
        System.out.println("isBCBT");
        if (head == null){
            return true;
        }
        //队列
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(head);
        BiTreeNode cur;
        boolean leaf=false;         //第一个节点为叶子节点的标志条件
        BiTreeNode l;
        BiTreeNode r;
        while (!queue.isEmpty()){
            cur = queue.poll();
            l = cur.left;
            r = cur.right;
            System.out.print(cur.value+" ");
            //任一个节点，有右无左，返回false
            if (r!=null && l==null){
                return false;
            }else {
                //在不违反（任一个节点，有右无左）的条件下，如果遇到第一个右叶子节点不全，剩下的全部都是叶子节点，否则false
                if (r == null && !leaf){
                    leaf=true;
                }
                if (leaf){
                    if (l != null || r != null){
                        return false;
                    }
                }
                if (l!=null){
                    queue.add(l);
                }
                if (r != null){
                    queue.add(r);
                }
            }
        }
        return true;
    }

    /**
     * 判断是否是满二叉树(Map)
     * 最大深度 ：l
     * 节点数：N
     * 使用公式：N=2^l -1
     * 思路：使用宽度优先遍历，求深度和节点数
     */
    public boolean isFullByMap(BiTreeNode head){
        Queue<BiTreeNode> queue = new LinkedList<>();
        //key：节点    value：节点在第几层
        HashMap<BiTreeNode, Integer> map = new HashMap<>();
        //头节点入栈，位于第一层
        queue.add(head);
        map.put(head,1);

        BiTreeNode cur;
        int curLevel=1;
        int NodeNum=1;

        while (!queue.isEmpty()){
            cur = queue.poll();
            //当前节点位于当前层
            if (map.get(cur) != curLevel){
                curLevel = map.get(cur);
            }
            //不在当前层,则继续遍历
            if (cur.left!=null){
                queue.add(cur.left);
                map.put(cur.left,curLevel+1);       //当前节点存在左节点，左节点放入map并且层数+1
                NodeNum++;                      //节点总数多一个
            }
            if (cur.right!=null){
                queue.add(cur.right);
                map.put(cur.right,curLevel+1);      //当前节点存在右节点，右节点放入map并且层数+1
                NodeNum++;
            }
        }
        System.out.println("NodeNum:"+NodeNum+"--curLevel:"+curLevel);

        return Math.pow(2,curLevel) -1 == NodeNum;

    }
    /**
     * 判断是否是满二叉树(递归)
     * ps:递归的本质 是 栈
     * 最大深度 ：l
     * 节点数：N
     * 使用公式：N=2^l -1
     */
    public boolean isFull(BiTreeNode head){
        System.out.println("递归判断满二叉树");
        if (head == null){
            return true;
        }
        Info data = f(head);
        System.out.println(data.height+":"+data.nodes);
        return data.nodes == (Math.pow(2, data.height) -1);
    }

    public Info f(BiTreeNode x){
        if (x == null){
            return new Info(0,0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes +1;
        return new Info(height,nodes);
    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int h,int n){
            height = h;
            nodes = n;
        }
    }

    /**
     * 判断是否是平衡二叉树
     * |左高度-右高度| <= 1
     */
    public boolean isBalanced(BiTreeNode head){
        System.out.println("平衡二叉树");
        return process(head).isBalanced;
    }

    public static ReturnTypt process(BiTreeNode x){
        if (x == null){
            return new ReturnTypt(true,0);
        }
        ReturnTypt leftData = process(x.left);
        ReturnTypt rightData = process(x.right);
        //当前节点的高度
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced&&rightData.isBalanced
                && Math.abs(leftData.height - rightData.height)<2 ;
        return new ReturnTypt(isBalanced,height);
    }

    public static class ReturnTypt{
        public boolean isBalanced;
        public int height;
        public ReturnTypt(boolean isBalanced,int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * 给定两个二叉树节点node1和node2，找到他们的最低公共祖先节点(map发)
     */
    public BiTreeNode lowestAncestorByMap(BiTreeNode head,BiTreeNode o1,BiTreeNode o2){
        System.out.println("最低公共祖先节点");
        HashMap<BiTreeNode,BiTreeNode> fatherMap =new HashMap<>();
        fatherMap.put(head,head);
        //找到所有节点的父节点放入map
        processLowestAncestor(head,fatherMap);

        HashSet<BiTreeNode> set = new HashSet<>();

        BiTreeNode cur=o1;
        while (cur != fatherMap.get(cur)){
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(head);

        cur = o2;
        while (cur != fatherMap.get(cur)){
            if (set.contains(cur)){
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return null;
    }


    public void processLowestAncestor(BiTreeNode head,HashMap<BiTreeNode,BiTreeNode> fatherMap){
        if (head == null){
            return;
        }
        fatherMap.put(head.left,head);
        fatherMap.put(head.right,head);
        processLowestAncestor(head.left,fatherMap);
        processLowestAncestor(head.right,fatherMap);
    }

    /**
     * 给定两个二叉树节点node1和node2，找到他们的最低公共祖先节点
     * 两种情况：
     * 第一种：o1是o2的公共祖先节点，或o2是o1
     * 第二种： o1，o2的公共祖先节点是其他节点
     *
     * 只返回，等于o1或2的几点 和 返回 公共祖先节点是其他节点的情况
     */
    public BiTreeNode lowestAncestor(BiTreeNode head,BiTreeNode o1,BiTreeNode o2){
        //第一种情况，遇到直接返回，如果遇到o1，返回o1，此时如果o2在o1之下不会遍历到，o1一定是o2的祖先节点。
        // 否则就是第二种情况
        if (head == null || head==o1 || head == o2){
            return head;
        }
        BiTreeNode left = lowestAncestor(head.left,o1,o2);
        BiTreeNode right = lowestAncestor(head.right,o1,o2);
        //第二种情况 ,返回 公共祖先节点是其他节点的情况
        if (left!=null && right!=null){
            return head;
        }
        return left!=null?left:right;
    }

    /**
     * 二叉树找后继节点，后继节点就是x节点在中序遍历中的下一个节点
     * 有规律：
     */
    public void getSuccessorNode(BiTreeNode node){

    }

    @Test
    public void biTreeTest() {
        BiTree biTree = new BiTree();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = new int[]{9, 7, 15, 4, 8, 13,19 ,2 ,5}; //搜索树
        BiTreeNode binTree = biTree.createBinTree(nums, 0);
        preOrderRecur(binTree);
        System.out.println();
        preOrderUnRecur(binTree);
        System.out.println();
        biTree.printTree(binTree);
        inOrderRecur(binTree);
        posOrderUnRecur(binTree);
        inOrderUnRecur(binTree);
        width(binTree);
        maxWidthRow(binTree);

        boolean b = checkBST(binTree);
        System.out.println(b);
        boolean b1 = checkUnRecurBST(binTree);
        System.out.println(b1);
        boolean cbt = isCBT(binTree);
        System.out.println(cbt);
        boolean f = isFullByMap(binTree);
        System.out.println(f);
        System.out.println(isFull(binTree));
        System.out.println(isBalanced(binTree));
        BiTreeNode o1 = binTree.left;
        BiTreeNode o2 = binTree.left.right;
//        System.out.println(lowestAncestorByMap(binTree, o1, o2).value);
        System.out.println(lowestAncestor(binTree, o1, o2).value);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] nums = new int[]{1, 2, 4, 0, 0, 0, 3, 0, 0};
        tree.createTreeNode(nums);
        tree.printTree();
    }
}
