package aptech.nguyenvana;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String []args) {
        System.out.println("haha");
        String[] dayVietnameses = {"Thu hai", "Thu ba", "Thu tu", "Thu nam", "Thu sau", "Thu bay", "Chu nhat"};
        String[] dayEnglish = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Thread t1 = null;
        Thread t2 = null;
        Thread finalT = t2;
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        int randomEnglish = (new Random()).nextInt(dayEnglish.length - 1);
                        System.out.println("English: "+dayEnglish[randomEnglish]);
                        Thread.sleep(1000);
                        if(finalT != null){
                            finalT.join();
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error in thread1 : "+e.toString());
                    e.printStackTrace();
                }
            }
        });
        Thread finalT1 = t1;
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int randomVietnamese = (new Random()).nextInt(dayVietnameses.length - 1);
                        System.out.println("Vietnamese: "+dayVietnameses[randomVietnamese]);
                        Thread.sleep(1000);
                        finalT1.join();
                    }
                } catch (Exception e) {
                    System.err.println("Error in thread2 : "+e.toString());
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        /*
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        ArrayList<Employee> employees = new ArrayList<>();
        while (i < 3) {
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            Employee employee = new Employee(id, name, email);
            employees.add(employee);
            i++;
        }
        FileManager fileManager = new FileManager();
        fileManager.WriteObjectToFile(employees);
        ArrayList<Employee> employees2 = fileManager.ReadObjectFromFile();
        System.out.println("hahaha");
        */
    }
}
