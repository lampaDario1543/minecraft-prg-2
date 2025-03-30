package ui;

import data.interfaces.SmeltableBlock;
import utils.BlockFactory;
import data.interfaces.Block;
import utils.Coordinates;

import java.util.Random;

public class Map {
    //es. 1.2.3
    private Block[][] blocks;
    private BlockFactory bf;
    public Map() {
        bf = new BlockFactory();
        blocks = new Block[Coordinates.ROW][Coordinates.COL];
        for(int i=0; i<Coordinates.ROW; i++){
            for(int j=0; j<Coordinates.COL; j++){
                blocks[i][j] = bf.default_block();
            }
        }
        Random rand = new Random();
        final int RANDOM_BLOCKS_TO_ADD = 20;
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            int x = rand.nextInt(Coordinates.ROW);
            int y = rand.nextInt(Coordinates.COL);
            this.insert_at_coords(new Coordinates(x,y   ),b);
        }
        this.addRiver();
    }
    public void display_on_out() {
        //grafica per la mappa
        for(int i=0; i<(Coordinates.COL*2)+3; i++)
            System.out.print("=");
        System.out.println();
        for(int i=0;i<Coordinates.ROW;i++) {
            System.out.print("| ");
            for (int j = 0; j < Coordinates.COL; j++)
                System.out.print(blocks[i][j].getContent()+" ");
            System.out.println("|");
        }
        for(int i=0; i<(Coordinates.COL*2)+3; i++)
            System.out.print("=");
        System.out.println();
    }
    public boolean isSmeltable(Coordinates blockCoords) {
        return this.blocks[blockCoords.getY()][blockCoords.getX()] instanceof SmeltableBlock;
    }
    public Block getBlock(Coordinates blockCoords) {
        if(!blockCoords.isInBound()) return null;
        return blocks[blockCoords.getY()][blockCoords.getX()];
    }
    //es. 1.3.2
    private void swap(Coordinates toSwap) {
        if(toSwap.getY() >= Coordinates.ROW-1 || toSwap.getX() >Coordinates.COL-1)
            return;
        //System.out.println("[DEBUG] Swapping " + toSwap + " to " + coords);
        Block temp=blocks[toSwap.getY()][toSwap.getX()];
        blocks[toSwap.getY()][toSwap.getX()]=blocks[toSwap.getY()+1][toSwap.getX()];
        blocks[toSwap.getY()+1][toSwap.getX()]=temp;
    }
    //es 1.3.2
    public void insert_at_coords(Coordinates toInsert, Block block) {
        if(!toInsert.isInBound()) return;
        blocks[toInsert.getY()][toInsert.getX()]=block;
        if(block.isFalls_with_gravity()){
            int i= toInsert.getY();
            //System.out.println("--------------------------");
            //System.out.println("[DEBUG]Inserting " + toInsert);
            while(i<Coordinates.ROW-1 && blocks[i+1][toInsert.getX()].isFall_through()){
                swap(new Coordinates(toInsert.getX(),i));
                ++i;
                /*display_on_out();
                System.out.println();*/
            }
        }
    }
    public void addRowsOfWater(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<Coordinates.COL; j++){
                Block b=bf.waterBlock();
                this.insert_at_coords(new Coordinates(j,0), b); //metto y = 0, perché tanto poi cade
            }
        }
    }
    public void addRiver(){this.addRowsOfWater(1);}
    public void addSea(){this.addRowsOfWater(3);}
}