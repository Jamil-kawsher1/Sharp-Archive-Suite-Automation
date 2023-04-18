package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    //getting all Signup button list

    @FindBy(linkText = "Sign Up")
    List <WebElement> signUp;

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





    // page Factory Function initialization so that null or element not found issue can avoid
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public void signUp(){

        signUp.get(0).click();
        //Creating Select object
        Select select = new Select(selectTag);
        //Selecting new value
        select.selectByValue("Education");

    }


}
