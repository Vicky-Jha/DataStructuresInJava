package study;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;
    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

class DLL {
    //    public int ele;
    private Node head = null;
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
            newNode.prev = temp;
        }
    }

    void insertAtBegin(int ele) {
        Node newNode = new Node(ele);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
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

    void insertAfterGivenPos(int pos, int ele) {
        if(currentSizeSLL() < pos) {
            System.out.println("Invalid Position!, Current size of LinkedList is: "+ currentSizeSLL());
            return;
        }
        Node temp = head;
        Node newNode = new Node(ele);

        for(int i = 1; i < pos; ++i) {
            temp = temp.next;
        }

        if(temp.next == null) {
            newNode.prev = temp;
            temp.next = newNode;
        } else {
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    void deleteNodeAtGivenPos(int pos) {
        if(currentSizeSLL() < pos) {
            System.out.println("Invalid Position!, Current size of LinkedList is: "+ currentSizeSLL());
            return;
        }

        Node temp = head;
        for(int i = 1; i < pos; ++i) {
            temp = temp.next;
        }

        if(pos == 1) {
            head = head.next;
        } else if(pos == currentSizeSLL()) {
            temp.prev.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
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

}


public class DoublyLinkedList {

    public static void main(String[] args) {
        int ch;
        DLL obj = new DLL();
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
                    obj.insertAfterGivenPos(pos, ele);
                    break;
                case 4:
                    System.out.println("Enter Node pos to delete");
                    pos = sc.nextInt();
                    obj.deleteNodeAtGivenPos(pos);
                    break;
                case 5:
                    System.out.println("Current Size of the list is "+ obj.currentSizeSLL());
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
