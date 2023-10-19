// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
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
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb=(T[])new Object[capacity];
        first=0;
        last=0;
        fillCount=0;
        this.capacity=capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(!isFull()){
            if (isEmpty()){
                rb[last]=x;
            }else {
                last=(last+1)%capacity;
                rb[last]=x;

            }
            fillCount++;
        }else {
            throw new RuntimeException("Ring Buffer Overflow");
        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        T result = null;
        if(!isEmpty()){
            result=rb[first];
            if (fillCount==1){
                first=(first+1)%capacity;
            }
            fillCount--;
        }else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        T result=null;
        if(!isEmpty())
            result=rb[first];
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }
    private class BufferIterator implements Iterator<T>{
        private int index;

        public BufferIterator(){
            index=first;
        }
        @Override
        public boolean hasNext() {
            if(index==last)
                return false;
            else
                return true;
        }

        @Override
        public T next() {
            T result= rb[index];;

            index++;
            return result;
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.


}
