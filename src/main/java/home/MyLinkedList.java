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

    public Node<T> node(int index){
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public boolean add(T param){
        Node<T> newNode = new Node<>();
        newNode.item = param;
        newNode.next = null;
        if (first == null) {
            first = newNode;
            newNode.prev = null;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean addAll(MyLinkedList<T> l){
        for (int i = 0; i < l.getSize(); i++) {
            add(l.node(i).item);
        }

        return true;
    }

    public void remove(int index){
        Node<T> x = node(index);
        if (x.prev == null) {
            first = x.next;
            if (x.next != null) {
                x.next.prev = null;
            }
        } else if (x.next == null) {
            x.prev.next = null;
            tail = x.prev;
        }else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;

    }

    public T getItem(int index) {
        return node(index).item;
    }

    public int getSize() {
        return size;
    }

}
