package Features;

import Common.Config;
import Elements.ElementsLogin;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
{
    private WebDriver driver;
    ElementsLogin elementsLogin = new ElementsLogin();
    SeleniumUtils utils = new SeleniumUtils();
    public void miLogin (WebDriver driver) throws InterruptedException
    {
        Thread.sleep(1000);
        //elementsLogin.ButtonSignIn(driver).click();
        utils.Click(elementsLogin.ButtonSignIn(driver));
        Thread.sleep(2000);

        //Esto sirve para realizar un desplazamiento
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0, 350)");
        Thread.sleep(2000);

        //SE DA CLIC EN EL INPUT Email address
       /*
        inputUser.click(); ******>>>> El codigo comentado de la linea 29 a la linea 32 se refactoriza con la linea 33
        inputUser.clear();
        inputUser.sendKeys(Config.user);*/
       // utils.InputFill();
        utils.InputFill(elementsLogin.InputUser(driver),Config.user);
        Thread.sleep(2000);

        //SE llena INPUT Password
        utils.InputFill(elementsLogin.InputPassword(driver),Config.password);
        Thread.sleep(2000);

        //Se da clic en el boton Sign IN
        utils.Click(elementsLogin.Button_SignIn(driver));

        utils.Click(elementsLogin.TapWomen(driver));


    }






}
