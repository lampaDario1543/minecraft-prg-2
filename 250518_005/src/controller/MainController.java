package controller;

import Main.MainView;
import gui.MainGui;
import utils.Coordinates;

import java.util.ArrayList;

public class MainController implements SimpleController{
    MainView view;
    MainGui gui;
    ArrayList<SimpleController> controllerList;
    public MainController(MainView view) {
        this.view = view;
        this.gui = new MainGui(this);
        this.controllerList = new ArrayList<SimpleController>();
        controllerList.add(new MapController(view.getMap(), gui.getMapPane()));
        controllerList.add(new FurnaceController(view.getFurnace(), gui.getFurnacePane()));
        controllerList.add(new InventoryController(view.getInventory(), gui.getInventoryPane()));
        this.redraw();
    }
    public MainController() {
        this(new MainView());
    }
    public void smelt(){
        view.smelt();
        controllerList.get(1).redraw();
    }
    public void move_into_inventory_from_furnace(){
        view.move_into_inventory_from_furnace();
        controllerList.get(1).redraw();
        controllerList.get(2).redraw();
    }
    public void put_smelted_in_inventory(){
        view.put_smelted_in_inventory();
        controllerList.get(1).redraw();
        controllerList.get(2).redraw();
    }
    public void move_into_furnace_from_inventory(int index)
    {
        view.move_into_furnace_from_inventory(index);
        controllerList.get(1).redraw();
        controllerList.get(2).redraw();
    }
    public void pick_up_block(Coordinates coords){
        view.pick_up_block(coords);
        controllerList.get(0).redraw();
        controllerList.get(2).redraw();
    }
    public void toggle_inventory_comparator(){
        view.toggle_inventory_comparator();
        controllerList.get(2).redraw();
    }
    @Override
    public void redraw(){
        for (SimpleController controller : controllerList){
            controller.redraw();
        }
    }
    public MainGui getMainGui() {
        return gui;
    }
}
