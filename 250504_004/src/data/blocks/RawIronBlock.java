package data.blocks;

import data.interfaces.IronSwordInterface;
import data.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawIronBlock(){
        super('I', "Raw iron");
    }
    @Override
    public IronSwordInterface smelt() {
        return new IronSwordBlock();
    }
}
