package gui;

import data.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import ui.Inventory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.paint.Color;

public class InventoryPane extends HBox {
    private Text t;
    private HBox hb;
    private Inventory inv;
    public InventoryPane(){
        t= new Text("Inventory: ");
        hb= new HBox();
        hb.setSpacing(10);
        this.getChildren().addAll(t,hb);
    }
    public InventoryPane(Inventory inv){
        this.inv = inv;
        t= new Text("Inventory: ");
        hb= new HBox();
        hb.setSpacing(10);
        this.init();

        this.getChildren().addAll(t,hb);
    }
    public void init(){
        hb.getChildren().clear();
        Iterator <Block> iter= inv.getInventory();
        while(iter.hasNext()){
            Block b= iter.next();
            hb.getChildren().add(new BlockPane(b));
        }
    }
    public void update_inventory(){
        this.init();
    }
}
