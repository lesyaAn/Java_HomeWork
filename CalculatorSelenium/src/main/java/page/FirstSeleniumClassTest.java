package page;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class FirstSeleniumClassTest {

    WebDriver driver;

    String calculatorUrl = "file:///Users/Macair/Desktop/Java_HomeWork/CalculatorSelenium/src/main/java/page/calculator.html";
    String amazonUrl = "https://www.amazon.de";
    String googleUrl = "https://www.google.com";
    String flipkartUrl = "https://flipkart.com";

    @Before
    public  void init(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait( 15, TimeUnit.SECONDS );
    }

    @Test
    public void testAmazon() throws InterruptedException {
        driver.get(amazonUrl);
        WebElement parameterA = driver.findElement(By.id("twotabsearchtextbox"));
        parameterA.sendKeys("phone");

        WebElement search = driver.findElement(By.xpath("//*[@id=\'nav-search\']/form/div[2]/div/input"));
        search.submit();
        Thread.sleep(3000);
    }

    @Test
    public void testGoogle() throws InterruptedException {
      driver.get(googleUrl);
      driver.findElement(By.name("q")).sendKeys("Berlin weather now");
      driver.findElement(By.name("btnK")).click();
      Thread.sleep(3000);

      List<WebElement> links = (List<WebElement>) driver.findElements(By.className("BbLFkb"));
      links.forEach((x) -> {
          System.out.println("Text " + x.getText());
          assertTrue(x.getText().toLowerCase().contains("berlin weather now"));
      });


    }


    @Test
    public void testAdditionPlus(){
        driver.get(calculatorUrl);
        WebElement parameterA = driver.findElement(By.id("a"));
        parameterA.sendKeys("10");

        WebElement parameterB = driver.findElement(By.id("b"));
        parameterB.sendKeys("20");

        WebElement operation = driver.findElement(By.id("operation"));
        operation.sendKeys("+");

        WebElement buttonCalculate = driver.findElement(By.name("calc"));
        buttonCalculate.click();



        /*
        driver.findElement(By.id("a")).sendKeys("1");
        driver.findElement(By.id("b")).sendKeys("2");
        driver.findElement(By.id("operation")).sendKeys("+");
        driver.findElement(By.id("calc")).click();
        assertTrue(driver.findElement(By.name("result")).getAttribute("value").equals("3"));
*/
    }
    @Test
    public void testAdditionMinus() {
        driver.get(calculatorUrl);
        WebElement parameterA = driver.findElement(By.id("a"));
        parameterA.sendKeys("10");

        WebElement parameterB = driver.findElement(By.id("b"));
        parameterB.sendKeys("20");

        WebElement operation = driver.findElement(By.id("operation"));
        operation.sendKeys("-");

        WebElement buttonCalculate = driver.findElement(By.name("calc"));
        buttonCalculate.click();
    }

    @Test
    public void testAdditionMlp() {
        driver.get(calculatorUrl);
        WebElement parameterA = driver.findElement(By.id("a"));
        parameterA.sendKeys("9");

        WebElement parameterB = driver.findElement(By.id("b"));
        parameterB.sendKeys("5");

        WebElement operation = driver.findElement(By.id("operation"));
        operation.sendKeys("*");

        WebElement buttonCalculate = driver.findElement(By.name("calc"));
        buttonCalculate.click();
    }

    @Test
    public void testAdditionDvs() {
        driver.get(calculatorUrl);
        WebElement parameterA = driver.findElement(By.id("a"));
        parameterA.sendKeys("10");

        WebElement parameterB = driver.findElement(By.id("b"));
        parameterB.sendKeys("20");

        WebElement operation = driver.findElement(By.id("operation"));
        operation.sendKeys("/");

        WebElement buttonCalculate = driver.findElement(By.name("calc"));
        buttonCalculate.click();
    }


    }
