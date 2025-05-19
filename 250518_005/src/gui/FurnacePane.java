package gui;

import data.blocks.NullBlock;
import data.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class FurnacePane extends VBox {
    private BlockPane input;
    private BlockPane output;
    public FurnacePane() {
        super();
        input= new BlockPane(new NullBlock());
        output= new BlockPane(new NullBlock());
        Text t= new Text("Furnace:");
        //formattazione di text
        Text t1= new Text("-->");
        super.getChildren().addAll(t, new HBox(input, t1, output));
    }
    public FurnacePane(Block in, Block out) {
        super();
        input= new BlockPane(in);
        output= new BlockPane(out);
        Text t= new Text("Furnace:");
        //formattazione di text
        Text t1= new Text("-->");
        super.getChildren().addAll(t, new HBox(input, t1, output));
    }
    public void redraw(Block in, Block out) {
        super.getChildren().clear();
        super.getChildren().removeAll();
        input=new BlockPane(in);
        output=new BlockPane(out);
        Text t= new Text("Furnace:");
        Text t1= new Text("-->");
        super.getChildren().addAll(t, new HBox(input, t1, output));
    }
}
