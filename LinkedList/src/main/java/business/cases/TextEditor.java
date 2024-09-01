package business.cases;

public class TextEditor {
    private Node<Character> head;
    private Node<Character> tail;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public TextEditor() {
        head = tail = null;
    }

    public void insert(char c) {
        Node<Character> newNode = new Node<>(c);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void delete() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            Node<Character> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Node<Character> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }
        return sb.toString();
    }
}
