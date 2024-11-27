package com.test02.list;

import java.util.Comparator;

public class DoubleLinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            next = this;
        }

        Node(E data, Node<E> prev, Node<E> next) {
            data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList() {
        head = crnt = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while(ptr != head) {
            if(c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
        }
        return null;
    }

    public void pringCrntNode() {
        if(isEmpty()) {
            System.out.println("No nodes.");
        } else {
            System.out.println(crnt.data);
        }
    }

    public void dump() {
        Node<E> ptr = head.next;
        while(ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public boolean prev() {
        if(isEmpty()) {
            return false;
        }
        if (crnt.prev == head) {
            crnt = head.prev;
        } else {
            crnt = crnt.prev;
        }
        return true;
    }

    public boolean next() {
        if(isEmpty()) {
            return false;
        }
        if (crnt.next == head) {
            crnt = head.next;
        } else {
            crnt = crnt.next;
        }
        return true;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
    }

    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    public void removeCrnt() {
        if(!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if(crnt == head) {
                crnt = head.next;
            }
        }
    }

    public void removeFirst() {
        crnt = head.next;
        removeCrnt();
    }

    public void removeLast() {
        crnt = head.prev;
        removeCrnt();
    }

    public void clear() {
        while(!isEmpty()) {
            removeFirst();
        }
    }

}
