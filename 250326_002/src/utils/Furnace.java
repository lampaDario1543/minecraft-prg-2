package data;

import data.blocks.BlockFactory;
import data.blocks.NullBlock;

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
    public void smelt(){
        if (!(input instanceof NullBlock)) {
            output = input.smelt();
            System.out.println("Smelting "+input.toString()+" into "+output.toString());
            this.input = bf.nullBlock();
            System.out.println("No inventory where to store the smelted "+output.toString());
        }
    }
    public void setInput(SmeltableBlock input){
        this.input=input;
    }
}
