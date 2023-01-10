package otherHomework;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void addAtFirst(T val) {
        Node<T> temporal = new Node(val);
        temporal.next = head;
        head = temporal;
        if (tail == null) {
            tail = temporal;
        }
        size++;
    }

    public void addAtLast(T val) {
        if (tail == null) {
            addAtFirst(val);
            return;
        }

        Node<T> temp = new Node<>(val);
        tail.next = temp;
        tail = temp;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            builder.append(temp.value).append(",");
            if (temp == tail) builder.append("-.");
            temp = temp.next;
        }
        return builder.toString();
    }

    public int getSize() {
        System.out.println(size);
        return size;
    }
}
    class Node<T> {
        Node<T> next;
        T value;
        Node(T value) {
            this.value = value;
        }
    }


