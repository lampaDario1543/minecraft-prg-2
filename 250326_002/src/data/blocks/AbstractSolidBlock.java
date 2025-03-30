package data.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock() {
        fall_through = false;
        falls_with_gravity = false;
    }
    public AbstractSolidBlock(char content, String blockname) {
        fall_through = false;
        falls_with_gravity = false;
        this.content = content;
        this.blockname = blockname;
    }

}