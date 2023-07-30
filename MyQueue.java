package assignment2;

public class MyQueue<E> {
    private MyDoublyLinkedList qList = new MyDoublyLinkedList();

    public MyQueue(){
        this.qList.size = 0;
    }

    public void enqueue(E e){
        this.qList.addLast(e);
    }

    public E dequeue(){
        return (E) this.qList.removeFirst();
    }

    public boolean isEmpty(){
        return this.qList.isEmpty();
    }

    public void clear(){
        while (!this.isEmpty()){
            dequeue();
        }
    }

    public boolean equals(MyQueue<E> e){
        return this.qList.equals(e.qList);
    }
}
