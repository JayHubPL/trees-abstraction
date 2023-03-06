package trees.abstraction.treetop.foliage;

import trees.abstraction.tree.Tree;

public class Needle extends Foliage {

    private static final float NEEDLE_LENGTH_GROWTH = 0.2f;

    public Needle(Tree<?> tree, float width, float length) {
        super(tree, width, length);
    }

    public Needle(Tree<?> tree) {
        super(tree);
    }

    @Override
    public void grow() {
        length += NEEDLE_LENGTH_GROWTH;
    }

    @Override
    public String toString() {
        String shape = owningTree.getFoliageShape().toString();
        return "Needle [width=" + width + ", length=" + length + ", shape=" + shape + "]";
    }
    
}
