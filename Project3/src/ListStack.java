//Alfredo Perez
//Bo Mei
//Data Structures
//March 30, 2020
//Assignment 3

import java.util.ArrayList;
import java.util.Iterator;

public class ListStack<E> extends AbstractStack<E> implements Iterable<E> {
    private ArrayList<E> list;

    public ListStack(int max) throws IllegalArgumentException {
        super(max);
        list = new ArrayList<>(max);
    }

    @Override
    public void push(E element) throws NullPointerException, IllegalStateException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new IllegalStateException();
        }
        //add the element and increase the size
        list.add(element);
        size++;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        //reduce the size and remove and return the element
        size--;
        return list.remove(size);
    }

    @Override
    public int depth() {
        return size;
    }

    @Override
    public void clear() {
        //initialize the list again and reset the size
        list = new ArrayList<>(capacity());
        size = 0;
    }

    @Override
    public BDDStack<E> newInstance() {
        return new ListStack<>(capacity());
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            cursor++;
            return list.get(cursor - 1);
        }
    }
}
