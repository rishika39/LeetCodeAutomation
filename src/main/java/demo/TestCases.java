package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();
     

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    private java.time.Duration seconds(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seconds'");
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String title = driver.getCurrentUrl();
        if (title.toLowerCase().contains("leetcode")) {
            System.out.println("The URL of the homepage contains leetcode.");
        } else {
            System.out.println("The URL of does not contain leetcode.");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com");
        WebElement five=driver.findElement(By.xpath("//a[@href='/problemset/']"));
        five.click();
        Thread.sleep(2000);
        String title = driver.getCurrentUrl();
        if (title.toLowerCase().contains("problemset")) {
            System.out.println("The URL of the homepage contains problems.");
        } else {
            System.out.println("The URL of does not contain problems.");
        }
        // Retrieve the details of the first 5 questions
        Thread.sleep(3000); // Wait for 2 seconds (can be replaced with explicit wait)
        List<WebElement> questions=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/a"));
       for(int i=1;i<=5;i++){
          WebElement q=questions.get(i);
          String questionText = q.getText();
          String problemName = questionText.substring(questionText.indexOf(' ') + 1);
        System.out.println("Question: " + problemName);
       }
       String[] expectedTitles = {
        "Two Sum - LeetCode",
        "Add Two Numbers - LeetCode",
        "Longest Substring Without Repeating Characters - LeetCode",
        "Median of Two Sorted Arrays - LeetCode",
        "Longest Palindromic Substring - LeetCode"
    };

    for (int i = 1; i <= 5 && i < questions.size(); i++) {
        List<WebElement> qnew=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/a"));
        Thread.sleep(7000);
        WebElement q = qnew.get(i);
        q.click();
        Thread.sleep(7000); // Wait for 3 seconds to allow navigation (can be replaced with explicit wait)
       
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitles[i - 1])) { // Adjusted index to match expected titles array
            System.out.println("Title of question " + i + " is correct: " + actualTitle);
        } else {
            System.out.println("Title of question " + i + " is incorrect: " + actualTitle);
        }
        // Navigate back to the problem set page
        driver.navigate().back();
        Thread.sleep(7000); 
      //  questions = driver.findElements(By.xpath("//*[@id=\\\"__next\\\"]/div[1]/div[4]/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/a"));
    }
    System.out.println("end Test case: testCase02");
    }
    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/problemset/");
        Thread.sleep(2000);
   
    WebElement twosum=driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
    twosum.click();
    Thread.sleep(5000);
    String title = driver.getCurrentUrl();
    if (title.toLowerCase().contains("two-sum")) {
        System.out.println("The URL of the homepage contains add sum.");
    } else {
        System.out.println("The URL of does not contain add sum.");
    }
}
public  void testCase04() throws InterruptedException{
    System.out.println("Start Test case: testCase04");
    driver.get("https://leetcode.com/problems/two-sum/description/");
 Thread.sleep(7000);
 WebElement btn=driver.findElement(By.xpath("//*[@id=\"submissions_tab\"]/div[2]/div[2]"));
 btn.click();
 Thread.sleep(2000);
 WebElement login=driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
 if(login.getText().contains("Register or Sign In")){
    System.out.println("The URL of the homepage contains Register or Sign In");
    } else {
        System.out.println("The URL of does not contain Register or Sign In");
 }
}
}
