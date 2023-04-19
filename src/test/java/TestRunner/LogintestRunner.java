package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import org.testng.annotations.Test;

public class LogintestRunner extends Setup {
   public HomePage homePage;
@Test
    public void doLogin() throws InterruptedException {

        homePage=new HomePage(driver);
        homePage.cookieAcceptButton.get(35).click();
        homePage.doLogin();
    }


}
