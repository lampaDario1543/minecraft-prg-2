package Main;

import data.interfaces.Block;
import utils.Furnace;
import data.interfaces.SmeltableBlock;
import utils.BlockFactory;
import ui.Map;
import utils.Coordinates;

public class MainView {
    private Furnace f;
    private Map m;
    private BlockFactory bf;
    public MainView(Furnace f, Map m) {
       this();
    }
    public MainView() {
        this.f = new Furnace();
        this.m = new Map();
        this.bf = new BlockFactory();
    }
    public void display_on_out() {
        m.display_on_out();
        System.out.println();
        System.out.println("#########");
        System.out.println("#FURNACE#");
        System.out.println("#########");
        System.out.println();
        f.display_on_out();
    }
    public void smelt(){
        f.smelt();
    }
    public void move_into_furnace(Coordinates blockToMove) {
        if(!blockToMove.isInBound())
            return;
        if(m.isSmeltable(blockToMove)) {
            Block block = m.getBlock(blockToMove);
            m.insert_at_coords(blockToMove, bf.default_block());
            f.setInput((SmeltableBlock) block);
        }else{
            System.out.println("You can't smelt the block " + m.getBlock(blockToMove)+" at "+ blockToMove);
        }
    }
}
