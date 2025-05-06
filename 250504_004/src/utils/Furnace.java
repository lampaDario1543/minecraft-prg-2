package utils;

import data.blocks.NullBlock;
import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class Furnace {
    private SmeltableBlock input;
    private Block output;
    private BlockFactory bf;
    public Furnace(){
        this.bf=new BlockFactory();
        this.input = bf.nullBlock();
        this.output = bf.nullBlock();
    }

    public void display_on_out(){
        System.out.println("|" +this.input.toString()+"| --> |"+this.output.toString() +"|");
    }
    public Block smelt(){
        if (!(input instanceof NullBlock)) {
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
    public Block getOutput(){
        return output;
    }
    public void setOutput(Block output){
        this.output=output;
    }
}
