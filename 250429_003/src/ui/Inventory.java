package ui;


import data.interfaces.Block;
import data.interfaces.SmeltableBlock;
import data.utils.AlphabeticalBlockComparator;
import data.utils.BlockComparator;
import utils.exceptions.BlockErrorException;
import utils.BlockFactory;
import utils.exceptions.InventoryException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    private ArrayList<Block> blocks;
    private BlockFactory bf;
    private Comparator<Block> comparator;
    public Inventory(BlockFactory bf) {
        this.bf=bf;
        this.blocks = new ArrayList<Block>();
        comparator = new AlphabeticalBlockComparator();
    }
    public void display_in_inventory(){
        for(Block block : this.blocks){
            block.display_in_inventory();
        }
    }
    public void add_block(Block b){
        this.blocks.add(b);
        this.sort();
    }
    private boolean is_smeltable(int index){
        if(this.blocks.size() <= index || index < 0){
            return false;
        }
        return blocks.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException, InventoryException {
        if(!this.isInbound(index))
            throw new InventoryException();
        if(!this.is_smeltable(index)){
            throw new BlockErrorException();
        }
        return (SmeltableBlock) blocks.remove(index);
    }
    public void toggle_comparator(){
        if(comparator instanceof AlphabeticalBlockComparator){
            comparator = new BlockComparator();
            System.out.println("[INVENTORY] Currently using BlockComparator");
            System.out.println();
        }else{
            comparator = new AlphabeticalBlockComparator();
            System.out.println("[INVENTORY] Currently using AlphabeticalBlockComparator");
            System.out.println();
        }
        this.sort();
    }
    private boolean isInbound(int index){
        if(index<0 || index >= this.blocks.size()) return false;
        return true;
    }
    private void sort(){
        Collections.sort(this.blocks, comparator);
    }
}
