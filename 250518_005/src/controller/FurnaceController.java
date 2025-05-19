package controller;

import data.blocks.SandBlock;
import gui.FurnacePane;
import utils.Furnace;

import java.util.Scanner;

public class FurnaceController implements SimpleController {
    private Furnace f;
    private FurnacePane fp;
    public FurnaceController(Furnace f, FurnacePane fp) {
        this.f=f;
        this.fp=fp;
        this.redraw();
    }
    public FurnaceController() {
        this(new Furnace(), new FurnacePane());
    }
    @Override
    public void redraw() {
        fp.redraw(f.getInput(),f.getOutput());
    }
}
