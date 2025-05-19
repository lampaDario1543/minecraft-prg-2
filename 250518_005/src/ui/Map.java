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

public class Map {
    //es. 1.2.3
    private Block[][] blocks;
    private BlockFactory bf;
    private static final int BLOCKS_PERCENTAGE=35; //35 % di blocchi generati
    private static final int RANDOM_BLOCKS_TO_ADD = (BLOCKS_PERCENTAGE*Coordinates.ROW*Coordinates.COL)/100; //voglio che i blocchi generati siano il 35% rispetto alla mappa
    public Map() {
        bf = new BlockFactory();
        blocks = new Block[Coordinates.ROW][Coordinates.COL];
        for(int i=0; i<Coordinates.ROW; i++){
            for(int j=0; j<Coordinates.COL; j++){
                blocks[i][j] = bf.default_block();
            }
        }
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            Coordinates coords= new Coordinates();
            try{
                do{
                    coords.randomCoords();
                }while(!this.insert_at_coords(coords,b)); //finché non riesce ad inserire il blocco genera coordinate random
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" in "+coords+" Map()");
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
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            Coordinates coords= new Coordinates();
            try{
                do{
                    coords.randomCoords();
                }while(!this.insert_at_coords(coords,b)); //finché non riesce ad inserire il blocco genera coordinate random
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" "+coords+" Map()");
            }
        }
        this.addRiver();
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
    private boolean is_pickable(Coordinates coords) throws CoordinatesException{
        if(!coords.isInBound()) throw new CoordinatesException();
        Block b=blocks[coords.getY()][coords.getX()];
        return b.isPickable();
    }
    public void apply_gravity_above(Coordinates coords) throws CoordinatesException{
        int y=coords.getY()-1;
        final int x=coords.getX(); //la x è fissata
        if(!coords.isInBound() || y==-1) throw new CoordinatesException(); //coordinate out of bound
        Block b=blocks[y][x]; //blocco che potrebbe avere la gravità
        if(b.isFalls_with_gravity()){
            try{
                this.insert_at_coords(new Coordinates(x,y+1),b);
                blocks[y][x]=bf.airBlock();
                this.apply_gravity_above(new Coordinates(x,y));
            }catch(CoordinatesException e){
                System.out.println("[MAP] I can't insert "+b.getBlockName()+" in "+ coords+" apply_gravity_above()");
            }
        }
    }
    public Block gimme_pickable(Coordinates coords) throws BlockErrorException {
        boolean is_pickable=false;
        try{
            is_pickable=this.is_pickable(coords);
        }catch(CoordinatesException e){
            System.out.println("[MAP] Invalid coordinates "+coords+" in gimme_pickable()");
        }
        if(is_pickable){ //il controllo delle coordinate lo faccio già dentro a is_pickable
            Block b=blocks[coords.getY()][coords.getX()];
            blocks[coords.getY()][coords.getX()]=bf.airBlock();
            try{
                this.apply_gravity_above(coords);
            }catch(CoordinatesException e){
                System.out.println("[MAP] Invalid coordinates "+coords+" in gimme_pickable()");
            }
            return b;
        }
        throw new BlockErrorException();
    }
    public void addRiver(){this.addRowsOfWater(1);}
    public void addSea(){this.addRowsOfWater(3);}
    public Block[][] getBlocks(){
        return blocks;
    }
}