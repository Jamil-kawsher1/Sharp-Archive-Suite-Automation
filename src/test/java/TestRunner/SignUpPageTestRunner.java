package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpPageTestRunner extends Setup {

    public HomePage homePage;
    public String emailAddress;
    public Faker faker;

    public String getTempEmailAddress () throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);

        driver.get("https://mailpoof.com/");
        String name=faker.name().firstName();
        Thread.sleep(5000);
        WebElement emailElement = driver.findElement(By.tagName("input"));
        emailElement.clear();
        Thread.sleep(1000);
        emailElement.sendKeys(name+"00777");
        Thread.sleep(1000);
        driver.findElements(By.tagName("button")).get(3).click();
        Thread.sleep(1000);
        String email = name+"00777"+"@explodemail.com";
        return email;

    }


    @Test(description = "Signup with valid Info")
    public void doSignupWithValidInfo () throws InterruptedException {
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
        Thread.sleep(1000);
        driver.findElement(By.className("p-5")).click();
        Thread.sleep(2000);
     String verificationText=   driver.findElements(By.tagName("td")).get(6).getText();

        String regex = "[^0-9]+";
        String verificationCode = verificationText.replaceAll(regex, "");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        Thread.sleep(2000);
        homePage.otp.sendKeys(verificationCode);
        Thread.sleep(1000);
    }
}
