package trees.abstraction.tree;

import trees.abstraction.treetop.Branch;
import trees.abstraction.treetop.foliage.Foliage.FoliageShape;
import trees.abstraction.treetop.foliage.Needle;

public abstract class Conifer extends Tree<Needle> {

    private final boolean loseNeedlesInWinter;

    protected Conifer(Trunk trunk, boolean loseNeedlesInWinter) {
        super(FoliageShape.LINEAR, trunk);
        this.loseNeedlesInWinter = loseNeedlesInWinter;
    }

    protected Conifer(boolean loseNeedlesInWinter) {
        this(new Trunk(), loseNeedlesInWinter);
    }

    @Override
    public boolean losesFoliageInWinter() {
        return loseNeedlesInWinter;
    }

    @Override
    public void addFoliageToBranch(Branch branch) {
        branch.addFoliage(new Needle(this));
    }

}
