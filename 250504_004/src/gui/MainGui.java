package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import ui.Map;

public class MainGui extends BorderPane {
    private MapPane map;
    private FurnacePane furnace;
    private ButtonListPane buttonList;
    public MainGui() {
        super();
        map = new MapPane();
        furnace = new FurnacePane();
        buttonList = new ButtonListPane(this);
        super.setCenter(map);
        super.setLeft(buttonList);
        super.setRight(furnace);
    }
    public MainGui(Map m) {
        super();
        map = new MapPane(m);
        furnace = new FurnacePane();
        buttonList = new ButtonListPane(this);
        super.setCenter(map);
        super.setLeft(buttonList);
        super.setRight(furnace);
    }
    public MapPane getMap() {
        return map;
    }
}
