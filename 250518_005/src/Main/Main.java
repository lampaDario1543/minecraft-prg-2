package Main;

import controller.MainController;
import gui.*;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import utils.Coordinates;
import javafx.application.Application;

import java.util.Scanner;

public class Main extends Application{
    private static final int INTERACTIONS=10;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane mainPane = new FlowPane();
        MainController mc = new MainController(new MainView());
        MainGui mg = mc.getMainGui();
        mainPane.getChildren().add(mg);
        Scene s= new Scene(mainPane, 1280,720);
        primaryStage.setTitle("Minecraft 2D");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
