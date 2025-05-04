package gui;

import Main.Main;
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
    private MainGui mg;
    public ButtonListPane(MainGui mg) {
        super();
        this.mg = mg;
        TextField pick_x= new TextField("");
        TextField pick_y= new TextField("");
        TextField item_index= new TextField("");
        Button pickBtn= new Button("Pick");
        Button furnaceBtn= new Button("Move to Furnace");
        Button smeltBtn= new Button("Smelt");
        Button moveBackBtn= new Button("Move Back");
        Button toggleSorting= new Button("Toggle Sorting");

        pickBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                //TODO
            }
        });
        HBox pick_box= new HBox(pick_x,pick_y,pickBtn);
        HBox move_to= new HBox(item_index, furnaceBtn);
        super.getChildren().addAll(pick_box,move_to, smeltBtn,moveBackBtn,toggleSorting);
    }
}
