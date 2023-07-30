package assignment2;

public class MyStack<E> {
    private MyDoublyLinkedList stackList = new MyDoublyLinkedList();

    public MyStack(){
        this.stackList.size = 0;
    }

    public void push(E e){
        this.stackList.addLast(e);
    }

    public E pop(){
        return (E) this.stackList.removeLast();
    }

    public E peek(){
        return (E) this.stackList.peekLast();
    }

    public boolean isEmpty(){
        return this.stackList.isEmpty();
    }

    public void clear(){
        this.stackList.clear();
    }

    public int getSize(){
        return this.stackList.getSize();
    }




}
