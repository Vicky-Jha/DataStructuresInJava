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

class CLL {
    //    public int ele;
    private Node head = null;
    int count = 0;

    void insertAtEnd(int ele) {
        count++;
        Node newNode = new Node(ele);
        if(head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void insertAtBegin(int ele) {
        Node temp = head;
        Node newNode = new Node(ele);
        if(head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            while(temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        count++;
    }

    int currentSizeCLL() {
//        Node temp = head;
//        int size = 0;
//
//        while(temp != null) {
//            temp = temp.next;
//            size++;
//        }
//
//        return size;

        return count;
    }

    void insertAtGivenPosition(int pos, int ele) {
        if(currentSizeCLL() < pos) {
            System.out.println("Invalid Position!, Current size of Circular LinkedList is: "+ currentSizeCLL());
            return;
        }
        Node temp = head;
        Node newNode = new Node(ele);

        for(int i = 1; i < pos; ++i) {
            temp = temp.next;
        }

        Node nxt = temp.next;
//        if(nxt == head) {
//            temp.next = newNode;
//            newNode.next = head;
//        }
        if(pos == currentSizeCLL()) {
            insertAtEnd(ele);
            count--;
        } else if(pos == 1) {
            insertAtBegin(ele);
            count--;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }

        count++;
    }

    void deleteNode(int pos) {
        if(currentSizeCLL() < pos) {
            System.out.println("Invalid Position!, Current size of LinkedList is: "+ currentSizeCLL());
            return;
        }

        Node t1 = null, t2 = head;
        for(int i = 1; i < pos; ++i) {
            t1 = t2;
            t2 = t2.next;
        }

        if(t1 == null) { // delete starting node
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        } else if(t2.next == null) { // delete last node
            t1.next = head;
        } else {
            t1.next = t2.next; // delete any other node
        }
        count--;
    }

    void displayNodes() {
        if(head == null) {
            return;
        }
        System.out.print(head.data+" ");
        Node temp = head.next;

        while(temp != head) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}

public class CircularLinkedList {

    public static void main(String[] args) {
        int ch;
        CLL obj = new CLL();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your choice\n1.Insert Node in Beginning\n2.Insert Node at end" +
                    "\n3.Insert Node after given position\n4.Delete Node by Position\n" +
                    "5.Current Size of List\n6.Display List\n7.Exit");
            ch = sc.nextInt();
            int ele, pos;

            switch (ch) {
                case 1:
                    System.out.println("Enter Node data");
                    ele = sc.nextInt();
//                    obj.ele = sc.nextInt();
                    obj.insertAtBegin(ele);
                    break;
                case 2:
                    System.out.println("Enter Node data");
                    ele = sc.nextInt();
                    obj.insertAtEnd(ele);
                    break;
                case 3:
                    System.out.println("Enter Node pos to insert");
                    pos = sc.nextInt();
                    System.out.println("Enter Node data");
                    ele = sc.nextInt();
                    obj.insertAtGivenPosition(pos, ele);
                    break;
                case 4:
                    System.out.println("Enter Node pos to delete");
                    pos = sc.nextInt();
                    obj.deleteNode(pos);
                    break;
                case 5:
                    System.out.println("Current Size of the list is "+ obj.currentSizeCLL());
                    break;
                case 6:
                    System.out.println("Elements of the list are as follows:");
                    obj.displayNodes();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("invalid Choice");
                    break;
            }
        }
    }
}
