package business.cases;

import java.util.NoSuchElementException;

public class OrderManagement {
    private Node<Order> head;
    private Node<Order> tail;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Order {
        int id;
        String description;

        Order(int id, String description) {
            this.id = id;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Order{id=" + id + ", description='" + description + "'}";
        }
    }

    public OrderManagement() {
        head = tail = null;
    }

    public void addOrder(Order order) {
        Node<Order> newNode = new Node<>(order);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Order processOrder() {
        if (head == null) throw new NoSuchElementException();
        Order order = head.data;
        head = head.next;
        if (head == null) tail = null;
        return order;
    }

    public void printOrders() {
        Node<Order> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
