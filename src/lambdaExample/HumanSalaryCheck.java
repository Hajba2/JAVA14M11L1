package lambdaExample;

import a.Human;

public class HumanSalaryCheck implements Predicate<Human>  {

    @Override
    public boolean check(Human o) {
        return o.getSalary() > 800;
    }

}
