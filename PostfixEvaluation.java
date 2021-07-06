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

public class PostfixEvaluation {

    public static void main(String[] args) {

        String PostfixExpression;
        System.out.println("Enter Valid postfix expression in variable form e.g. ABC*EF-/+");

        Scanner sc = new Scanner(System.in);
        PostfixExpression = sc.nextLine();

        int size = PostfixExpression.length();

        dynamicStack stOperand = new dynamicStack();

        for(int i = 0; i < size; ++i) {
            if((PostfixExpression.charAt(i) >= 'a' && PostfixExpression.charAt(i) <= 'z') ||
                    (PostfixExpression.charAt(i) >= 'A' && PostfixExpression.charAt(i) <= 'Z')) {
                System.out.println("Enter the value of " + PostfixExpression.charAt(i));

                int n;
                n = sc.nextInt();

                stOperand.push(n);
            } else if(PostfixExpression.charAt(i) == '+' || PostfixExpression.charAt(i) == '-' ||
                    PostfixExpression.charAt(i) == '*' || PostfixExpression.charAt(i) == '/') {

                double op2 = stOperand.peek();
                stOperand.pop();
                double op1 = stOperand.peek();
                stOperand.pop();

                switch (PostfixExpression.charAt(i)) {
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

