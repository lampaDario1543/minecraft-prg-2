package controller;

import ui.Furnace;
import view.FurnacePrinter;

public class FurnaceTextController extends AbstractTextController{
    private Furnace f;
    public FurnaceTextController(Furnace f){
        this.f=f;
        tp= new FurnacePrinter();
        ((FurnacePrinter)tp).update(f.getInput(), f.getOutput());
        tp=new FurnacePrinter();
    }
    @Override
    public void updatePrinter(){
        ((FurnacePrinter)tp).update(f.getInput(), f.getOutput());
    }
}
