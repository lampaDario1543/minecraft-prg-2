package data.blocks;

import data.interfaces.SmeltableBlock;
import data.interfaces.Block;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super('.', "NULL", false);
    }
    public Block smelt(){
        return new NullBlock();
    }
}
