package controller;

import gui.InventoryPane;
import ui.Inventory;
import utils.BlockFactory;

public class InventoryController implements SimpleController{
    private Inventory inv;
    private InventoryPane pane;
    public InventoryController(Inventory inv, InventoryPane pane) {
        this.inv = inv;
        this.pane = pane;
        this.redraw();
    }
    public InventoryController() {
        this(new Inventory(new BlockFactory()), new InventoryPane());
    }
    @Override
    public void redraw(){
        pane.redraw(inv.getInventory());
    }
}
