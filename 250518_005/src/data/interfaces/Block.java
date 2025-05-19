package data.interfaces;

public interface Block extends InventoryBlock{
    char getContent();
    String getBlockName();
    void setContent(char content);
    boolean isFalls_with_gravity();
    boolean isFall_through();
    boolean isPickable();
}