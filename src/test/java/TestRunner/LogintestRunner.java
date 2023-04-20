package TestRunner;

import Pages.HomePage;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogintestRunner extends Setup {
    public HomePage homePage;

    @Test(priority = 1, description = "Do Login With Invalid Creds")
    public void doLoginWithInvalidCreds () throws InterruptedException, IOException, ParseException {

        homePage = new HomePage(driver);

        homePage.cookieAcceptButton.get(35).click();
        homePage.doLogin("bafddg@gmail.com", "Eb9C*f\"A2om]nP2","invalid");
    }

    @Test(priority = 2, description = "Login With valid Credential")
    public void doLogin () throws InterruptedException, IOException, ParseException {

        homePage = new HomePage(driver);
        String filename = "./src/test/resources/UsersList.json";
        JSONObject userInfo = Utils.readJSONFile(filename, 1);
        Thread.sleep(5000);

        homePage.doLogin((String) userInfo.get("email"), "Eb9C*f\"A2om]nP2","valid");
    }


}
