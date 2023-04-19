package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import Utils.Utils;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;

public class SignUpPageTestRunner extends Setup {

    public HomePage homePage;
    public String emailAddress;
    public Faker faker;

    public String getTempEmailAddress () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);

        driver.get("https://mailpoof.com/");
        String name = faker.name().firstName();
        Thread.sleep(5000);
        WebElement emailElement = driver.findElement(By.tagName("input"));
        emailElement.clear();
        Thread.sleep(1000);
        emailElement.sendKeys(name + "00777");
        Thread.sleep(1000);
        driver.findElements(By.tagName("button")).get(3).click();
        Thread.sleep(1000);
        String email = name + "00777" + "@explodemail.com";
        return email;

    }

    public String getPhoneOTP () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
        driver.get("https://receive-sms-online.cc/Free-US-Phone-Number-13312762635");

        Thread.sleep(6000);
        //clicking on Sms refresh button
        driver.findElements(By.tagName("button")).get(1).click();
        //doing scrolling
        Utils.doScroll(driver, 300);
        Thread.sleep(4000);
        //clicking on Sms refresh button
        driver.findElements(By.tagName("button")).get(1).click();
        String verificationText = driver.findElements(By.tagName("td")).get(5).getText();
        String regex = "[^0-9]+";
        String verificationCode = verificationText.replaceAll(regex, "");
        return verificationCode;
    }


    @Test(description = "Signup with valid Info")
    public void doSignupWithValidInfo () throws InterruptedException, IOException, ParseException {
        homePage = new HomePage(driver);
        faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = getTempEmailAddress();
        System.out.println(email);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        Thread.sleep(3000);


        String businessName = faker.witcher().character();
        String password = "Eb9C*f\"A2om]nP2";
        String category = "Other";
        homePage.signUp(firstName, lastName, email, businessName, password, category);
        Thread.sleep(4000);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        Thread.sleep(5000);
        // Refresh the current window
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.className("p-5")).click();
        Thread.sleep(2000);
        String verificationText = driver.findElements(By.tagName("td")).get(6).getText();

        String regex = "[^0-9]+";
        String verificationCode = verificationText.replaceAll(regex, "");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        Thread.sleep(2000);
        homePage.otp.sendKeys(verificationCode);
        Thread.sleep(1000);
        String desiredPhoneNumber = "3312762635";
        driver.findElement((By.id("number-input"))).sendKeys(desiredPhoneNumber);
        Thread.sleep(3000);
        driver.findElements(By.tagName("button")).get(11).click();
        Thread.sleep(2000);
        String phoneOTP = getPhoneOTP();
        Thread.sleep(3000);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        Thread.sleep(2000);
        homePage.otp.sendKeys(phoneOTP);

        //payment part start here
        WebElement address = driver.findElement(By.id("autoComplete"));
        address.sendKeys("New York, NY 10036, USA");
        //filling up card info
        WebElement paymentField = driver.findElement(By.id("stripe-element-mount-point"));
        StringSelection stringSelection = new StringSelection("4242424242424242|04|2024|242");
        // Get the system clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Thread.sleep(3000);
//        paymentField.click();
        Thread.sleep(3000);

// Switch to the iframe element by index
        driver.switchTo().frame(0);
        WebElement cardNumber=driver.findElement(By.cssSelector("input[name='cardnumber']"));
        WebElement cardExp=driver.findElement(By.cssSelector("input[name='exp-date']"));
        WebElement cvc=driver.findElement(By.cssSelector("input[name='cvc']"));

        List<WebElement> cardInfo = driver.findElements(By.tagName("input"));
       cardNumber.sendKeys(Keys.CONTROL + "v");
        cardExp.sendKeys(Keys.CONTROL + "v");
        cvc.sendKeys(Keys.CONTROL + "v");
        // Switch back to the main frame
        driver.switchTo().defaultContent();


        //clicking on pay button
        driver.findElements(By.tagName("button")).get(4).click();
        Thread.sleep(10000);
        String filename = "./src/test/resources/UsersList.json";
        Utils.addIntoJsonList(filename, firstName, lastName, password, email);
//        // Find the element that contains the text "Add Feeds"
      List  <WebElement> element = driver.findElements(By.tagName("span"));
////        WebElement element = driver.findElement(By.xpath("//span[text()='Add Feeds']"));
////
//        String assertionMessage=element.get(17).getText();
//        System.out.println(assertionMessage);
//        Assert.assertTrue(assertionMessage.contains("Add Feeds"));
////        driver.findElement(By.cssSelector("span:contains('Send Code')")).click();

    }
}
