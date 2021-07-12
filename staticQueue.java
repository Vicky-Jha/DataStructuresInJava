package study;

import java.util.Scanner;

class StaticQueue {
    private int MaxSize;
    private int front = -1, rear = -1;
    private int []queue;
    StaticQueue() {
        System.out.println("Enter Max size of Queue");
        Scanner sc = new Scanner(System.in);
        MaxSize = sc.nextInt();
        queue = new int[MaxSize];
    }
    void Enqueue(int ele) {
        if(rear == -1 && front == -1) {
            front = 0;
        }
        rear++;
        if(isFull()) {
            System.out.println("Queue has reached its MaxSize = "+ MaxSize);
            rear--;
            return;
        }
        queue[rear] = ele;
    }

    void Dequeue() {
        if(isEmpty()) {
            return;
        }
        front++;
    }

    Boolean isFull() {
        return rear == MaxSize;
    }

    Boolean isEmpty() {
        return rear == -1 || front > rear;
    }

    int size() {
        if(isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }
    void display() {
        if(isEmpty()) {
            System.out.println("Current size of Queue is: "+ size());
            return;
        }

        for(int i = front; i <= rear; ++i) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class staticQueue {

    public static void main(String[] args) {
        StaticQueue obj = new StaticQueue();
        int choice, ele;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your choce\n1. Enqueue\n2. Dequeue\n3. Size of Queue\n4. IsEmpty\n5. IsFull\n6. Display Queue\n7. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Element to Enqueue");
                    ele = sc.nextInt();
                    obj.Enqueue(ele);
                    System.out.println("Success");
                    break;
                case 2:
                    if(obj.isEmpty()) {
                        System.out.println("Cannot Dequeue as Queue is Empty");
                    } else {
                        obj.Dequeue();
                    }
                    break;
                case 3:
                    System.out.println("Current size of queue is: "+ obj.size());
                    break;
                case 4:
                    if(obj.isEmpty()) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                case 5:
                    if(obj.isFull()) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                case 6:
                    obj.display();
                    break;
                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
