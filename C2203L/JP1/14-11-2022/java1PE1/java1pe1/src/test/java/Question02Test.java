import com.aptech.Student;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import static java.util.Locale.TRADITIONAL_CHINESE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question02Test {
    private Faker faker = new Faker(Locale.JAPANESE);
    private FakeValuesService fakeValuesService = new FakeValuesService(
            Locale.JAPANESE, new RandomService());
    private ArrayList<HashMap> hashMapStudents = new ArrayList<HashMap>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private static int NUMBER_OF_SAMPLES = 3000;
    @Test
    public void testSomeStudents() {
        for (int i = 0; i < NUMBER_OF_SAMPLES; i++) {
            //String studentNumber, String studentName, String studentAddress, int studentAge
            String studentNumber = fakeValuesService.regexify("[a-z1-9]{10}");
            String studentName = faker.name().name();
            String studentAddress = faker.address().fullAddress();
            int studentAge = 18 + new Random().nextInt(71);
            System.out.println((i+1)+". studentNumber: "+studentNumber+
                    ",studentName: "+studentName+
                    ",studentAddress: "+studentAddress+
                    ",studentAge: "+studentAge
            );

            Student student = new Student(
                    studentNumber,
                    studentName,
                    studentAddress,
                    studentAge
            );
            students.add(student);

            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("studentNumber", studentNumber);
            hashMap.put("studentName", studentName);
            hashMap.put("studentAddress", studentAddress);
            hashMap.put("studentAge", studentAge);
            hashMapStudents.add(hashMap);
        }
        for (int i = 0; i < NUMBER_OF_SAMPLES; i++) {
            HashMap<String, Object> hashMap = hashMapStudents.get(i);
            Student student = students.get(i);
            assertEquals(hashMap.get("studentNumber"),student.getStudentNumber());
            assertEquals(hashMap.get("studentName"),student.getStudentName());
            assertEquals(hashMap.get("studentAddress"),student.getStudentAddress());
            assertEquals(hashMap.get("studentAge"),student.getStudentAge());
        }
    }
}
