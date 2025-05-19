package controller;

import ui.Inventory;
import view.InventoryPrinter;
import view.MapPrinter;

public class InventoryTextController extends AbstractTextController{
    private Inventory inventory;
    public InventoryTextController(Inventory inventory){
        this.inventory=inventory;
        tp=new InventoryPrinter();
        ((InventoryPrinter)tp).update(inventory.getInventory());
    }
    @Override
    public void updatePrinter(){
        ((InventoryPrinter)tp).update(inventory.getInventory());
    }
}
