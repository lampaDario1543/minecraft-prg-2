package controller;

import Main.MainView;
import utils.Coordinates;
import view.FurnacePrinter;
import view.InventoryPrinter;
import view.MainPrinter;
import view.MapPrinter;
import controller.MapController;

public class MainTextController extends AbstractTextController{
    private MainView view; //in realtà è un model
    private MapTextController m;
    private FurnaceTextController f;
    private InventoryTextController i;
    public MainTextController() {
        this(new MainView());
    }
    public MainTextController(MainView view) {
        this.view=view;
        tp=new MainPrinter();
        m= new MapTextController(view.getMap());
        f= new FurnaceTextController(view.getFurnace());
        i= new InventoryTextController(view.getInventory());
        this.update_and_display();
    }
    public void smelt(){
        view.smelt();
        this.update_and_display();
    }
    public void move_into_inventory_from_furnace(){
        view.move_into_inventory_from_furnace();
        this.update_and_display();
    }
    public void put_smelted_in_inventory(){
        view.put_smelted_in_inventory();
        this.update_and_display();
    }
    public void move_into_furnace_from_inventory(int index)
    {
        view.move_into_furnace_from_inventory(index);
        this.update_and_display();
    }
    public void pick_up_block(Coordinates coords){
        view.pick_up_block(coords);
        this.update_and_display();
    }
    public void toggle_inventory_comparator(){
        view.toggle_inventory_comparator();
        this.update_and_display();
    }
    @Override
    public void updatePrinter(){
        m.updatePrinter();
        f.updatePrinter();
        i.updatePrinter();
        ((MainPrinter)tp).update((MapPrinter) m.getPrinter(),(InventoryPrinter) i.getPrinter(),(FurnacePrinter) f.getPrinter());
    }
}
