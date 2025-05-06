package Main;

import data.blocks.*;
import data.interfaces.Block;
import gui.*;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ui.Map;
import utils.Coordinates;
import javafx.application.Application;
import utils.Furnace;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application{
    private static final int INTERACTIONS=10;
    public static void main(String[] args){
        //MainView m = new MainView();
        launch(args);
        //pickingTest(m);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane mainPane = new FlowPane();
        //test for INVENTORY GUI
        /*
        ArrayList<Block> blocks = new ArrayList<Block>();
        blocks.add(new DirtBlock());
        blocks.add(new RawIronBlock());
        blocks.add(new GravelBlock());
        blocks.add(new SandBlock());
        blocks.add(new GlassBlock());
        InventoryPane inventoryPane = new InventoryPane();
        inventoryPane.addToHB(blocks);
        mainPane.getChildren().addAll(inventoryPane);
        */
        //test for MAP GUI
        Map m= new Map();
        /*MapPane mapPane = new MapPane(m);
        mainPane.getChildren().add(mapPane);
        */
        //test for FURNACE GUI
        //mainPane.getChildren().add(new FurnacePane(new SandBlock(), new GlassBlock()));

        MainView mv= new MainView();
        mainPane.getChildren().add(mv.getMainGui());
        Scene s= new Scene(mainPane, 1280,720);
        primaryStage.setTitle("Minecraft 2D");
        primaryStage.setScene(s);
        primaryStage.show();
    }
    private static void pickingTest(MainView m) {
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '10' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then '1' to place a torch");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 10){
                m.move_into_furnace_from_inventory(col);
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggle_inventory_comparator();
                }else if(col==1){
                    int x_torch = myObj.nextInt();
                    int y_torch = myObj.nextInt();
                    m.insertTorch(new Coordinates(x_torch,y_torch));
                }else {
                    m.move_into_inventory_from_furnace();
                }
            } else{
                Coordinates c = new Coordinates(row,col);
                m.pick_up_block(c);
            }
            m.display_on_out();
        }
    }
}
