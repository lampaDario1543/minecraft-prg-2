package gui;

import Main.MainView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import utils.BlockFactory;
import utils.Coordinates;
import utils.exceptions.CoordinatesException;

import javax.swing.*;

public class ButtonListPane extends VBox {
    private MainGui mg;
    private MainView mv;
    public ButtonListPane(MainGui mg,MainView mv) {
        super();
        this.mv = mv;
        this.mg = mg;
        TextField pick_x= new TextField("");
        TextField pick_y= new TextField("");
        TextField item_index= new TextField("");
        Button pickBtn= new Button("Pick");
        Button furnaceBtn= new Button("Move to Furnace");
        Button smeltBtn= new Button("Smelt");
        Button moveBackBtn= new Button("Move Back");
        Button toggleSorting= new Button("Toggle Sorting");
        toggleSorting.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mv.toggle_inventory_comparator();
                mg.update_inv();
            }
        });
        pickBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                String x_coord=pick_x.getText();
                String y_coord=pick_y.getText();
                mv.pick_up_block(new Coordinates(Integer.parseInt(x_coord),Integer.parseInt(y_coord)));
                mg.update_map();
                mg.update_inv();
            }
        });
        HBox pick_box= new HBox(pick_x,pick_y,pickBtn);
        HBox move_to= new HBox(item_index, furnaceBtn);
        super.getChildren().addAll(pick_box,move_to, smeltBtn,moveBackBtn,toggleSorting);
    }
}
