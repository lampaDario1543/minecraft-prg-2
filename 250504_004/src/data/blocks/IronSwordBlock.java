package data.blocks;

import data.interfaces.IronSwordInterface;

class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface {
    IronSwordBlock(){
        super('/', "Iron Sword");
    }
}