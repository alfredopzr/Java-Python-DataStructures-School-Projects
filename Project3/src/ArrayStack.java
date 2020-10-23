//Alfredo Perez
//Bo Mei
//Data Structures
//March 30, 2020
//Assignment 3

import java.util.Iterator;

public class ArrayStack<E> extends AbstractStack<E> implements Iterable<E> {
    private E[] array;

    public ArrayStack(int max) throws IllegalArgumentException {
        super(max);
        array = (E[]) new Object[max];
    }

    @Override
    public void push(E element) throws NullPointerException, IllegalStateException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new IllegalStateException();
        }
        //add the element to the index and increase the size
        array[size] = element;
        size++;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        //reduce the size and return the element
        size--;
        return array[size];
    }

    @Override
    public int depth() {
        return size;
    }

    @Override
    public void clear() {
        //initialize the array again and reset the size
        array = (E[]) new Object[capacity()];
        size = 0;
    }

    @Override
    public BDDStack<E> newInstance() {
        //create new instance and return
        return new ArrayStack<>(capacity());
    }

    @Override
    public Iterator<E> iterator() {
        //return the iterator
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        //to keep track of the current element of the iterator
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            //increase the counter and return the previous element
            cursor++;
            return array[cursor - 1];
        }
    }
}
