package Pages;

import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class HomePage {

    //getting all Signup button list

    @FindBy(linkText = "Sign Up")
    List<WebElement> signUp;
    @FindBy(tagName = "button")
    List<WebElement> buttons;
    //User Signup Fields

    //First Name
    @FindBy(id = "first_name")
    WebElement firstName;
    //Last name
    @FindBy(id = "last_name")
    WebElement lastName;
    //Email
    @FindBy(id = "email")
    WebElement email;
    //Password
    @FindBy(id = "password")
    WebElement password;
    //Business Name
    @FindBy(id = "business_name")
    WebElement businessName;

    //Selecting options
    @FindBy(id = "selectStyleId")
    WebElement selectTag;
    public Select select;


    //cookie accept button
    @FindBy(tagName = "button")
    public List<WebElement> cookieAcceptButton;

    //terms condition checkbox

    @FindBy(className = "form-checkbox")
    List<WebElement> checkBox;

    //NEXT button
    @FindBy(className = "btn")
    WebElement nextButton;


    //otp  fields
    @FindBy(id = "otp1")
    public WebElement otp;

    // page Factory Function initialization so that null or element not found issue can avoid
    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    // all input field for generic use
    @FindBy(tagName = "input")
    List<WebElement> allInput;

    @FindBy(css = "input[placeholder='Email']")
    WebElement emailLogin;
    @FindBy(css = "input[placeholder='Password']")
    WebElement passLogin;



    //Add Feeds
    //Website Add Url
    @FindBy(css = "input[placeholder='Enter your URL']")
    WebElement websiteUrl;
    //Targeting Request Button
    @FindBy(tagName = "button")
    List <WebElement> allButton;


    //Profile Controls
    @FindBy(className = "name-color")
    WebElement profileName;

    public void signUp (String firstName, String lastName, String email, String businessName, String password, String category) throws InterruptedException, IOException, ParseException {
        Thread.sleep(3000);
        cookieAcceptButton.get(35).click();
        signUp.get(0).click();

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.businessName.sendKeys(businessName);
        selectTag.click();


        if (category.equals("Financial Services")) {
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ENTER);
        } else if (category.equals("Healthcare")) {
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            selectTag.sendKeys(Keys.ENTER);

        } else if (category.equals("Education")) {
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            selectTag.sendKeys(Keys.ENTER);
        } else if (category.equals("Government")) {
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            selectTag.sendKeys(Keys.ENTER);
        } else if (category.equals("Other")) {
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            selectTag.sendKeys(Keys.ARROW_DOWN);
            selectTag.sendKeys(Keys.ENTER);
        }
        checkBox.get(0).click();
        nextButton.click();

//        //Creating Select object
//        select = new Select(selectTag);
//        //Selecting new value
//        select.selectByIndex(1);


    }

    public void doLogin (String email,String password) throws InterruptedException {
        //login button
        buttons.get(3).click();
        Thread.sleep(3000);
        //email
        emailLogin.sendKeys(email);

        //password
        passLogin.sendKeys(password);

        //click ol login Button
        buttons.get(34).click();

    }

    public void AddFeeds() throws InterruptedException {
        Thread.sleep(8000);
        //clicking on Website add Button
        buttons.get(9).click();
        websiteUrl.sendKeys("bdnews24.com");
        Thread.sleep(500);
        //Clicking on request button
        allButton.get(7).click();
        Thread.sleep(500);
        //Clicking on back button
        allButton.get(8).click();
        Thread.sleep(1000);
        //clicking on cancel button
        allButton.get(6).click();

    }

    public void profilePictureUpload(){
        profileName.click();

    }


}
