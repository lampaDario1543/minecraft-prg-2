package controller;

import view.TextPrinter;

public abstract class AbstractTextController {
    protected TextPrinter tp;
    public abstract void updatePrinter();
    public void update_and_display(){
        this.updatePrinter();
        tp.display_on_out();
    }
    public TextPrinter getPrinter() {
        return tp;
    }
}
