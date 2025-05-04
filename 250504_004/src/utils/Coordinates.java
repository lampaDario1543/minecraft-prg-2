package utils;
import java.util.Random;

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
    public void randomCoords(){
        Random rand = new Random();
        this.x=rand.nextInt(this.ROW);
        this.y=rand.nextInt(this.COL);

    }
    @Override
    public String toString(){
        return "(x= "+x+",y="+y+")";
    }
}