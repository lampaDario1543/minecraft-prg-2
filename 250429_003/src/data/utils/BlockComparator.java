package data.utils;

import data.blocks.*;
import data.interfaces.Block;
import data.interfaces.IronSwordInterface;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    public BlockComparator() {}
    private int getBlockValue(final Block b){
        if(b instanceof NullBlock)
            return 0;
        else if(b instanceof AirBlock)
            return 1;
        else if(b instanceof SandBlock)
            return 2;
        else if(b instanceof WaterBlock)
            return 3;
        else if(b instanceof GlassBlock)
            return 4;
        else if(b instanceof RawIronBlock)
            return 5;
        else if(b instanceof IronSwordInterface)
            return 6;

        return -1;
    }

    public int compare(Block o1, Block o2) {
        return Integer.compare(this.getBlockValue(o1), this.getBlockValue(o2));
    }
}