package ui;

import data.blocks.NullBlock;
import data.interfaces.Block;
import data.interfaces.SmeltableBlock;
import utils.BlockFactory;

public class Furnace {
    private SmeltableBlock input;
    private Block output;
    private BlockFactory bf;
    public Furnace(){
        this.bf=new BlockFactory();
        this.input = bf.nullBlock();
        this.output = bf.nullBlock();
    }
    public Block smelt(){
        if (!(input instanceof NullBlock) && (output instanceof NullBlock)) {
            output = input.smelt();
            System.out.println("Smelting "+input.toString()+" into "+output.toString());
            this.input = bf.nullBlock();
            return output;
        }
        return bf.nullBlock();
    }
    public void setInput(SmeltableBlock input){
        this.input=input;
    }
    public SmeltableBlock getInput(){
        return input;
    }
    public void setOutput(Block output){
        this.output=output;
    }
    public Block getOutput(){
        return output;
    }
}
