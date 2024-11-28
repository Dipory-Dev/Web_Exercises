package com.test03.stack;

public class IntStack {
    private int[] s;
    private int capacity;
    private int ptr;

    public IntStack(int max) {
        ptr = 0;
        capacity = max;

        try {
            s = new int[capacity];
        } catch (Exception e) {
            capacity = 0;
        }
    }
    public int push(int no) throws Exception{
        if (ptr > capacity) {
            System.out.println("Full Stack");
            throw new Exception();
        }
        return s[ptr++] = no;
    }

    public int pop() throws Exception {
        if(ptr <= 0) {
            System.out.println("Empty Stack");
            throw new Exception();
        }
        return s[--ptr];
    }

    public int peek() throws Exception {
        if(ptr <= 0) {
            System.out.println("Empty Stack");
            throw new Exception();
        }
        return s[ptr-1];
    }

    public void clear() {
        ptr = 0;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if(isEmpty()) {
            System.out.println("Empty Stack");
        } else {
            for(int i = 0; i < ptr; i++) {
                System.out.println(s[i] + " ");
            }
            System.out.println();
        }
    }

    public int indexOf(int no) {
        for (int i = 0; i < ptr; i++) {
            if(s[i] == no) {
                return i;
            }
        }
        return -1;
    }
}
