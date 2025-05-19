package gui;

import Main.Main;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import utils.BlockFactory;
import utils.Coordinates;
import utils.exceptions.CoordinatesException;

public class ButtonListPane extends VBox {
    private MainController mc;
    public ButtonListPane(MainController mc) {
        super();
        this.mc = mc;
        TextField pick_x= new TextField("");
        TextField pick_y= new TextField("");
        TextField item_index= new TextField("");
        Button pickBtn= new Button("Pick");
        Button furnaceBtn= new Button("Move to Furnace");
        Button smeltBtn= new Button("Smelt");
        Button moveBackBtn= new Button("Move Back");
        Button smeltInInventoryBtn= new Button("Put smelted in inventory");
        Button toggleSorting= new Button("Toggle Sorting");

        toggleSorting.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mc.toggle_inventory_comparator();
            }
        });
        pickBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                String x_coord=pick_x.getText();
                String y_coord=pick_y.getText();
                mc.pick_up_block(new Coordinates(Integer.parseInt(x_coord),Integer.parseInt(y_coord)));
            }
        });
        furnaceBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                String index=item_index.getText();
                mc.move_into_furnace_from_inventory(Integer.parseInt(index));
            }
        });
        smeltBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                mc.smelt();
            }
        });
        smeltInInventoryBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                mc.put_smelted_in_inventory();
            }
        });
        moveBackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                mc.move_into_inventory_from_furnace();
            }
        });
        HBox pick_box= new HBox(pick_x,pick_y,pickBtn);
        HBox move_to= new HBox(item_index, furnaceBtn);
        super.getChildren().addAll(pick_box,move_to, smeltBtn,moveBackBtn,smeltInInventoryBtn,toggleSorting);
    }
}
