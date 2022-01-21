import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Date {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.redbus.in/");

        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();

        Thread.sleep(2000);
        List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table//td"));
        int total_node = dates.size();

        for(int i =0; i<total_node; i++)
        {
            String date = dates.get(i).getText();
            if(date.equals("31"))
            {
                dates.get(i).click();
                break;
            }
        }

    }
}
