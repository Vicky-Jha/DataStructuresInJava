package study;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class dynamicStack {
    private Node top = null;
    int count = 0;

    boolean isEmpty() {
        return top == null;
    }

    void push(int ele) {
        Node newNode = new Node(ele);

        newNode.next = top;
        top = newNode;
        count++;
    }

    void pop() {
        if(isEmpty() == false) {
            top = top.next;
            count--;
        }
    }

    int peek() {
       return top.data;
    }

    int sizeOfStack() {
        return count;
    }

    void display() {
        Node temp = top;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

public class stackUsingLinkedList {
    public static void main(String[] args) {
        dynamicStack obj = new dynamicStack();
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("Enter Your Choice\n1.PUSH\n2.POP\n3.PEEK\n4.isEmpty\n5.Size of Stack\n6.Display\n7.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int ele;
                    System.out.println("Enter element to push");
                    ele = sc.nextInt();
                    obj.push(ele);
                    break;
                case 2:
                    if(obj.isEmpty()) {
                        System.out.println("Stack is empty!");
                    }
                    obj.pop();
                    break;
                case 3:
                    if(obj.isEmpty()) {
                        System.out.println("Error! Stack is Empty");
                        break;
                    }
                    System.out.println("Top element is: "+obj.peek());
                    break;
                case 4:
                    if(obj.isEmpty()) {
                        System.out.println("Stack is Empty");
                    } else {
                        System.out.println("Stack has some element");
                    }
                    break;
                case 5:
                    System.out.println("Size of stack is: "+obj.sizeOfStack());
                    break;
                case 6:
                    if(obj.sizeOfStack() == 0) {
                        System.out.println("Stack is empty!");
                    }
                    obj.display();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
