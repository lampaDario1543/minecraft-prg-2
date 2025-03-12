package data;

public class Block {
    //es. 1.2.2
    private char content;
    //es. 1.3.1
    private final boolean falls_with_gravity;
    private final boolean fall_through;
    //es. 1.2.2
    public Block(char content, boolean falls_with_gravity, boolean fall_through) {
        this.content = content;
        this.falls_with_gravity = falls_with_gravity;
        this.fall_through = fall_through;
    }
    public Block(){
        this('.',false,true);
    }
    public char getContent() {
        return content;
    }
    public void setContent(char content) {
        this.content = content;
    }
    //es. 1.3.1
    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }
    public boolean isFall_through() {
        return fall_through;
    }
}