package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import org.testng.annotations.Test;

public class SignUpPageTestRunner extends Setup {

    public HomePage homePage;

    @Test(description = "Signup with valid Info")
    public void doSignupWithValidInfo () {
        homePage = new HomePage(driver);
        homePage.signUp();

    }
}
