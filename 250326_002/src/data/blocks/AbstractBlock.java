package data.blocks;

import data.interfaces.Block;

public abstract class AbstractBlock implements Block {
    protected char content;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockname;
    public AbstractBlock(char content, boolean falls_with_gravity, boolean fall_through, String blockname) {
        this.content = content;
        this.falls_with_gravity = falls_with_gravity;
        this.fall_through = fall_through;
        this.blockname = blockname;
    }
    public AbstractBlock(){
        this('.',false,true,"NULL");
    }
    @Override
    public char getContent() {
        return content;
    }
    @Override
    public void setContent(char content) {
        this.content = content;
    }
    //es. 1.3.1
    @Override
    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }
    @Override
    public boolean isFall_through() {
        return fall_through;
    }
    @Override
    public String toString(){
        return blockname;
    }
}