package main.aptech;

public class Manager extends Employee implements Tax{
    private double bonus;

    public Manager(String name, int age, float salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTax() {
        //this.setSalary(this.getSalary() + this.bonus - );
        return this.getSalary() * 0.1;
    }

    @Override
    public float getSalary() {
        this.bonus = getSalary() * 0.2;
        return (float) (this.getSalary() + this.bonus - this.calculateTax());
    }
    public Manager(){}
    @Override
    public void display() {
        super.display();
        System.out.println("Bonus : "+this.bonus);

    }
}
