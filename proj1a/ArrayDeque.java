public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int maxsize;

    //initializing
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        maxsize = 8;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if (size == maxsize) {
            resize(maxsize * 2);
            maxsize *= 2;
        }
        T[] a = (T[]) new Object[maxsize * 2];
        System.arraycopy(items, 0, a, 1, size);
        a[0] = item;
        items = a;
        size += 1;
    }

    public void addLast(T item) {
        if (size == maxsize) {
            resize(maxsize * 2);
            maxsize *= 2;
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T[] a = (T[]) new Object[size];
        System.arraycopy(items, 1, a, 0, size - 1);
        T b = items[0];
        items = a;
        size -= 1;
        return b;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T b = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return b;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        return items[index - 1];
    }


}
