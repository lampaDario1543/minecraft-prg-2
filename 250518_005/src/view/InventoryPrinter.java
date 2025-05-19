package view;

import data.interfaces.Block;

import java.util.ArrayList;
import java.util.Iterator;

public class InventoryPrinter implements TextPrinter {
    private Iterator<Block> blocks;
    @Override
    public void display_on_out(){
        while(blocks.hasNext()){
            Block b=blocks.next();
            b.display_in_inventory();
        }
    }
    public void update(Iterator<Block> blocks){
        this.blocks = blocks;
    }
}
