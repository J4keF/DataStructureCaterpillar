package assignment2;

public class Region {
    private int minx;
    private int miny;
    private int maxx;
    private int maxy;

    public Region(int minx, int miny, int maxx, int maxy){
        this.minx = minx;
        this.miny = miny;
        this.maxx = maxx;
        this.maxy = maxy;
    }

    public boolean contains(Position p){
        return (p.getX() >= this.minx && p.getX() <= this.maxx && p.getY() >= this.miny && p.getY() <= this.maxy);
    }

}
