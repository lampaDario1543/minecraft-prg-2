package gui;

import Main.MainView;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import ui.Map;

public class MainGui extends BorderPane {
    private MapPane map;
    private FurnacePane furnace;
    private ButtonListPane buttonList;
    private InventoryPane inventory;
    public MainGui() {
        super();
        map = new MapPane();
        furnace = new FurnacePane();
        buttonList = new ButtonListPane(this,new MainView());
        inventory = new InventoryPane();
        BorderPane.setAlignment(inventory, Pos.BOTTOM_CENTER);
        super.setCenter(map);
        super.setBottom(inventory);
        super.setLeft(buttonList);
        super.setRight(furnace);
    }
    public MainGui(MainView mv) {
        super();
        map = new MapPane(mv.getMap());
        furnace = new FurnacePane(mv.getFurnace());
        buttonList = new ButtonListPane(this,mv);
        inventory = new InventoryPane(mv.getInventory());
        super.setCenter(map);
        super.setLeft(buttonList);
        BorderPane.setAlignment(inventory, Pos.BOTTOM_CENTER);
        super.setBottom(inventory);
        super.setRight(furnace);
    }
    public MapPane getMap() {
        return map;
    }
    public void update_map(){
        map.update_map();
    }
    public void update_inv(){
        inventory.update_inventory();
    }
}
