package Main;

import utils.Coordinates;

import java.util.Scanner;

public class Main {
    private static final int INTERACTIONS=10;
    public static void main(String[] args) {
        MainView m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row and then column, or enter '10' and then '10' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 10 && col == 10){
                m.smelt();
            }else{
                Coordinates blockToMove = new Coordinates(row, col);
                m.move_into_furnace(blockToMove);
            }
            m.display_on_out();
        }
    }
}
