package view;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

public class FurnacePrinter implements TextPrinter {
    private SmeltableBlock input;
    private Block output;
    public void update(SmeltableBlock input, Block output) {
        this.input = input;
        this.output = output;
    }
    @Override
    public void display_on_out(){
        System.out.println("|" +this.input.toString()+"| --> |"+this.output.toString() +"|");
    }
}
