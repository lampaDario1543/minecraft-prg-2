package controller;

import view.MapPrinter;
import ui.Map;

public class MapTextController extends AbstractTextController{
    private Map m;
    public MapTextController(Map m){
        super();
        this.m=m;
        tp=new MapPrinter();
    }
    @Override
    public void updatePrinter(){
        ((MapPrinter)tp).update(m.getBlocks());
    }
}
