using System;
namespace _13_09_2021
{
    //class kieu "Java" - not-recommended
    public class Student
    {
        public String name;
        public int age;
        //contructor (java-like)
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public override string ToString() => $"name:{this.name}, age:{this.age}";
    }
}
