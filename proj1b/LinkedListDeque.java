public class LinkedListDeque<T> implements Deque<T>{

    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode(T f, IntNode n, IntNode p) {
            item = f;
            next = n;
            prev = p;
        }
    }

    private int size;
    private IntNode sentinal;

    public LinkedListDeque() {
        sentinal = new IntNode(null, null, null);
        sentinal.next = sentinal;  // 指向自己
        sentinal.prev = sentinal;  // 指向自己
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size += 1;
        IntNode s = new IntNode(item, sentinal.next, sentinal);
        sentinal.next.prev = s;
        sentinal.next = s;

    }

    @Override
    public void addLast(T item) {
        size += 1;
        IntNode s = new IntNode(item, sentinal, sentinal.prev);
        sentinal.prev = s;
        s.prev.next = s;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntNode p = sentinal.next;
        while (p != sentinal) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        IntNode p = sentinal.next;
        sentinal.next.next.prev = sentinal;
        sentinal.next = sentinal.next.next;
        p.prev = null;
        p.next = null;
        return p.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        IntNode p = sentinal.prev;
        sentinal.prev.prev.next = sentinal;
        sentinal.prev = sentinal.prev.prev;
        p.prev = null;
        p.next = null;
        return p.item;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        IntNode p = sentinal;
        for (int j = index; j >= 0; j--) {
            p = p.next;
        }
        return p.item;
    }

    /// 易错点1
    private T getRecursiveHelper(int index, IntNode current) {
        // 如果当前是哨兵节点（链表结束）或 index 越界
        if (current == sentinal || index < 0) {
            return null;
        }
        // 找到目标位置
        if (index == 0) {
            return current.item;
        }
        // 递归移动到下一个节点，同时减少 index
        return getRecursiveHelper(index - 1, current.next);
    }

    public T getRecursive(int index) {
        if (index < 0 || isEmpty()) {
            return null;
        }
        // 从哨兵的下一个节点开始递归
        return getRecursiveHelper(index, sentinal.next);
    }

}

