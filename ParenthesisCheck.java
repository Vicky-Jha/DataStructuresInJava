package study;
import java.util.Scanner;
class Stack {
    int top, maxSize = 10;
    char[] st = new char[maxSize];

    boolean isFull() {
        return top == maxSize - 1;
    }

    void push(char ele) {
        if (isFull() == false) {
            top++;
            st[top] = ele;
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    void pop() {
        if (isEmpty() == false) {
            top--;
        }
    }

    int peek() {
        return st[top];
    }

    int sizeOfStack() {
        return top + 1;
    }

    boolean validparenthesis(String check) {
        for (int i = 0; i < check.length(); ++i) {
            if (check.charAt(i) == '(' || check.charAt(i) == '[' || check.charAt(i) == '{') {
                push(check.charAt(i));
            } else if (check.charAt(i) == ')') {
                if (isEmpty()) {
                    return false;
                }
                if (peek() == '(') {
                    pop();
                } else {
                    return false;
                }
            } else if (check.charAt(i) == ']') {
                if (isEmpty()) {
                    return false;
                }
                if (peek() == '[') {
                    pop();
                } else {
                    return false;
                }

            } else if (check.charAt(i) == '}') {
                if (isEmpty()) {
                    return false;
                }
                if (peek() == '{') {
                    pop();
                } else {
                    return false;
                }
            }
        }
        return isEmpty();
    }
}

public class ParenthesisCheck {
    public static void main(String[] args) {
        Stack obj=new Stack();
        String validchecker="[(())]{}", invalidchecker="[(((";
        if(obj.validparenthesis(validchecker)==true){
            System.out.println(validchecker+"valid parenthesis");
        }
        else{
            System.out.println(validchecker+"Invalid string");
        }
        if(obj.validparenthesis(invalidchecker)==true){
            System.out.println(invalidchecker+"valid parenthesis");
        }
        else{
            System.out.println(invalidchecker+"Invalid string");
        }
    }
}
