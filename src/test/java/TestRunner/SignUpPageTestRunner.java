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

        driver.get("https://temp-mail.org/en/");
        Thread.sleep(5000);
        WebElement emailElement = driver.findElement(By.id("mail"));
        Thread.sleep(3000);
        String email = emailElement.getAttribute("value");
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
        Thread.sleep(1000);
        homePage.otp.sendKeys("123456");
        Thread.sleep(1000);
    }
}
