package data.blocks;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock(char content, boolean falls_with_gravity, boolean fall_through, String blockname) {
        //░ \u2591 ▒ \u2592 ▓ \u2593
        super('\u2592', true, false, "Sand");
    }
    public SandBlock() {
        super('\u2592', true, false, "Sand");
    }
    @Override
    public Block smelt() {
        return new GlassBlock();
    }
}
