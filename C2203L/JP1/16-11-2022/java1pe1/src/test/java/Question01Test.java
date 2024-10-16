import com.aptech.Question01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question01Test {
    Question01 question01 = new Question01();
    @Test
    public void testLongString() {
        String s = "Junit is working fine jiwje w je wjhewe";
        assertEquals(8,question01.countWord(s));
    }
    @Test
    public void testLongSpace() {
        String s = "          Junit working         finen jiuwew                    jijij            jeje";
        assertEquals(6,question01.countWord(s));
    }
    @Test
    public void testSpecialCharacters() {
        String s = "          你吃 了 嗎  ";
        assertEquals(3,question01.countWord(s));
    }
    @Test
    public void testVietnamese() {
        String s = "        Bạn Cường                             đi chơi  ";
        assertEquals(4,question01.countWord(s));
    }
}
