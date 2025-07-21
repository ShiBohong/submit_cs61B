package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T x = rb[first];
        rb[first] = null;
        fillCount -= 1;
        first = (first + 1) % capacity;
        return x;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer is empty");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }

    // Private inner class implementing Iterator<T>
    private class RingBufferIterator implements Iterator<T> {
        private int currentPos; // Current position in the iteration
        private int remaining;  // Number of elements left to iterate

        public RingBufferIterator() {
            currentPos = first;
            remaining = last;
        }

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("Ring buffer underflow");
            }
            T item = rb[currentPos];
            currentPos = (currentPos + 1) % rb.length; // Wrap around if needed
            remaining--;
            return item;
        }
    }
}
