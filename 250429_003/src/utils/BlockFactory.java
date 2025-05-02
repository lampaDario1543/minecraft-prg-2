package utils;

import data.blocks.*;
import data.interfaces.Block;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 4;
    public BlockFactory(){}

    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sand_block();
            case 2:
                return this.dirtBlock();
            case 3:
                return this.gravelBlock();
            default:
                return this.nullBlock();
        }
    }

    public AirBlock default_block(){
        return new AirBlock();
    }
    public SandBlock sand_block(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public NullBlock nullBlock(){return new NullBlock();}
    public RawIronBlock rawIronBlock(){return new RawIronBlock();}
    public AirBlock airBlock(){return new AirBlock();}
    public TorchBlock torchBlock(){return new TorchBlock();}
    public DirtBlock dirtBlock(){return new DirtBlock();}
    public GravelBlock gravelBlock(){return new GravelBlock();}
}
