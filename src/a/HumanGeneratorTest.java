package a;

import java.util.Collection;

public class HumanGeneratorTest {

    public static void main(String[] args) {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> generated = hg.generate(10);

        for (Human h : generated) {
            System.out.println(h);
        }
    }
}
