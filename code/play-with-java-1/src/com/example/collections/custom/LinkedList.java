package com.example.collections.custom;


import java.util.Iterator;

class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

public class LinkedList<E> implements Iterable<E> {

    private Node<E> head = null;
    private Node<E> last = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void add(E ele) {
        Node<E> newNode = new Node<>(ele);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index > size - 1)
            throw new IndexOutOfBoundsException(index);
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        int i = 0;
        Node<E> current = head;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;

    }

    public E get(int index) {
        if (index > size - 1)
            throw new IndexOutOfBoundsException(index);
        if (index == 0)
            return head.getData();
        Node<E> t = head.getNext();
        int i = 1;
        E e = null;
        while (i <= index) {
            if (t != null) {
                e = t.getData();
                t = t.getNext();
            }
            i++;
        }
        return e;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head;
            public boolean hasNext() {
                if (current != null)
                    return true;
                else return false;
            }
            public E next() {
                E e = current.getData();
                current = current.getNext();
                return e;
            }
        };
    }
}
