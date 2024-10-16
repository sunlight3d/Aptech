import com.github.javafaker.Faker;
import com.product.books.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManyBooksTime {
    private Faker faker = new Faker(Locale.ENGLISH);
    private int NUMBER_OF_SAMPLES = 1_000_000;
    private ArrayList<Book> books = new ArrayList<Book>();
    @Test
    public void insertManyBooks(){
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_SAMPLES; i++) {
//            String proId, String proName, int year, float price,
//            String type, String publisher
            Book book = new Book(
                    faker.animal().name(),
                    faker.name().name(),
                    2000 + new Random().nextInt(22),
                    100 + new Random().nextFloat(200),
                    faker.pokemon().name(),
                    faker.address().latitude());
            books.add(book);
            //book.display();
        }
        long t2 = System.currentTimeMillis();
        float totalSeconds = (t2 - t1) / 1000;
        System.out.println("totalSeconds = " + totalSeconds);
        assert (1 == 1);
        //assertEquals(8,question01.countWord(s));
    }
}
