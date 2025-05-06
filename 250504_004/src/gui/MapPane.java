package gui;

import data.blocks.AirBlock;
import data.interfaces.Block;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import ui.Map;
import utils.Coordinates;
import utils.exceptions.CoordinatesException;

public class MapPane extends GridPane {
    private Map m;
    public MapPane() {
        super();
        initialise_air();
    }
    public MapPane(Map m) {
        super();
        this.m=m;
        initialise_map();
    }
    public void initialise_map(){
        for(int i=0;i<Coordinates.ROW;i++){
            for(int j=0;j<Coordinates.COL;j++){
                try{
                    this.add(new BlockPane(m.getBlock(new Coordinates(i,j))),i,j);
                }catch(CoordinatesException e){
                    System.out.println("Error in coordinates initialise gui map");
                }
            }
        }
    }
    public void update_map(){
        for(int i=0;i<Coordinates.ROW;i++){
            for(int j=0;j<Coordinates.COL;j++){
                try{
                    Coordinates coords= new Coordinates(i,j);
                    BlockPane bp= this.get_block_at_coord(coords);
                    bp.changeBlock(m.getBlock(coords));
                }catch(CoordinatesException e){
                    System.out.println("Error in coordinates update_map gui map");
                }
            }
        }
    }
    public void initialise_air(){
        for(int i =0; i< Coordinates.ROW;i++){
            for(int j =0; j< Coordinates.COL; j++){
                this.add(new BlockPane(new AirBlock()), i,j);
            }
        }
    }
    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp.getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }
    public BlockPane get_block_at_coord(Coordinates coords) throws CoordinatesException {
        if(!coords.isInBound()) throw new CoordinatesException();
        return (BlockPane) MapPane.getElementAt(this, coords.getY(), coords.getX());
    }
    public void setCell(Coordinates coords, Block block) throws CoordinatesException {
        if(!coords.isInBound()) throw new CoordinatesException();
        BlockPane toRemove=this.get_block_at_coord(coords);
        if(toRemove==null)
            super.add(new BlockPane(block), coords.getX(), coords.getY());
        else
            toRemove.changeBlock(block);
    }
}
