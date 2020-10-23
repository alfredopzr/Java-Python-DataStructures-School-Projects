
public abstract class AbstractStack<E> implements BDDStack<E> {
    private int max;
    protected int size;

    public AbstractStack(int max) throws IllegalArgumentException {
        if (max <= 0) {
            throw new IllegalArgumentException();
        }
        this.max = max;
        this.size = 0;
    }

    public int capacity() {
        return max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void flip() {
        //get a copy of the stack
        BDDStack<E> bddStack = copy();
        //clear the stack
        this.clear();

        //push all the elements from the copied stack to this stack
        while (!bddStack.isEmpty()) {
            this.push(bddStack.pop());
        }
    }

    public BDDStack<E> copy() {
        //create two new instances of the same size
        BDDStack<E> bddStack = newInstance();
        BDDStack<E> bddStack2 = newInstance();

        //fill out the first stack from this stack
        while (!isEmpty()) {
            bddStack.push(this.pop());
        }
        //fill out second stack and this stack from the first stack, second stack has the same copy as this stack
        while (!bddStack.isEmpty()) {
            E e = bddStack.pop();
            bddStack2.push(e);
            this.push(e);
        }

        return bddStack2;
    }
}
