package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int start;
    int val;
    Node left;
    Node right;
    int code = 0;

    Node (int val){
        this.val = val;
        left = null;
        right = null;
    }
    public void setStart(int s){
        start = s;
    }
    public void printTree(Node r){
        if (r != null){
            System.out.println(r.val);
            printTree(r.left);
            printTree(r.right);
        }
    }
    public int treeSize(Node r){

        if (r != null){
            start++;
            treeSize(r.left);
            treeSize(r.right);
        }
        return start;
    }
    public boolean isSameTree(Node p, Node q) {
        if(p != null && q !=null){

            if(p.val == q.val){
                isSameTree(p.left, q.left);
                isSameTree(p.right, q.right);
            }
            else{
                code = 1;
            }
        }
        if (code == 1){
            return false;
        }
        else {
            return true;
        }
    }

    public void invertTree(Node root){
        if (root != null){
            Node flip = root.left;
            Node flop = root.right;
            root.left = flop;
            root.right = flip;
            invertTree(root.left);
            invertTree(root.right);
        }
    }

    public Node constructTree(Integer[] practiceArray){
        Integer[] praticeArray = practiceArray;
        Node primeRoot = new Node(praticeArray[0]);
        System.out.println("Root is " + primeRoot.val);
        if (praticeArray[1] != null){
            primeRoot.left = new Node(praticeArray[1]);
            System.out.println("Root left child is " + primeRoot.left.val);
        }
        if (praticeArray[2] != null){
            primeRoot.right = new Node(praticeArray[2]);
            System.out.println("Root right child is " + primeRoot.right.val);
        }
        if(praticeArray.length >3){
            int marker = 3;
            int counter = 1;
            int tracker = praticeArray.length;
            primeRoot.builder(counter, marker, primeRoot.left, primeRoot, tracker, praticeArray);
        }
        return primeRoot;
    }

    public void builder(int count, int mark, Node RT, Node PR, int track, Integer[] source){
        if (track >= source.length - 4){
            if (mark == 3){
                if(source[count+2] != null) {
                    RT.left = new Node(source[count + 2]);
                    System.out.println(RT.val + " left child is " + RT.left.val);
                }
                if(source[count+3] != null){
                    RT.right = new Node(source[count+3]);
                    System.out.println(RT.val + " right child is " + RT.right.val);
                }
                builder(count + 1, mark -2, PR.right, PR, track -1, source);
            }
            else{
                if(source[count +3] != null) {
                    RT.left = new Node(source[count + 3]);
                    System.out.println(RT.val + " left child is " + RT.left.val);
                }
                if(source[count +4] != null){
                    RT.right = new Node(source[count+4]);
                    System.out.println(RT.val + " right child is " + RT.right.val);
                }
                builder(count + 3, mark + 2, RT.left, RT, track -1, source);
            }
        }
        else
            return;

    }
    public List<Integer> breaker(Node RT) {
        int tSize = RT.treeSize(RT);
        List<Integer> serialized = new ArrayList<Integer>();
        if (RT != null) {
            serialized.add(0, RT.val);
        }
        if (RT.left != null) {
            serialized.add(1, RT.left.val);
        }
        if (RT.right != null) {
            serialized.add(2, RT.right.val);
        }
        if (tSize > 3) {
            debuilder(1, 3, RT.left, RT, serialized);
        }
        return serialized;
    }
    public List<Integer> debuilder(int count, int mark, Node RT, Node PR, List<Integer> serialized){

        if (RT != null){
            if (mark == 3){
                if(RT.left != null) {
                    serialized.add(count+2, RT.left.val);
                }
                else{
                    serialized.add(count+2, null);
                }
                if(RT.right != null){
                   serialized.add(count+3, RT.right.val);
                }
                else{
                    serialized.add(count+3, null);
                }
                debuilder(count + 1, mark -2, PR.right, PR, serialized);
            }
            else{
                if(RT.left != null) {
                    serialized.add(count+3, RT.left.val);
                }
                else{
                    serialized.add(count+3, null);
                }
                if(RT.right != null){
                    serialized.add(count+4, RT.right.val);
                }
                else{
                    serialized.add(count+4, null);
                }
                debuilder(count + 3, mark + 2, RT.left, RT, serialized);
            }
        }
        return serialized;

    }
}
