package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsLogin
{

    //Boton Signin
    public By buttonSignin = By.xpath("//a[@class='login']");
    public WebElement ButtonSignIn (WebDriver driver)
    {
        WebElement buttonsignin = driver.findElement(buttonSignin);
        return buttonsignin;
    }

    public By inputUser = By.id("email");
    public WebElement InputUser (WebDriver driver)
    {
        WebElement inputuser = driver.findElement(inputUser);
        return inputuser;

    }

    public By inputPassword = By.id("passwd");
    public WebElement InputPassword (WebDriver driver)
    {
        WebElement inputpassword = driver.findElement(inputPassword);
        return inputpassword;
    }

    public By button_SignIn = By.id("SubmitLogin");
    public WebElement Button_SignIn (WebDriver driver)
    {
        WebElement button_signIn = driver.findElement(button_SignIn);
        return button_signIn;
    }

    public By tapWomen = By.partialLinkText("Women");
    public WebElement TapWomen (WebDriver driver)
    {
        WebElement tapwomen = driver.findElement(tapWomen);
        return tapwomen;
    }













}
