package trees.abstraction.treetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import trees.abstraction.tree.Tree;
import trees.abstraction.treetop.foliage.Foliage;

public class Branch extends TreetopPart {

    private static final float BRANCH_LENGTH_GROWTH = 1.1f;
    private static final float BRANCH_DIAMETER_GROWTH = 0.3f;
    private static final float BRANCH_SPLIT_CHANCE = 0.5f;
    private static final float ADD_FOLIAGE_CHANCE = 0.5f;
    private static final int MIN_FOLIAGE_AMOUNT = 1;
    private static final int MAX_FOLIAGE_AMOUNT = 3;
    private static final Random RNG = new Random();
    private final List<TreetopPart> growingOut;
    private float diameter;

    public Branch(Tree<?> tree, float length, float diameter) {
        super(tree, length);
        this.diameter = diameter;
        growingOut = new ArrayList<>();
    }

    public Branch(Tree<?> tree) {
        this(tree, 0f, 0f);
    }

    public void addFoliage(Foliage foliage) {
        growingOut.add(foliage);
    }

    @Override
    public void grow() {
        length += BRANCH_LENGTH_GROWTH;
        diameter += BRANCH_DIAMETER_GROWTH;
        growingOut.forEach(TreetopPart::grow);
        tryAddingFoliage();
        tryBranchingOut();
    }

    private void tryBranchingOut() {
        if (RNG.nextFloat() >= BRANCH_SPLIT_CHANCE) {
            growingOut.add(new Branch(owningTree));
        }
    }

    private void tryAddingFoliage() {
        if (RNG.nextFloat() >= ADD_FOLIAGE_CHANCE) {
            int count = RNG.nextInt(MAX_FOLIAGE_AMOUNT) + MIN_FOLIAGE_AMOUNT;
            while (count-- > 0) {
                owningTree.addFoliageToBranch(this);
            }
        }
    }

    @Override
    public String toString() {
        String growingOutString = "[" + growingOut.stream()
            .map(TreetopPart::toString)
            .collect(Collectors.joining(", ")) + "]";
        return "Branch [diameter=" + diameter + ", growingOut=" + growingOutString + "]";
    }

}
