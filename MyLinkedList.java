package assignment2;

public abstract class MyLinkedList<E> implements MyList<E>{
    protected int size;

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
