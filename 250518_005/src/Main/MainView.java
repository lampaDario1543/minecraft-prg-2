package Main;

import data.blocks.NullBlock;
import data.interfaces.Block;
import ui.Inventory;
import utils.exceptions.BlockErrorException;
import ui.Furnace;
import data.interfaces.SmeltableBlock;
import utils.BlockFactory;
import ui.Map;
import utils.Coordinates;
import utils.exceptions.CoordinatesException;
import utils.exceptions.InventoryException;

public class MainView {
    private Furnace f;
    private Map m;
    private BlockFactory bf;
    private Inventory inv;
    public MainView(Furnace f, Map m) {
       this();
    }
    public MainView() {
        this.f = new Furnace();
        this.bf = new BlockFactory();
        this.m = new Map(bf);
        this.inv = new Inventory(bf);
    }
    public void smelt(){
        f.smelt();
    }
    public void put_smelted_in_inventory(){
        Block b= f.getOutput();
        if(!(b instanceof NullBlock)){
            inv.add_block(b);
            f.setOutput(bf.nullBlock());
        }
    }
    public void move_into_furnace(Coordinates blockToMove) {
        if(!blockToMove.isInBound())
            return;
        if(m.isSmeltable(blockToMove)) {
            try {
                Block block = m.getBlock(blockToMove);
                m.insert_at_coords(blockToMove, bf.default_block());
                f.setInput((SmeltableBlock) block);
            }catch(CoordinatesException e){
                System.out.println("[MainView] i can't place block in "+blockToMove+" (move_into_furnace())");
            }
        }else{
            System.out.println("You can't smelt the block at "+ blockToMove);
        }
    }
    public void move_into_furnace_from_inventory(int index){
        SmeltableBlock sb=null;
        try{
            sb = inv.get_smeltable_item(index);
            if(f.getInput() instanceof NullBlock){
                f.setInput(sb);
            }else{
                inv.add_block(sb);
            }
        }catch(BlockErrorException e){
            System.out.println("[MAIN_VIEW] You can't put that block into furnace");
        }catch(InventoryException e){
            System.out.println("[MAIN_VIEW] Index ("+index+") of inventory is out of bound");
        }
    }
    public void move_into_inventory_from_furnace(){
        Block b= f.getInput();
        if(!(b instanceof NullBlock)){
            inv.add_block(b);
            f.setInput(bf.nullBlock());
        }
    }
    public void pick_up_block(Coordinates coords){
        try{
            inv.add_block(m.gimme_pickable(coords));
        }catch(BlockErrorException e){
            System.out.println("[MAIN_VIEW] Block at coords " + coords + " is not pickable");
        }
    }
    public void toggle_inventory_comparator(){
        inv.toggle_comparator();
    }
    public void insertTorch(Coordinates coords){
        if(!coords.isInBound()) return;
        try{
            if(m.insert_at_coords(coords, bf.torchBlock()))
                m.apply_gravity_above(coords);
        }catch(CoordinatesException e){
            System.out.println("[MAIN_VIEW] Coordinates exception in insertTorch() "+coords);
        }
    }
    public Map getMap(){
        return m;
    }
    public Furnace getFurnace()
    {
        return f;
    }
    public Inventory getInventory(){
        return inv;
    }
}
