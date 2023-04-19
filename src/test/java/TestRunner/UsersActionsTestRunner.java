package TestRunner;


import Pages.HomePage;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class UsersActionsTestRunner extends Setup {
    public HomePage homePage;
    @BeforeTest
    public void doLogin() throws InterruptedException, IOException, ParseException {

        homePage=new HomePage(driver);
        String filename = "./src/test/resources/UsersList.json";
        JSONObject userInfo = Utils.readJSONFile(filename, 1);
        homePage.cookieAcceptButton.get(35).click();
        homePage.doLogin((String) userInfo.get("email"), "Eb9C*f\"A2om]nP2");
    }
    @Test
    public void addFeed() throws InterruptedException {
homePage=new HomePage(driver);
homePage.AddFeeds();

    }
}
