package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //construct simple and same trees, A and A2
        Node A = new Node(1);
        Node A2 = new Node(1);

        Node B = new Node(2);
        Node B2 = new Node(2);

        Node C = new Node(3);
        Node C2 = new Node(3);

        A.left = B;
        A.right = C;
        A2.left = B2;
        A2.right = C2;

        //run isSameTree method for Question 1. Method in Node.java file
        if (A.isSameTree(A,A2)){
            System.out.println("Trees are same.");
        }

        //invert A2 tree for Question 2. Method in Node.java file
        A2.invertTree(A2);

        //run isSameTree method to prove A2 is inverted and no long same as A
        if (! A.isSameTree(A, A2)){
            System.out.println("Trees are NOT same.");
        }

        //Create Integer Array to make a new Tree

        Integer[] treeArray = {1,2,3,null,null,4,5,null,null,6,7,8,9, null, null, null, null};

        // Run Array through constructTree method. Method also in Node.java file.
        Node root = A.constructTree(treeArray);

        //Run Tree just created through breaker method, to create Integer Array.
        List<Integer> x =  root.breaker(root);
        Object[] myArray = x.toArray();
        Integer[] newTree = Arrays.copyOf(myArray,myArray.length, Integer[].class);

        //print out serialized Tree
        System.out.println(Arrays.toString(newTree));

        //Construct Tree again from Integer Array to prove method worked, as we are back with the same Array we started with.
        Node root2 = root.constructTree(newTree);
        
    }
}
