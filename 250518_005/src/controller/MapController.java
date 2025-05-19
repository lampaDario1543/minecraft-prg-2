package controller;

import gui.MapPane;
import ui.Map;

public class MapController implements SimpleController{
    private Map m;
    private MapPane pane;
    public MapController(Map m, MapPane pane){
        this.m = m;
        this.pane = pane;
        this.redraw();
    }
    public MapController(){
        this(new Map(), new MapPane());
    }
    @Override
    public void redraw(){
        pane.redraw(m.getBlocks());
    }
}
