package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class SandBlock extends AbstractFallingSolidBlock implements SmeltableBlock {
    public SandBlock() {
        super('\u2592', "Sand");
    }
    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}