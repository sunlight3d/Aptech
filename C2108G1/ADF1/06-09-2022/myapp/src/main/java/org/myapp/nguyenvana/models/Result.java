package org.myapp.nguyenvana.models;
public class Result {
    //init function = constructor
    public Result(float math, float physics, float chemistry) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    //fields
    private float math;
    private float physics;
    private float chemistry;

    public void showDetail(){
        System.out.println(String.format("math = %f \n physics = %f,\n chemistry = %f"
                ,this.math, this.physics, this.chemistry));
    }

    @Override
    public String toString() {
        return "Result' details is: {" +
                "math=" + math +
                ", physics=" + physics +
                ", chemistry=" + chemistry +
                '}';
    }
}
