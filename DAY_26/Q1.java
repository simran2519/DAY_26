package DAY_26;

import java.util.Scanner;

class Node// class node
{
    Node left ,right ;// left and right with reference of Node
    int data ;
    Node root = null;
    public Node(int data)// parameterized constructor
    {
        this.data= data ;
        left= null;// initially left and right is set to null;
        right = null;
    }

}
public class Q1
{
    static Node pre =null;// to keep track of previous node
    static void flatten(Node root)// function flatten
    {
        if(root == null)// if root iss equal to null  then return
        {
            return;
        }
        // store right child temporarily
        Node rightTemp = root.right;
        if(pre!=null)
        {
            pre.left = null;// set left child of previous node to null
            pre.right = root;// set right child of the previous node to current
        }
        pre = root;// update p revious node to current
        flatten(root.left);
        flatten(rightTemp);
    }
    static void printList(Node head)// to print list
    {
        while(head != null)
        {
            System.out.println(head.data + " ");// print head data
            head =head.right;// set head right as head
        }
    }
    static Node create()
    {
        int data;
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.println("enter the value");
        data = sc.nextInt();
        if (data == -1) // base case
        {
            return null;
        }
        root = new Node(data);// pass data into root
        System.out.println("enter the left child of " + root.data);
        root.left = create();//for creating left child
        System.out.println("enter the right child of " + root.data);
        root.right = create();// for creating right child
        return root;// return root

    }

    public static void main(String[] args)
    {
        Node root = create();//create binary tree and root variable hold the reference of root of the constructed binary tree
        flatten(root); // flatten the binary tree
        System.out.println("Linkedlist after flatting :");
        printList(root);// call printList method and pass root
    }
}