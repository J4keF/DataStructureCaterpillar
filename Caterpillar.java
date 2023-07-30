package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position>{

    public Caterpillar(){
        this.addLast(new Position(7, 7));
        this.size = 1;
    }

    public Position getHead(){
        return this.peekFirst();
    }

    public void eat(Position p){
        if (Position.getDistance(p, this.getHead()) == 1){
            this.addFirst(p);
        }else{
            throw new IllegalArgumentException("The position is not orthogonally adjacent to the head of the caterpillar");
        }
    }

    public void move(Position p){
        if (Position.getDistance(p, this.getHead()) == 1){
            if (this.getSize() >= 1){
                this.removeLast();
            }
            this.addFirst(p);
        }else{
            throw new IllegalArgumentException("The position is not orthogonally adjacent to the head of the caterpillar");
        }
    }

    public boolean selfCollision(Position p){
        for (Position currPos : this){
            if (currPos.equals(p)){
                return true;
            }
        }
        return false;
    }
}
