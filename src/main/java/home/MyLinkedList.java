package home;

public class MyLinkedList<T> {
    private int size;
    private Node<T> first;
    private Node<T> tail;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    public Node<T> node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public boolean add(T param) {
        Node<T> newNode = new Node<>();
        newNode.item = param;
        if (first == null) {
            first = newNode;
            newNode.prev = null;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        newNode.next = null;
        size++;
        return true;
    }

    public boolean addAll(MyLinkedList<T> l) {
        if (l == null || l.size == 0) {
            return false;
        }
        if (size == 0) {
            first = l.first;
            tail = l.tail;
        } else {
            tail.next = l.first;
            l.first.prev = tail;
            tail = l.tail;
        }
        size += l.size;
        return true;
    }

    public T remove(int index) {
        Node<T> x = node(index);
        T elem = x.item;
        if (x.prev == null) {
            first = x.next;
            if (x.next != null) {
                x.next.prev = null;
            }
        } else if (x.next == null) {
            x.prev.next = null;
            tail = x.prev;
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;
        return elem;
    }

    public T getItem(int index) {
        return node(index).item;
    }

    public int getSize() {
        return size;
    }

}
