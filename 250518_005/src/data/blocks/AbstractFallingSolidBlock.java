package data.blocks;

public class AbstractFallingSolidBlock extends AbstractSolidBlock{
    public AbstractFallingSolidBlock() {
        super('.',"NULL",true,true);
    }
    public AbstractFallingSolidBlock(char content, String blockname) {
        super(content,blockname, true,true);
    }
    public AbstractFallingSolidBlock(char content, String blockname,boolean pickable) {
        super(content,blockname, true,pickable);
    }
}
