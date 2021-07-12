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

class SLL {
    //    public int ele;
    Node head = null;
    void insertAtEnd(int ele) {
        Node newNode = new Node(ele);
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void insertAtBegin(int ele) {
        Node newNode = new Node(ele);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    int currentSizeSLL() {
        Node temp = head;
        int size = 0;

        while(temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

    void insertAtGivenPosition(int pos, int ele) {
        if(currentSizeSLL() < pos) {
            System.out.println("Invalid Position!, Current size of LinkedList is: "+ currentSizeSLL());
            return;
        }
        Node temp = head;
        Node newNode = new Node(ele);

        for(int i = 1; i < pos; ++i) {
            temp = temp.next;
        }

        Node nxt = temp.next;
        if(nxt == null) {
            temp.next = newNode;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    void deleteNode(int pos) {
        if(currentSizeSLL() < pos) {
            System.out.println("Invalid Position!, Current size of LinkedList is: "+ currentSizeSLL());
            return;
        }

        Node t1 = null, t2 = head;
        for(int i = 1; i < pos; ++i) {
            t1 = t2;
            t2 = t2.next;
        }

        if(t1 == null) { // delete starting node
            head = head.next;
        } else if(t2.next == null) { // delete last node
            t1.next = null;
        } else {
            t1.next = t2.next; // delete any other node
        }
    }

    void displayNodes() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    boolean detectLoop() {
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next != null && slowPtr != fastPtr) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr == fastPtr;
    }

}
public class DetectLoopInLinkedList {

    public static void main(String[] args) {
        int ch;
        SLL obj = new SLL();

        obj.insertAtEnd(10);
        obj.insertAtEnd(20);
        obj.insertAtEnd(30);
        obj.insertAtEnd(40);
        obj.insertAtEnd(50);
        obj.insertAtEnd(60);

        Node temp = obj.head;
        Node temp30 = null;
        while(temp.next != null) {
            if(temp.data == 30) {
                temp30 = temp;
            }
            temp = temp.next;
        }
        temp.next = temp30;

        if(obj.detectLoop()) {
            System.out.println("Has Loop");
        } else {
            System.out.println("Has no Loop");
        }

    }
}

