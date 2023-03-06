package trees.abstraction.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import trees.abstraction.treetop.Branch;
import trees.abstraction.treetop.TreetopPart;
import trees.abstraction.treetop.foliage.Foliage;
import trees.abstraction.treetop.foliage.Foliage.FoliageShape;

public abstract class Tree<T extends Foliage>  {
    
    private final Trunk trunk;
    private final List<TreetopPart> treetop;
    private final FoliageShape foliageShape;

    protected Tree(FoliageShape foliageShape, Trunk trunk, List<TreetopPart> treetop) {
        this.foliageShape = foliageShape;
        this.trunk = trunk;
        this.treetop = treetop;
    }

    protected Tree(FoliageShape foliageShape, Trunk trunk) {
        this(foliageShape, trunk, new ArrayList<>());
    }

    protected Tree(FoliageShape foliageShape) {
        this(foliageShape, new Trunk());
    }

    public abstract void addFoliageToBranch(Branch branch);

    public abstract boolean losesFoliageInWinter();

    public FoliageShape getFoliageShape() {
        return foliageShape;
    }

    public void grow() {
        treetop.forEach(TreetopPart::grow);
        treetop.add(new Branch(this));
    }

    public static class Trunk {

        float height;
        float diameter;

        public Trunk(float height, float diameter) {
            this.height = height;
            this.diameter = diameter;
        }

        public Trunk() {
            this(0f, 0f);
        }

        @Override
        public String toString() {
            return "Trunk [height=" + height + ", diameter=" + diameter + "]";
        }

    }

    @Override
    public String toString() {
        String treetopString = "[" + treetop.stream()
            .map(TreetopPart::toString)
            .collect(Collectors.joining(", ")) + "]";
        return "Tree [trunk=" + trunk + ", treetop=" + treetopString + "]";
    }

}
