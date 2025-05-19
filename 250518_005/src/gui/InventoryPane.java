package gui;

import data.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.Iterator;

public class InventoryPane extends HBox {
    private Text t;
    private HBox hb;
    public InventoryPane(){
        t= new Text("Inventory: ");
        hb= new HBox();
        hb.setSpacing(10);
        this.getChildren().addAll(t,hb);
    }
    public void addToHB(Iterator<Block> iter){
        while(iter.hasNext()){
            Block b= iter.next();
            hb.getChildren().add(new BlockPane(b));
        }
    }
    public void redraw(Iterator <Block> iter){
        this.getChildren().clear();
        this.getChildren().removeAll(hb);
        hb= new HBox();
        hb.setSpacing(10);
        this.addToHB(iter);
        this.getChildren().addAll(t,hb);
    }
}
