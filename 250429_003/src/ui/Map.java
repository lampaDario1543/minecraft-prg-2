package ui;

import data.blocks.AbstractFallingSolidBlock;
import data.blocks.AirBlock;
import data.blocks.TorchBlock;
import data.interfaces.SmeltableBlock;
import utils.exceptions.BlockErrorException;
import utils.BlockFactory;
import data.interfaces.Block;
import utils.Coordinates;
import utils.exceptions.CoordinatesException;

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
        final int RANDOM_BLOCKS_TO_ADD = 30;
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            int x=-1,y=-1;
            try{
                do{
                    x = rand.nextInt(Coordinates.ROW);
                    y = rand.nextInt(Coordinates.COL);
                }while(!this.insert_at_coords(new Coordinates(x,y),b)); //finché non riesce ad inserire il blocco genera coordinate random
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" in X= "+x+" Y= "+y+" Map()");
            }
        }
        this.addRiver();
    }
    public Map(BlockFactory bf) {
        this.bf = bf;
        blocks = new Block[Coordinates.ROW][Coordinates.COL];
        for(int i=0; i<Coordinates.ROW; i++){
            for(int j=0; j<Coordinates.COL; j++){
                blocks[i][j] = bf.default_block();
            }
        }
        Random rand = new Random();
        final int RANDOM_BLOCKS_TO_ADD = 30;
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            int x=-1,y=-1;
            try{
                do{
                    x = rand.nextInt(Coordinates.ROW);
                    y = rand.nextInt(Coordinates.COL);
                }while(!this.insert_at_coords(new Coordinates(x,y),b)); //finché non riesce ad inserire il blocco genera coordinate random
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" in X= "+x+" Y= "+y+" Map()");
            }
        }
        this.addRiver();
    }
    public void display_on_out() {
        //grafica per la mappa
        System.out.print("  | ");
        for(int i=0; i<Coordinates.ROW; i++){
            System.out.print(i+" ");
        }
        System.out.print("|");
        System.out.println();
        System.out.print("= |");
        for(int i=0; i<(Coordinates.COL*2)+1; i++)
            System.out.print("=");
        System.out.print("|");

        System.out.println();
        for(int i=0;i<Coordinates.ROW;i++) {
            System.out.print(i+" | ");
            for (int j = 0; j < Coordinates.COL; j++)
                System.out.print(blocks[i][j].getContent()+" ");
            System.out.println("|");
        }
        System.out.print("= |");
        for(int i=0; i<(Coordinates.COL*2)+1; i++)
            System.out.print("=");
        System.out.print("|");
        System.out.println();
    }
    public boolean isSmeltable(Coordinates blockCoords) {
        return this.blocks[blockCoords.getY()][blockCoords.getX()] instanceof SmeltableBlock;
    }
    public Block getBlock(Coordinates blockCoords) throws CoordinatesException{
        if(!blockCoords.isInBound()) throw new CoordinatesException();
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
    public boolean insert_at_coords(Coordinates toInsert, Block block) throws CoordinatesException {
        System.out.println("[MAP] Inserting "+block.getBlockName()+" in "+ toInsert);
        if(!toInsert.isInBound()) throw new CoordinatesException();
        if(!(blocks[toInsert.getY()][toInsert.getX()] instanceof AirBlock)) {
            System.out.println("[MAP] You can't insert "+block.getBlockName()+" in "+ toInsert);
            return false;
        }
        blocks[toInsert.getY()][toInsert.getX()]=block; // [TODO] in futuro l'inserimento controllerà se il blocco dove si vuole piazzare il nuovo blocco è un airBlock, per ora no devo testare torchBlock
        if(block.isFalls_with_gravity()){
            int i= toInsert.getY();
            //System.out.println("--------------------------");
            //System.out.println("[DEBUG]Inserting " + toInsert);
            if(block instanceof AbstractFallingSolidBlock){
                while(i<Coordinates.ROW-1 && blocks[i+1][toInsert.getX()].isFall_through() && !(blocks[i+1][toInsert.getX()] instanceof TorchBlock)){
                    swap(new Coordinates(toInsert.getX(),i));
                    ++i;
                    /*display_on_out();
                    System.out.println();*/
                }
                if(i<Coordinates.ROW-1 && blocks[i+1][toInsert.getX()] instanceof TorchBlock)
                    blocks[i][toInsert.getX()]=bf.airBlock();
            }else{
                while(i<Coordinates.ROW-1 && blocks[i+1][toInsert.getX()].isFall_through()){
                    swap(new Coordinates(toInsert.getX(),i));
                    ++i;
                    /*display_on_out();
                    System.out.println();*/
                }
            }
        }
        return true;
    }
    public void addRowsOfWater(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<Coordinates.COL; j++){
                Block b=bf.waterBlock();
                try{
                    this.insert_at_coords(new Coordinates(j,0), b); //metto y = 0, perché tanto poi cade
                }catch(CoordinatesException e){
                    System.out.println("Can't place "+b.getBlockName()+" addRowsOfWater");
                }
            }
        }
    }
    private boolean is_pickable(Coordinates coords){
        if(!coords.isInBound()) return false;
        Block b=blocks[coords.getY()][coords.getX()];
        return b.isPickable();
    }
    public void apply_gravity_above(Coordinates coords){
        int y=coords.getY()-1;
        final int x=coords.getX(); //la x è fissata
        if(!coords.isInBound() || y==-1) return; //coordinate out of bound
        Block b=blocks[y][x]; //blocco che potrebbe avere la gravità
        if(b.isFalls_with_gravity()){
            try{
                this.insert_at_coords(new Coordinates(x,y+1),b);
                blocks[y][x]=bf.airBlock();
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" in "+ coords+" apply_gravity_above()");
            }
            this.apply_gravity_above(new Coordinates(x,y));
        }
    }
    public Block gimme_pickable(Coordinates coords) throws BlockErrorException {
        if(this.is_pickable(coords)){ //il controllo delle coordinate lo faccio già dentro a is_pickable
            Block b=blocks[coords.getY()][coords.getX()];
            blocks[coords.getY()][coords.getX()]=bf.airBlock();
            this.apply_gravity_above(coords);
            return b;
        }
        throw new BlockErrorException();

    }
    public void addRiver(){this.addRowsOfWater(1);}
    public void addSea(){this.addRowsOfWater(3);}
}