import models.Film;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.ArrayList;

public class FilmCrawl{
    private WebDriver webDriver;
    public static String url = "http://www.phimmoizz.net/";
    private String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
    private ArrayList<Film> filmList = new ArrayList<Film>();

    public void getFilms() {
        try {
            System.setProperty("webdriver.chrome.driver", this.chromeDriverPath);
            webDriver = new ChromeDriver();
            webDriver.get(this.url);
            Thread.sleep(5000);
            System.out.println("haha");
            //Tat het quang cao
            webDriver.findElement(By.xpath("//*[@id=\"uniad-zone-10\"]/a[2]")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//*[@id=\"uniad-balloon-close\"]")).click();
            Thread.sleep(1000);
            System.out.println("haha");
            ArrayList<WebElement> foundElements = (ArrayList<WebElement>)
                    webDriver.findElements(By.xpath("//*[@id=\"tabs-1\"]/li"));
            Thread.sleep(1000);
            System.out.println("haha");
            filmList.clear();
            for (WebElement element : foundElements) {
                String[] contents = element.getText().split("\n");
                String vietnameseName = contents[0];
                String englishName = contents[1];
                Double duration = Double.valueOf(contents[2].split(" ")[0]);
                Film film = new Film(vietnameseName, englishName, duration);
                filmList.add(film);
            }
            System.out.println("haha");
            webDriver.quit();
        } catch (Exception exception) {
            System.err.println("Exception = "+exception.toString());
        }

    }
}
