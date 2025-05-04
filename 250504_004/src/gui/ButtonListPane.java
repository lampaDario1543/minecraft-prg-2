package gui;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
        Button b= new Button("Random Block");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae){
                MapPane mapPane= mg.getMap();
                Coordinates coords= new Coordinates(0,0);
                /*try{
                    mapPane.setCell(coords, new BlockFactory().sand_block());
                } catch (CoordinatesException e) {
                    System.out.println("Coordinate non valide in setSand (ButtonListPane)");
                }*/
                try{
                    coords.randomCoords();
                    mapPane.setCell(coords, new BlockFactory().random_block());
                    //PUNTO 2.3 DA FARE
                }catch(CoordinatesException e){
                    System.out.println("Coordinate non valide in setRandom "+coords+" (ButtonListPane)");
                }
            }
        });
        super.getChildren().add(b);
    }
}
