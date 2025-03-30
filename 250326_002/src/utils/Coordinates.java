package utils;

public class Coordinates {
    public static final int ROW=10;
    public static final int COL=10;

    private int x, y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){
        this(0,0);
    }
    public boolean isInBound(){
        if(x>=COL || y>=ROW || x<0 || y<0)
            return false;
        return true;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString(){
        return "(x= "+x+",y="+y+")";
    }
}
