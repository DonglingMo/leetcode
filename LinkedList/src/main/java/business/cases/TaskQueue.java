package business.cases;

import java.util.NoSuchElementException;

public class TaskQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public TaskQueue() {
        head = tail = null;
        size = 0;
    }

    public void enqueue(T task) {
        Node<T> newNode = new Node<>(task);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

