package Main;

import data.Map;
import data.Block;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map= new Map();
        //setBlocks(map); //es. 1.2.4
        //es. 1.3.3
        Block b=new Block('S', true, false);
        Scanner scan = new Scanner(System.in);
        int x,y;
        System.out.print("Enter the x coordinate: ");
        x=scan.nextInt();
        System.out.print("Enter the y coordinate: ");
        y=scan.nextInt();
        map.insert_at_coords(x,y,b);
        map.display_on_out();
        scan.close();
    }
    //es. 1.2.4
    public static void setBlocks(Map m){
        m.display_on_out();
        Scanner scan = new Scanner(System.in);
        int b_to_insert =0;
        do{
            System.out.print("Quanti blocchi vuoi inserire: ");
            b_to_insert = scan.nextInt();
        }while(b_to_insert<=0);
        for(int i=0; i<b_to_insert; i++){
            System.out.print("Enter row: ");
            int row = scan.nextInt();

            System.out.print("Enter column: ");
            int col = scan.nextInt();

            System.out.println("Changing: "+row+" - "+col);
            m.change_cell(row,col);

            System.out.println();
            m.display_on_out();
        }
        scan.close();
        System.out.println();
    }
}
