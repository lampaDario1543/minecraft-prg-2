package data.utils;

import data.blocks.*;
import data.interfaces.Block;
import data.interfaces.IronSwordInterface;
import javafx.scene.paint.Color;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    public BlockComparator() {}
    private int getBlockValue(final Block block){
        if(block instanceof NullBlock)
            return 0;
        else if(block instanceof AirBlock)
            return 1;
        else if(block instanceof SandBlock)
            return 2;
        else if(block instanceof WaterBlock)
            return 3;
        else if(block instanceof GlassBlock)
            return 4;
        else if(block instanceof RawIronBlock)
            return 5;
        else if(block instanceof IronSwordInterface)
            return 6;
        else if(block instanceof GravelBlock)
            return 7;
        else if(block instanceof DirtBlock)
            return 8;
        return -1;
    }

    public int compare(Block o1, Block o2) {
        return Integer.compare(this.getBlockValue(o1), this.getBlockValue(o2));
    }
}