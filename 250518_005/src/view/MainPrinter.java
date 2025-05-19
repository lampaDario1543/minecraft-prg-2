package view;

import data.interfaces.Block;
import data.interfaces.SmeltableBlock;

import java.util.ArrayList;
import java.util.Iterator;

public class MainPrinter implements TextPrinter {
    MapPrinter map;
    InventoryPrinter inv;
    FurnacePrinter f;
    @Override
    public void display_on_out(){
        //call map
        map.display_on_out();
        System.out.println();
        System.out.println("#########");
        System.out.println("#FURNACE#");
        System.out.println("#########");
        System.out.println();
        //call furnace
        f.display_on_out();
        System.out.println();
        System.out.println("###########");
        System.out.println("#INVENTORY#");
        System.out.println("###########");
        System.out.println();
        //call inventory
        inv.display_on_out();
    }
    public void update(MapPrinter map, InventoryPrinter inv, FurnacePrinter f){
        this.map=map;
        this.inv=inv;
        this.f=f;
    }
}
