package study;

import java.util.Scanner;

class Node {
    char data;
    Node next;
    int ele;
    Node(char d) {
        data = d;
        next = null;
    }
    Node(int d) {
        ele = d;
        next = null;
    }
}

class dynamicStackChar {
    private Node top = null;
    int count = 0;

    boolean isEmpty() {
        return top == null;
    }

    void push(char ele) {
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

    char peek() {
        return top.data;
    }

    int sizeOfStack() {
        return count;
    }

}

class dynamicStackInt {
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
        return top.ele;
    }

    int sizeOfStack() {
        return count;
    }

}

class infixEvaluation {
    dynamicStackInt stOperand = new dynamicStackInt();
    dynamicStackChar stOperator = new dynamicStackChar();

    int priority(char ch) {
        if (ch == '(') {
            return 0;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return -1;
    }

    void switchCasesFunc() {
        int operand2 = stOperand.peek();
        stOperand.pop();
        int operand1 = stOperand.peek();
        stOperand.pop();
        switch (stOperator.peek()) {
            case '*' :
                stOperand.push(operand1*operand2);
                break;
            case '/' :
                stOperand.push(operand1/operand2);
                break;
            case '+' :
                stOperand.push(operand1 + operand2);
                break;
            case '-' :
                stOperand.push(operand1 - operand2);
                break;
        }
        stOperator.pop();
    }

    // 5*10-10/2+6 = 51

    // 5*10-10/(2+3) = 48
    int evaluateInfix(String expression) {
        int i = 0;
        while (i < expression.length()) {
            if(expression.charAt(i) == '(') {
                stOperator.push(expression.charAt(i));
            }
            else if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                int num = 0;
                while (i  < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num = num * 10 + (expression.charAt(i) - 48);
                    i++;
                }
                i--;
                stOperand.push(num);
            } else if(expression.charAt(i) == ')') {
                while(stOperator.peek() != '(') {
                    switchCasesFunc();
                }
                stOperator.pop();
            } else if (stOperator.sizeOfStack() > 0 && priority(expression.charAt(i)) <= priority(stOperator.peek())) {
                while (stOperator.sizeOfStack() > 0 && priority(expression.charAt(i)) <= priority(stOperator.peek())) {
                    switchCasesFunc();
                }
                stOperator.push(expression.charAt(i));
            } else {
                stOperator.push(expression.charAt(i));
            }
            i++;
        }

        while(stOperator.sizeOfStack() > 0) {
            switchCasesFunc();
        }

        return stOperand.peek();
    }
}

public class InfixEvaluation {

    public static void main(String[] args) {
        System.out.println("Enter the correct Expression");
        String expression;
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();

        infixEvaluation obj = new infixEvaluation();
        System.out.println(obj.evaluateInfix(expression));
    }
}
