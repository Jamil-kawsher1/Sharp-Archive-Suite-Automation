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
    public void doLogin () throws InterruptedException, IOException, ParseException {

        homePage = new HomePage(driver);
        String filename = "./src/test/resources/UsersList.json";
        JSONObject userInfo = Utils.readJSONFile(filename, 1);
        homePage.cookieAcceptButton.get(35).click();
        homePage.doLogin((String) userInfo.get("email"), "Eb9C*f\"A2om]nP2","vialogin");
    }

    @Test(priority = 1, description = "Add New Feed To User Accounts")
    public void addFeed () throws InterruptedException {
        homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.AddFeeds();

    }

    @Test(priority = 2, description = "Upload User Profile picture",enabled = false)
    public void uploadProfilePicture () throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.profilePictureUpload();

    }
@Test(priority = 3)
    public void addressUpdate() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.addressUpdate();
        Utils.doScroll(driver,200);
        homePage.allButton.get(11).click();
    }
}
