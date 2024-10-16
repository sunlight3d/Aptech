import aptech.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("haha");
        System.out.println("haha");
        //Init object from interface? NO
        //IPlayable mrA = new Playable();
        //Init "anonymous object" from Interface? YES
        //hay gap trong xu ly button, trong Jquery luc bam vao button(onClick)
//        IPlayable mrA = new IPlayable() {
//            @Override
//            public void playAGame(String gameName) {
//
//            }
//
//            @Override
//            public void playFootball() {
//
//            }
//        };
//        Student studentA = new Student();
//        studentA.gotoLibrary();
//        studentA.playAGame("game abc");
//        studentA.buyABook("C++ for beginners");
//        studentA.playFootball();
        //thuc te nen gop lam 1
        ArrayList<Person> persons = new ArrayList<Person>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Manager> managers = new ArrayList<Manager>();
        for(int i = 0; i < 3;i++) {
            Person person = new Person();
            Employee employee = new Employee();
            Manager manager = new Manager();
            person.input();
            employee.input();
            manager.input();
            persons.add(person);
            employees.add(employee);
            managers.add(manager);
        }
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge() - person2.getAge();
            }
        });
        employees.get(1).increaseSalary(10);//overloading function
        employees.get(2).increaseSalary(0.1);
        //tu Java8, co the dung lambda expression
        employees.sort((Employee employee1, Employee employee2) ->
                employee1.getSalary() - employee2.getSalary());
        for(int i = 0; i < managers.size(); i++) {
            Manager manager = managers.get(i);
            manager.calculateTax();
            manager.display();
        }
    }
}
