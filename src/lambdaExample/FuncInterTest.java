package lambdaExample;

import a.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FuncInterTest {

    public static void main(String[] args) {
        List<Human> hl = new ArrayList<>();

        Function<Human, Integer> function = new Function<>() {
            @Override
            public Integer apply(Human h) {
                //difficult logic
                return h.getSalary();
            }
        };

        BiFunction<Human, Human, Integer> function2 = (Human h, Human b) -> {
            //difficult logic
            return h.getSalary();
        };

        BiFunction<Human, Human, Integer> function3 = (h, b) -> {
            //difficult logic
            return h.getSalary();
        };

        Function<Human, Integer> function4 = h -> {
            //difficult logic
            return h.getSalary();
        };

        Function<Human, Integer> function5 = h -> h.getSalary();



        Human human = new Human("a", "b", 1000);
        Integer sal = function.apply(human);
        System.out.println(sal);

    }

}
