package gui;

import data.blocks.*;
import data.interfaces.Block;
import data.interfaces.IronSwordInterface;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.*;

import java.io.InputStream;


public class BlockPane extends StackPane{
    private Block b;
    public static final int DIM_SQUARE = 64;
    private static final String FONT_NAME = "Helvetica";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.NORMAL;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = FONT_FILL;
    private ImageView iv;
    private Text t;
    private void initialise(){
        //this.getChildren().clear();
        //this.getChildren().removeAll();
        this.getChildren().removeAll(iv,t);
        final Image texture=this.getBlockTexture();
        iv=new ImageView(texture);
        t = new Text(b.getContent()+"");
        t.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        t.setFill(FONT_FILL);
        t.setStroke(FONT_BORDER);
        this.getChildren().addAll(iv,t);
    }
    public BlockPane(Block b) {
        this.b = b;
        this.initialise();
    }
    private Image getBlockTexture(){
        InputStream stream= getClass().getResourceAsStream("assets/textures/blocks/null_block.png");
        if(b instanceof AirBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/air_block.png");
        else if(b instanceof SandBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/sand.png");
        else if(b instanceof WaterBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/water.png");
        else if(b instanceof GlassBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/glass.png");
        else if(b instanceof RawIronBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/iron_ore.png");
        else if(b instanceof IronSwordInterface)
            stream= getClass().getResourceAsStream("assets/textures/blocks/iron_sword.png");
        else if(b instanceof GravelBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/gravel.png");
        else if(b instanceof DirtBlock)
            stream= getClass().getResourceAsStream("assets/textures/blocks/dirt.png");
        if (stream == null) {
            System.err.println("NO tovato immagine");
        }
        return new Image(stream, DIM_SQUARE, DIM_SQUARE, true, true);
    }
    public void changeBlock(Block block){
        this.b = block;
        this.initialise();
    }
}
