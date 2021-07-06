package study;


import java.util.Scanner;

class Node {
    double data;
    Node next;
    Node(double d) {
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

    void push(double ele) {
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

    double peek() {
        return top.data;
    }

    int sizeOfStack() {
        return count;
    }

}

public class PrefixEvaluation {

    public static void main(String[] args) {

        String PrefixExpression;
        System.out.println("Enter Valid prefix expression in variable form e.g. +*ab/de");

        Scanner sc = new Scanner(System.in);
        PrefixExpression = sc.nextLine();

        int size = PrefixExpression.length();

        dynamicStack stOperand = new dynamicStack();

        for(int i = size - 1; i >= 0; --i) {
            if((PrefixExpression.charAt(i) >= 'a' && PrefixExpression.charAt(i) <= 'z') || (PrefixExpression.charAt(i) >= 'A' && PrefixExpression.charAt(i) <= 'Z')) {
                System.out.println("Enter the value of " + PrefixExpression.charAt(i));
                
                int n;
                n = sc.nextInt();

                stOperand.push(n);
            } else if(PrefixExpression.charAt(i) == '+' || PrefixExpression.charAt(i) == '-' ||
            PrefixExpression.charAt(i) == '*' || PrefixExpression.charAt(i) == '/') {

                double op1 = stOperand.peek();
                stOperand.pop();
                double op2 = stOperand.peek();
                stOperand.pop();

                switch (PrefixExpression.charAt(i)) {
                    case '+':
                        stOperand.push(op1 + op2);
                        break;
                    case '*':
                        stOperand.push(op1 * op2);
                        break;
                    case '-':
                        stOperand.push(op1 - op2);
                        break;
                    case '/':
                        stOperand.push(op1 / op2);
                        break;
                }
            } else {
                System.out.println("Invalid Expression! use only given format");
                System.exit(1);
            }
        }

        System.out.println("Result: "+stOperand.peek());
    }
}

