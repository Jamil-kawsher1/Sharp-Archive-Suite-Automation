package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class SignUpPageTestRunner extends Setup {

    public HomePage homePage;
public Faker faker;
    @Test(description = "Signup with valid Info")
    public void doSignupWithValidInfo () throws InterruptedException {
        homePage = new HomePage(driver);
faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email;
        String businessName=faker.witcher().character();
        String password="Eb9C*f\"A2om]nP2";
        String category="Other";
        homePage.signUp(firstName,lastName,  email="badhon0777@gmail.com",businessName,password,category);
        Thread.sleep(1000);
        homePage.otp.sendKeys("123456");
        Thread.sleep(1000);
    }
}
