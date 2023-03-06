package trees.abstraction.tree;

import trees.abstraction.treetop.Branch;
import trees.abstraction.treetop.foliage.Foliage.FoliageShape;
import trees.abstraction.treetop.foliage.Leaf;

public abstract class LeafyTree extends Tree<Leaf> {

    protected LeafyTree(FoliageShape foliageShape, Trunk trunk) {
        super(foliageShape, trunk);
    }

    protected LeafyTree(FoliageShape foliageShape) {
        super(foliageShape);
    }

    @Override
    public boolean losesFoliageInWinter() {
        return true;
    }

    @Override
    public void addFoliageToBranch(Branch branch) {
        branch.addFoliage(new Leaf(this));
    }
    
}
