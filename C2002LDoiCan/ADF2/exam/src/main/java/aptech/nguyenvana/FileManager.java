package aptech.nguyenvana;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String filepath="C:\\temp\\employee.dat";
    public void WriteObjectToFile(ArrayList<Employee> employees) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Employee employee: employees) {
                objectOut.writeObject(employee);
            }
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Employee> ReadObjectFromFile() {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while(true){
                Employee employee = (Employee)objectIn.readObject();
                result.add(employee);
            }
        } catch (Exception ex) {
            return result;
        }
    }
}
