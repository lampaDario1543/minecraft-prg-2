package view;

import data.interfaces.Block;
import utils.Coordinates;

public class MapPrinter implements TextPrinter {
    private Block[][] blocks;
    public MapPrinter(Block [][] blocks){
        this.blocks=blocks;
    }
    public MapPrinter(){}
    public void display_on_out() {
        //grafica per la mappa
        System.out.print("  | ");
        for (int i = 0; i < Coordinates.ROW; i++) {
            System.out.print(i + " ");
        }
        System.out.print("|");
        System.out.println();
        System.out.print("= |");
        for (int i = 0; i < (Coordinates.COL * 2) + 1; i++)
            System.out.print("=");
        System.out.print("|");

        System.out.println();
        for (int i = 0; i < Coordinates.ROW; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < Coordinates.COL; j++)
                System.out.print(blocks[i][j].getContent() + " ");
            System.out.println("|");
        }
        System.out.print("= |");
        for (int i = 0; i < (Coordinates.COL * 2) + 1; i++)
            System.out.print("=");
        System.out.print("|");
        System.out.println();
    }
    public void update(Block [][] blocks) {
        this.blocks=blocks;
    }
}
