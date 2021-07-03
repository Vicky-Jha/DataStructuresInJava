package study;

import java.util.Scanner;
class Stack {
    private int top, maxSize;
    private int[] st;
    Stack() {
        System.out.println("Enter max size of stack");
        Scanner sc = new Scanner(System.in);
        maxSize = sc.nextInt();
        st = new int[maxSize];
        top = -1;
    }

    boolean isFUll() {
        return top == maxSize - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int ele) {
        if(isFUll()) {
            System.out.println("Error! Stack is Already FUll");
        } else {
            top++;
            st[top] = ele;
            System.out.println("Push Operation Successful");
        }
    }
    void pop() {
        if(isEmpty()) {
            System.out.println("Error! Stack is Empty");
        } else {
            top--;
            System.out.println("Pop Operation Successful");
        }
    }

    int peek() {
        return st[top];
    }

    int sizeOfStack() {
        return top + 1;
    }

    void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(st[i]);
            }
        }
    }

 }
public class staticStack {
    public static void main(String[] args) {
        Stack obj = new Stack();
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Your Choice\n1.PUSH\n2.POP\n3.PEEK\n4.isEmpty\n5.isFUll\n6.Size of Stack\n7.Display\n8.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    int ele;
                    System.out.println("Enter element to push");
                    ele = sc.nextInt();
                    obj.push(ele);
                    break;
                case 2:
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
                    if(obj.isFUll()) {
                        System.out.println("Stack is Full");
                    } else {
                        System.out.println("Stack has some element");
                    }
                case 6:
                    System.out.println("Size of stack is: "+obj.sizeOfStack());
                    break;
                case 7:
                    obj.display();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
