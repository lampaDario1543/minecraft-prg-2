package gui;

import data.blocks.*;
import data.interfaces.Block;
import data.interfaces.IronSwordInterface;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.*;


public class BlockPane extends StackPane{
    private Block b;
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Helvetica";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.NORMAL;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = FONT_FILL;
    private Rectangle r;
    private Text t;
    private void initialise(){
        final Color B_COLOR=this.getBlockColor(this.b);
        r = new Rectangle(DIM_SQUARE, DIM_SQUARE);
        r.setFill(B_COLOR);
        r.setStroke(B_COLOR);
        t = new Text(b.getContent()+"");
        t.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        t.setFill(FONT_FILL);
        t.setStroke(FONT_BORDER);
        this.getChildren().addAll(r, t);
    }
    public BlockPane(Block b) {
        this.b = b;
        this.initialise();
    }
    public static Color getBlockColor(Block block){
        if(block instanceof NullBlock)
            return Color.BLACK;
        else if(block instanceof AirBlock)
            return Color.TRANSPARENT;
        else if(block instanceof SandBlock)
            return Color.YELLOW;
        else if(block instanceof WaterBlock)
            return Color.LIGHTCYAN;
        else if(block instanceof GlassBlock)
            return Color.WHITE;
        else if(block instanceof RawIronBlock)
            return Color.GRAY;
        else if(block instanceof IronSwordInterface)
            return Color.LIGHTGRAY;
        else if(block instanceof GravelBlock)
            return Color.SLATEGREY;
        else if(block instanceof DirtBlock)
            return Color.BROWN;
        return Color.BLACK;
    }
    public void changeBlock(Block block){
        this.b = block;
        this.initialise();
    }
}
