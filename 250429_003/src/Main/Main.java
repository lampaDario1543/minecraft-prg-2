package Main;

import utils.Coordinates;

import java.util.Scanner;

public class Main {
    private static final int INTERACTIONS=10;
    public static void main(String[] args) {
        MainView m = new MainView();
        pickingTest(m);
        /*for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row and then column, or enter '10' and then '10' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 10 && col == 10){
                m.smelt();
                m.display_inv();
            }else{
                Coordinates blockToMove = new Coordinates(row, col);
                m.move_into_furnace(blockToMove);
            }
            m.display_on_out();
        }*/
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
