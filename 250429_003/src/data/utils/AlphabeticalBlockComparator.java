package data.utils;

import data.interfaces.Block;

import java.util.Comparator;
public class AlphabeticalBlockComparator implements Comparator<Block> {
    public AlphabeticalBlockComparator() {

    }
    public int compare(Block o1, Block o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
