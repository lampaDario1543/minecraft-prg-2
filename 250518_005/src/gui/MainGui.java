package gui;

import controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import ui.Map;

public class MainGui extends BorderPane {
    private MapPane map;
    private FurnacePane furnace;
    private ButtonListPane buttonList;
    private InventoryPane inventory;
    private MainController mc;
    public MainGui() {
        super();
        map = new MapPane();
        furnace = new FurnacePane();
        mc=new MainController();
        buttonList = new ButtonListPane(mc);
        inventory = new InventoryPane();
        BorderPane.setAlignment(inventory, Pos.BOTTOM_CENTER);
        super.setCenter(map);
        super.setBottom(inventory);
        super.setLeft(buttonList);
        super.setRight(furnace);
    }
    public MainGui(MainController mc) {
        super();
        this.mc=mc;
        buttonList = new ButtonListPane(mc);
        map = new MapPane();
        furnace = new FurnacePane();
        inventory = new InventoryPane();
        BorderPane.setAlignment(inventory, Pos.BOTTOM_CENTER);
        super.setCenter(map);
        super.setBottom(inventory);
        super.setLeft(buttonList);
        super.setRight(furnace);
    }
    public MainGui(Map m) {
        super();
        map = new MapPane();
        furnace = new FurnacePane();
        inventory = new InventoryPane();
        super.setCenter(map);
        super.setLeft(buttonList);
        BorderPane.setAlignment(inventory, Pos.BOTTOM_CENTER);
        super.setBottom(inventory);
        super.setRight(furnace);
    }
    public MapPane getMapPane() {
        return map;
    }
    public FurnacePane getFurnacePane() {
        return furnace;
    }
    public InventoryPane getInventoryPane() {
        return inventory;
    }
}
