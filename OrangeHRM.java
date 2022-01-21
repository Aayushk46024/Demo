import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String names[] = {"Aayush", "Sachin", "Shiphali", "Amanjeet", "Gulshan", "Purvaa", "Gunshajam"};
        String userName =  names[new Random().nextInt(names.length)];

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();



        WebElement recruitment = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
        recruitment.click();

        driver.findElement(By.className("ui-datepicker-trigger")).click();
        Thread.sleep(2000);


        List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td"));
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

        driver.findElement(By.id("btnSrch")).click();
    }
}
