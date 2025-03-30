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
        if(y>ROW-1 || y<0 || x>COL-1 || x<0)
            return;
        blocks[y][x].setContent('A');
    }
    //es. 1.3.2
    private void swap(int x, int y) {
        if(y >= ROW-1 || x > COL-1)
            return;
        Block temp=blocks[y][x];
        blocks[y][x]=blocks[y+1][x];
        blocks[y+1][x]=temp;
    }
    //es 1.3.2
    public void insert_at_coords(int x, int y, Block block) {
        if(y>ROW-1 || y<0 || x>COL-1 || x<0) return;
        blocks[y][x]=block;
        if(block.isFalls_with_gravity()){
            int i=y;
            while(i<ROW-1 && blocks[i+1][x].isFall_through()){
                swap(x,i);
                ++i;
            }
        }
    }
    //es. 1.3.2.1
    public void insert_rec(int x, int y, Block block) {
        if(y>ROW-1 || y<0 || x>COL-1 || x<0) return;
        blocks[y][x]=block;
        insert_rec_aux(x,y,block);
    }
    public void insert_rec_aux(int x, int y, Block block) {
        if(!block.isFalls_with_gravity() ||  y==ROW-1 || !blocks[y+1][x].isFall_through()){
            return;
        }
        swap(x,y);
        insert_rec_aux(x,y+1,block);
    }

    //equals to insert_at_coords
    //es. 1.3.2.2
    public void insert_iter(int x, int y, Block block) {
        if(y>ROW-1 || y<0 || x>COL-1 || x<0) return;
        blocks[y][x]=block;
        if(block.isFalls_with_gravity()){
            int i=y;
            while(i<ROW-1 && blocks[i+1][x].isFall_through()){
                swap(x,i);
                ++i;
            }
        }
    }
}