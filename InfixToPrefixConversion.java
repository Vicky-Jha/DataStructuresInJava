package study;

import java.util.Scanner;

class Node {
    char data;
    Node next;
    Node(char d) {
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

    void display() {
        Node temp = top;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

class InfixToPrefix {
    dynamicStack st = new dynamicStack();

    int priority(char c) {
        if(c == '(') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return -1;
    }

    String conversion(String expression) {
        String res = "";

        for(int j = expression.length() - 1; j >= 0; j--) {
            res += expression.charAt(j);
        }

        expression = res;
        res = "";

        for(int i = 0; i < expression.length(); ++i) {
            if((expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') || (expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z')) {
                res += expression.charAt(i);
            } else {
                if(st.isEmpty() || expression.charAt(i) == '(') {
                    st.push(expression.charAt(i));
                } else if(expression.charAt(i) == ')') {
                    while(st.isEmpty() == false && st.peek() != '(') {
                        res += st.peek();
                        st.pop();
                    }
                    st.pop();
                } else if(priority(st.peek()) >= priority(expression.charAt(i))) {
                    while(st.isEmpty() == false && priority(st.peek()) >= priority(expression.charAt(i))) {
                        res += st.peek();
                        st.pop();
                    }
                    st.push(expression.charAt(i));
                } else {
                    st.push(expression.charAt(i));
                }
            }
        }
        while(st.isEmpty() == false) {
            res += st.peek();
            st.pop();
        }

        expression = "";

        for(int j = res.length() - 1; j >= 0; j--) {
            expression += res.charAt(j);
        }

        res = expression;

        return res;
    }
}

public class InfixToPrefixConversion {
    public static void main(String[] args) {
        System.out.println("Enter Infix Expression to convert to Prefix");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        InfixToPrefix itp = new InfixToPrefix();
        System.out.println("Prefix expression for given Infix "+ expression +" is : "+ itp.conversion(expression));
    }
}
