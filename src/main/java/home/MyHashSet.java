package home;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class MyHashSet<T> {
    private static final int CAPACITY = 16;
    private int size = 0;
    private Node<T>[] arr;

    public MyHashSet() {
        this.arr = new Node[CAPACITY];
    }

    public MyHashSet(Integer size) {
        this.arr = new Node[size];
    }

    static class Node<T> {
        int hash;
        private T key;
        Node<T> next;

        Node(int hash, T key) {
            this.hash = hash;
            this.key = key;
            this.next = null;
        }

    }

    public void add(T param) {
        int hash = Objects.hashCode(param);
        int index = Math.abs(hash) % arr.length;

        Node<T> curr = arr[index];
        if (curr == null) {
            arr[index] = new Node<>(hash, param);
            size++;
            return;
        }

        Node<T> prev = null;
        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, param)) {
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node<>(hash, param);
        size++;
    }

    public void printAll() {
        System.out.println();
        for (Node<T> n : arr) {
            if (n != null) {
                System.out.println(n.key);
            }
        }
    }

    public void remove(int param) {
        int hash = Objects.hashCode(param);
        int index = Math.abs(hash) % arr.length;

        Node<T> curr = arr[index];
        if (curr == null) {
            System.out.println("Такокого элемента нет");
            return;
        }

        Node<T> prev = null;
//        boolean findObj = true;
        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, param)) {
                if (prev == null) {
                    arr[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(5);
        set.add(5);
        set.add(1);
        set.add(17);
        set.add(33);
        set.remove(33);
        set.printAll();
    }
}
