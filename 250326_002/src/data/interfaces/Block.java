package data.interfaces;

public interface Block {
    char getContent();
    void setContent(char content);
    boolean isFalls_with_gravity();
    boolean isFall_through();
}