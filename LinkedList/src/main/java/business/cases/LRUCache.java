package business.cases;

import java.util.HashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList<K, V> {
        private final Node<K, V> head;
        private final Node<K, V> tail;

        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node<K, V> node) {
            Node<K, V> next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        void remove(Node<K, V> node) {
            Node<K, V> prev = node.prev;
            Node<K, V> next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        Node<K, V> removeLast() {
            if (head.next == tail) return null;
            Node<K, V> last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoublyLinkedList<>();
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        } else {
            if (map.size() >= capacity) {
                Node<K, V> last = list.removeLast();
                if (last != null) map.remove(last.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            list.addFirst(newNode);
            map.put(key, newNode);
        }
    }
}

