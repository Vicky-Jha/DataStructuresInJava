package study;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

class circularQueue {
    private int front = -1, rear = -1, max_size;
    int []queue;
    circularQueue() {
        System.out.println("Enter max size of circular queue");
        Scanner sc = new Scanner(System.in);
        max_size = sc.nextInt();
        queue = new int[max_size];
    }

    Boolean isFull() {
        return rear > front ? rear - front == max_size - 1 : rear - front + 1 == 0;
    }

    Boolean isEmpty() {
        if (front == -1 && rear == -1) return true;
        else if(rear < front) return front >= (rear + 1) % max_size;
        else return false;
    }

    void Enqueue(int ele) {

        if(isFull()) {
            System.out.println("Error!, Queue is Full");
            return;
        }
        if(front == -1 && rear == -1) {
            front = 0;
        }
        rear = (rear + 1) % max_size;
        queue[rear] = ele;
        System.out.println("Success");
    }

    void Dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            front = -1, rear = -1;
            return;
        }
        front++;
    }

    int size() {
        return front + rear + 1;
    }

    void Display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        if(rear >= front) {
            for (int i = front; i <= rear; ++i) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < max_size; ++i) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; ++i) {
                System.out.print(queue[i] + " ");
            }
        }
    }
}


public class staticCircularQueue {

    public static void main(String[] args) {
        circularQueue obj = new circularQueue();
        int choice, ele;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your choice\n1. Enqueue\n2. Dequeue\n3. Size of Queue\n4. IsEmpty\n5. IsFull\n6. Display Queue\n7. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Element to Enqueue");
                    ele = sc.nextInt();
                    obj.Enqueue(ele);
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
                    obj.Display();
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
