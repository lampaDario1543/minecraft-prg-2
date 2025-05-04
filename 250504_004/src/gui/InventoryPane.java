package gui;

import data.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

import java.util.ArrayList;

public class InventoryPane extends HBox {
    private Text t;
    private HBox hb;
    public InventoryPane(){
        t= new Text("Inventory: ");
        hb= new HBox();
        hb.setSpacing(10);
        this.getChildren().addAll(t,hb);
    }
    public void addToHB(ArrayList<Block> blocks){
        for(Block b: blocks){
            hb.getChildren().add(new BlockPane(b));
        }
    }
}
