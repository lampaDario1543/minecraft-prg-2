package data;

public class Map {
    //es. 1.2.3
    private static final int ROW=10;
    private static final int COL=10;
    private Block[][] blocks;
    public Map() {
        blocks = new Block[ROW][COL];
        for(int i=0;i<ROW;i++)
            for(int j=0;j<COL;j++)
                blocks[i][j] = new Block();
    }
    public void display_on_out() {
        for(int i=0;i<ROW;i++) {
            for (int j = 0; j < COL; j++)
                System.out.print(blocks[i][j].getContent());
            System.out.println();
        }
        System.out.println();
    }
    //
    public void change_cell(int x, int y) {
        if(x>ROW-1 || y<0 || y>COL-1 || y<0)
            return;
        blocks[x][y].setContent('A');
    }
    //es. 1.3.2
    private void swap(int x, int y) {
        if(x >= ROW-1 || y > COL-1)
            return;
        Block temp=blocks[x][y];
        blocks[x][y]=blocks[x+1][y];
        blocks[x+1][y]=temp;
    }
    //es 1.3.2
    public void insert_at_coords(int x, int y, Block block) {
        if(x>ROW-1 || x<0 || y>COL-1 || y<0) return;
        blocks[x][y].setContent(block.getContent());
        if(block.isFalls_with_gravity()){
            int i=x;
            while(i<ROW-1 && blocks[i+1][y].isFall_through()){
                swap(i,y);
                ++i;
            }
        }
    }
    //es. 1.3.2.1
    public void insert_rec(int x, int y, Block block) {
        if(x>ROW-1 || x<0 || y>COL-1 || y<0) return;
        blocks[x][y]=block;
        insert_rec_aux(x,y,block);
    }
    public void insert_rec_aux(int x, int y, Block block) {
        if(!block.isFalls_with_gravity() ||  x==ROW-1 || !blocks[x+1][y].isFall_through()){
            return;
        }
        swap(x,y);
        insert_rec(x+1,y,block);
    }

    //equals to insert_at_coords
    //es. 1.3.2.2
    public void insert_iter(int x, int y, Block block) {
        if(x>ROW-1 || x<0 || y>COL-1 || y<0) return;
        blocks[x][y].setContent(block.getContent());
        if(block.isFalls_with_gravity()){
            int i=x;
            while(i<ROW-1 && blocks[i+1][y].isFall_through()){
                swap(i,y);
                ++i;
            }
        }
    }
}