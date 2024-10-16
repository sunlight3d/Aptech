import com.aptech.inheritance.Circle;
import com.aptech.inheritance.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    public void testRectangleArea() {
        //int expected, int actual, String message
        Rectangle rectangle1 = new Rectangle("xx1", "red", 10, 20);
        assertEquals(200, rectangle1.getArea(), "Ham tinh dien tich bi sai");
    }
    @Test
    public void testCircleArea() {
        Circle circle1  = new Circle("xx","green", 12);
        assertEquals(452.3893,
                //circle1.getFloatArea(),
                Math.floor(circle1.getFloatArea()*10000)/10000,
                "Ham tinh dien tich Circle bi sai");
    }
}
