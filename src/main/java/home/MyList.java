package home;

public abstract class MyList<T> {
    private MyList next = null;
    private MyList prev = null;
    T value;

    public MyList(T value) {
        this.value = value;
    }

    public MyList getNext() {
        return next;
    }

    public MyList getPrev() {
        return prev;
    }

    public T getValue() {
        return value;
    }

    public void setNext(MyList next) {
        this.next = next;
    }

    public void setPrev(MyList prev) {
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract boolean add(T param);
    public abstract T get(int i);
    public abstract boolean remove(int i);
    public abstract boolean addAll();
}
