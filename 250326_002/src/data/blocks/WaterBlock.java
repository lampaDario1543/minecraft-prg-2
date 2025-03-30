package data.blocks;

public class WaterBlock extends AbstractBlock {
    public WaterBlock() {
        // 〰 \u3030
        super('\u2248', true, true, "Water");
    }
    public WaterBlock(char content, boolean falls_with_gravity, boolean fall_through, String blockname) {
        super('\u2248', true, true, "Water");
    }
}
