package trees.abstraction.treetop.foliage;

import trees.abstraction.tree.Tree;
import trees.abstraction.treetop.TreetopPart;

public abstract class Foliage extends TreetopPart {

    protected float width;

    protected Foliage(Tree<?> tree, float width, float length) {
        super(tree, length);
        this.width = width;
    }

    protected Foliage(Tree<?> tree) {
        this(tree, 0f, 0f);
    }

    public enum FoliageShape {
        LINEAR,
        OBLONG,
        LANCEOLATE,
        OVATE,
        ELLIPTICAL,
        CORDATE,
    }    

}
