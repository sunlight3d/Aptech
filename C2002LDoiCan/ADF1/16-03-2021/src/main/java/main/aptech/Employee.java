package main.aptech;

public class Employee extends Person{
    private float salary;

    public Employee(String name, int age, float salary) {
        super(name, age);
        this.salary = salary;
    }
    public void increaseSalary(int amount){
        this.salary += amount;
    }
    public void increaseSalary(double percent){
        this.salary = (float) (this.salary * percent);
    }
    public Employee() {}
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();//hien thi name va age
        System.out.println("salary = "+this.salary);
    }
}
