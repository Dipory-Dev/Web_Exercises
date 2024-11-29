package com.test04.queue;

public class IntQueue {
    private int[] q;
    private int capacity;
    private int num;
    private int front;
    private int rear;

    public IntQueue(int max) {
        num = front = rear = 0;

        capacity = max;


        try {
            q = new int[capacity];
        } catch (Exception e) {
            capacity = 0;
        }
    }

    public int enqueue(int no) throws Exception {
        if(num >= capacity) {
            System.out.println("Queue is full");
        }
        q[rear] = no;
        return no;
    }

    public int dequeue() throws Exception {
        if(num <= 0) {
            System.out.println("Queue is empty");
            throw new Exception();
        }
        int val = q[front++];
        num--;
        if(front == capacity) {
            front = 0;
        }
        return val;
    }

    public int peek() throws Exception {
        if(num <= 0) {
            System.out.println("Queue is empty");
            throw new Exception();
        }
        return q[front];
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("Queue is empty");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.println(q[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
