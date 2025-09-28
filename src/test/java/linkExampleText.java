import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class linkExampleText {
    
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml;jsessionid=node01a44afk2udw0918v0qm0skwpw66591851.node0");
        
    }

    @Test
    public  void LinkTest(){

        // 01) Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        // 02) Find my destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL without clicking"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to : " + path);


        // 03) Am I broken link ?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title =  driver.getTitle();

        if(title.contains("404")){
            System.out.println("The link is broken");
        }else {
            System.out.println("Not Broken");
        }

        driver.navigate().back();

        // 04) Duplicate link
        // homeLink.click(); // stale element not found EX: StaleElementReferenceException
        WebElement homeLink2 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink2.click();
        driver.navigate().back();


        // 05) Count page links
        List<WebElement> countFullPageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countFullPageLinks.size();
        System.out.println("Count of full page links : " + pageLinkCount);

        // 06) count layout links

        WebElement layoutElement= driver.findElement(By.className("layout-main-content"));
        List<WebElement> countLayoutLinks =  layoutElement.findElements(By.tagName("a"));
        int layoutLinkCount = countLayoutLinks.size();
        System.out.println("Count of layout links : " + layoutLinkCount);
    }

}