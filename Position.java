package assignment2;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(Position p){
        this.x = p.x;
        this.y = p.y;
    }

    public void reset(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void reset(Position p){
        this.x = p.x;
        this.y = p.y;
    }

    public static int getDistance(Position a, Position b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void moveWest(){
        this.x--;
    }

    public void moveEast(){
        this.x++;
    }

    public void moveNorth(){
        this.y--;
    }

    public void moveSouth(){
        this.y++;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position ob = (Position) o;

        if (this.x == ob.x && this.y == ob.y) {
            return true;
        }
        return false;
    }
}
