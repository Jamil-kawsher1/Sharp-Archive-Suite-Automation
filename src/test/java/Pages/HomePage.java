package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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


    public void signUp (String firstName, String lastName, String email, String businessName, String password, String category) throws InterruptedException {
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

    public void doLogin () throws InterruptedException {
    //login button
        buttons.get(3).click();
        Thread.sleep(3000);
    //email
        emailLogin.sendKeys("shirleycollinse7@gmail.com");

    //password
        passLogin.sendKeys("wXh4b9BYmpw9pg2@");

    //click ol login Button
        buttons.get(34).click();

    }


}
