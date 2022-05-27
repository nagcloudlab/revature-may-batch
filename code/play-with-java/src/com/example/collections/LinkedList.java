package com.example.collections;


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

public class LinkedList<E> {

    private Node<E> head = null;
    private Node<E> last = null;

    private int size = 0;

    public void add(E ele) {
        Node<E> newNode = new Node<>(ele);
        if (head == null) {
            head = newNode;
            last = newNode;
            size++;
        } else {
            last.setNext(newNode);
            last = newNode;
            size++;
        }
    }

    public int size() {
        return this.size;
    }


}
