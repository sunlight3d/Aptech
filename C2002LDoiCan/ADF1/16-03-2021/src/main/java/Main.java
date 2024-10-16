import main.aptech.Employee;
import main.aptech.Manager;
import main.aptech.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Employee eachEmployee = new Employee();
            eachEmployee.input();
            employees.add(eachEmployee);
        }
        employees.get(1).increaseSalary(10);
        employees.get(2).increaseSalary(1.5);

        ArrayList<Manager> managers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Manager eachManager = new Manager();
            eachManager.input();
            managers.add(eachManager);
        }
        ArrayList<Manager> sortedManagers = (ArrayList<Manager> )managers
                .stream()
                .sorted((Manager m1, Manager m2) -> (int) (m2.getSalary() - m1.getSalary()))
                .collect(Collectors.toList());
        sortedManagers.get(0).display();
        ArrayList<Person> persons = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Person eachPerson = new Person();
            eachPerson.input();
            persons.add(eachPerson);
        }
        persons = (ArrayList<Person>) persons
                .stream()
                .sorted((Person p1, Person p2) -> p2.getAge() - p1.getAge())
                .collect(Collectors.toList());
        for (Person person: persons) {
            person.display();
        }

    }
}
