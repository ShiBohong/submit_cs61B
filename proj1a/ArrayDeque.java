public class ArrayDeque<T> {
    private T[] items;
    private int head;  // 指向第一个元素
    private int tail;  // 指向最后一个元素的下一个位置
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        head = 0;
        tail = 0;
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        // 循环复制元素到新数组
        for (int i = 0; i < size; i++) {
            a[i] = items[(head + i) % items.length];
        }
        items = a;
        head = 0;
        tail = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        head = (head - 1 + items.length) % items.length; // 循环
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[tail] = item;
        tail = (tail + 1) % items.length; // 循环
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(head + i) % items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[head];
        items[head] = null; // 避免内存泄漏
        head = (head + 1) % items.length; // 循环
        size--;
        // 检查是否需要缩容
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        tail = (tail - 1 + items.length) % items.length; // 循环
        T item = items[tail];
        items[tail] = null; // 避免内存泄漏
        size--;
        // 检查是否需要缩容
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(head + index) % items.length];
    }
}    
