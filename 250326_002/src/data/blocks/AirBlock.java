package data.blocks;

public class AirBlock extends AbstractBlock {
    public AirBlock(char content, boolean falls_with_gravity, boolean fall_through, String blockname) {
        super('A', false, true, "Air");
    }
    public AirBlock(){
        super('A', false, true, "Air");
    }
}