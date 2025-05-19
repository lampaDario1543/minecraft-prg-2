package Main;

import controller.MainController;
import controller.MainTextController;
import utils.Coordinates;

import java.util.Scanner;

public class MainText {
    public static void main(String[] args) {
        MainTextController mtc= new MainTextController();
        Scanner sc= new Scanner(System.in);
        int x,y,index;
        boolean goOn=true;
        while(goOn){
            System.out.println("0 - exit");
            System.out.println("1 - pick block");
            System.out.println("2 - move to furnace");
            System.out.println("3 - smelt");
            System.out.println("4 - put smelted in inventory");
            System.out.println("5 - toggle inventory sorting");
            switch(sc.nextInt()){
                case 0:
                    goOn=false;
                    break;
                case 1:
                    System.out.print("X= ");
                    x = sc.nextInt();
                    System.out.print("Y= ");
                    y = sc.nextInt();
                    mtc.pick_up_block(new Coordinates(x,y));
                    break;
                case 2:
                    System.out.print("Index: ");
                    index = sc.nextInt();
                    mtc.move_into_furnace_from_inventory(index);
                    break;
                case 3:
                    mtc.smelt();
                    break;
                case 4:
                    mtc.put_smelted_in_inventory();
                    break;
                case 5:
                    mtc.toggle_inventory_comparator();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
