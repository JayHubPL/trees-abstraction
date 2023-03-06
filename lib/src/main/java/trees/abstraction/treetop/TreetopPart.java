package trees.abstraction.treetop;

import trees.abstraction.tree.Tree;

public abstract class TreetopPart {

    protected final Tree<?> owningTree;
    protected float length;

    protected TreetopPart(Tree<?> tree, float length) {
        this.owningTree = tree;
        this.length = length;
    }

    public abstract void grow();

}
