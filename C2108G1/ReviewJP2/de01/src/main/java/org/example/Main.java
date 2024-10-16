package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee>  employees = new ArrayList<>();
        //ArrayList<Employee>  secondEmployees = new ArrayList<>();

        try {
            for(int i = 0; i < 3; i++) {
                System.out.println("Enter employee's information "+(i+1)+": ");
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                System.out.println("Enter id");
                int id = Integer.parseInt(bufferedReader.readLine());

                System.out.println("Enter name");
                String name = bufferedReader.readLine();

                System.out.println("Enter email");
                String email = bufferedReader.readLine();
                Employee employee = new Employee(id, name, email);
                employees.add(employee);
            }

            System.out.println("List after inserted");
            for(Employee employee: employees) {
                System.out.println(employee);
            }
            String fileName = "employee.dat";
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(employees);
            objectOut.close();

            System.out.println("Write objects to file successfully");
            System.out.println("Now read object from file");
            ObjectInputStream objectInputStream = new ObjectInputStream
                    (new FileInputStream(fileName));
            employees = (ArrayList<Employee>)objectInputStream.readObject();
            System.out.println("Load objects from file successfully");
            objectInputStream.close();

            System.out.println("List after read from file");
            for(Employee employee: employees) {
                System.out.println(employee);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}