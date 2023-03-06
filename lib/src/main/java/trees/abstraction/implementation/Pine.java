package trees.abstraction.implementation;

import trees.abstraction.tree.Conifer;

public class Pine extends Conifer {

    public Pine(Trunk trunk) {
        super(trunk, false);
    }

    public Pine() {
        super(false);
    }
    
}
