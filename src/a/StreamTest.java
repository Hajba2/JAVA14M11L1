package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        //first();
        //second();
        //third();
        //fourth();
        //five();
        //six();
        seven();
    }

    private static void seven() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans1 = hg.generate(5);
        Collection<Human> humans2 = hg.generate(5);

        List<Collection<Human>> humans = new ArrayList<>();
        humans.add(humans1);
        humans.add(humans2);

        humans.stream()
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void six() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(30);

        double asDouble = humans.stream()
                .peek(System.out::println)
                .mapToLong(h -> h.getSalary())
                .average()
                .getAsDouble();

        System.out.println(asDouble);

    }

    private static void five() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(30);

        Optional<String> res = humans.stream()
                .peek(System.out::println)
                .filter(StreamTest::check)
                .sorted((h1, h2) -> h2.getSalary() - h1.getSalary())
                .map(h -> h.getSalary() + " - " + h.getName())
                .distinct()
                .skip(1)
                .limit(1)
                .findFirst();

        System.out.println("res.isPresent() = " + res.isPresent());
        System.out.println("res.get() = " + res.get());

    }

    public static boolean check(Human h) {
        return h.getSalary() > 1000;
    }

    private static void fourth() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(30);

        long res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .peek(h -> h.setlName("Goga"))
                .count();

        System.out.println(res);
    }

    private static void third() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(30);

        List<Human> res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .filter(h -> h.getSalary() < 1500)
                .filter(h -> h.getName().toLowerCase().startsWith("i"))
                .collect(Collectors.toList());

        for (Human h : res) {
            System.out.println(h);
        }
    }

    private static void second() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(30);

        List<String> res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .filter(h -> h.getSalary() < 1500)
                .filter(h -> h.getName().toLowerCase().startsWith("i"))
                .map(h -> h.getSalary() + " - " + h.getName())
                .collect(Collectors.toList());

        for (String h : res) {
            System.out.println(h);
        }
    }

    public static void first() {
        HumanGenerator hg = new HumanGenerator();

        Collection<Human> humans = hg.generate(10);


        List<Human> collect = humans.stream()
                .filter(h -> h.getSalary() > 800)
                .collect(Collectors.toList());

        List<Human> collect2 = humans.stream()
                .filter(new Predicate<Human>() {
                    @Override
                    public boolean test(Human o) {
                        return o.getSalary() > 800;
                    }
                })
                .collect(Collectors.toList());
    }
}
