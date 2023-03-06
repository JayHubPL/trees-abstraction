package trees.abstraction.treetop.foliage;

import trees.abstraction.tree.Tree;

public class Leaf extends Foliage {

    private static final float LEAF_WIDTH_GROWTH = 0.5f;
    private static final float LEAF_LENGTH_GROWTH = 0.5f;

    public Leaf(Tree<?> tree, float width, float length) {
        super(tree, width, length);
    }

    public Leaf(Tree<?> tree) {
        super(tree);
    }

    @Override
    public void grow() {
        width += LEAF_WIDTH_GROWTH;
        length += LEAF_LENGTH_GROWTH;
    }

    @Override
    public String toString() {
        String shape = owningTree.getFoliageShape().toString();
        return "Leaf [width=" + width + ", length=" + length + ", shape=" + shape + "]";
    }

}
