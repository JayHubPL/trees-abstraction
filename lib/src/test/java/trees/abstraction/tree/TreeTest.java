package trees.abstraction.tree;

import org.junit.jupiter.api.Test;

import trees.abstraction.implementation.Pine;

public class TreeTest {
    
    @Test
    void example() {
        Tree<?> pine = new Pine();
        int timesToGrow = 3;
        while (timesToGrow-- > 0) {
            System.out.println("I'm growing!");
            pine.grow();
        }
        System.out.println(pine);

    }

}
