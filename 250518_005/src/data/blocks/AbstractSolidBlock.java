package data.blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock() {
        super('.',false,false,"NULL", true);
    }
    public AbstractSolidBlock(char content, String blockname) {
        super(content,false,false,blockname, true);
    }
    public AbstractSolidBlock(char content, String blockname,boolean pickable) {
        super(content,false,false,blockname, pickable);
    }
    public AbstractSolidBlock(char content, String blockname,boolean falls_with_gravity,boolean pickable) {
        super(content,falls_with_gravity,false,blockname, pickable);
    }

}