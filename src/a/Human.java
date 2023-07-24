package a;

import java.io.Serializable;
import java.util.Objects;

public class Human implements Serializable {

    public static final long serialVersionUID = -8313976862729570333L;

    private String name;
    private String lName;
    private int salary;

    public Human(String name, String lName, int salary) {
        this.name = name;
        this.salary = salary;
        this.lName = lName;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return salary == human.salary && Objects.equals(name, human.name) && Objects.equals(lName, human.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lName, salary);
    }

    @Override
    public String toString() {
        return "a.Human{" +
                "name='" + name + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
