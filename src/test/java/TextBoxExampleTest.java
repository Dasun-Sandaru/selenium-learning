import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node014qf3p46bjzh31hbzjhiqlaxjs6595797.node0");
        Thread.sleep(3000);

    }

    @Test
    public void textBoxTests(){

        // 01) Type your name
        WebElement nameBox = driver.findElement(By.id("j_idt88:name"));
        nameBox.sendKeys("Dasun");


        // 02) Append Country to this City
        WebElement cityBox = driver.findElement(By.id("j_idt88:j_idt91"));
        cityBox.sendKeys(" Chennai");   // append


        // 03) Verify if text box is disabled
        WebElement disabledBox = driver.findElement(By.id("j_idt88:j_idt93"));
        boolean isEnabled = disabledBox.isEnabled();
        System.out.println("Textbox enabled? " + isEnabled);


        // 04) Clear the typed text

        //*[@id="j_idt88:j_idt95"]
        WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();


        // 05) Retrieve the typed text
        WebElement typedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = typedText.getAttribute("value");
        System.out.println("The typed value is :" + value);


        // 06) Type email and Tab. Confirm control moved to next element
        WebElement emailBox = driver.findElement(By.id("j_idt88:j_idt99"));
        emailBox.sendKeys("abc@gmail.com");
        emailBox.sendKeys(Keys.TAB);


        // 07) Just press Enter and confirm error message - "Age is mandatory"
        // locate the Age textbox
        WebElement ageBox = driver.findElement(By.id("j_idt106:thisform:age"));

        // just press Enter without typing
        ageBox.sendKeys(Keys.ENTER);

        // locate the error message
        WebElement errorMsg = driver.findElement(By.id("j_idt106:thisform:j_idt110_error-detail"));

        // retrieve text
        String actualMessage = errorMsg.getText();

        // assert
        Assert.assertEquals(actualMessage, "Age is mandatory");

    }

}
