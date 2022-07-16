package Features;

import Common.BaseTest;
import Elements.ElementsLogin;
import Utils.SeleniumUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits extends BaseTest
{
    ElementsLogin elementsLogin = new ElementsLogin();
    SeleniumUtils utils = new SeleniumUtils();

    @Test
    public void waits ()
    {
        //******** IMPLICIT WAIT *******

        // Esta espera se utiliza para dar oportunidad a que cargue el navegador
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //******* EXPLICIT WAIT ********

        /*Explicits:
                    > WebDriverWait
                    > Thread.sleep();
         */

/*        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementsLogin.tapWomen));
        utils.Click(elementsLogin.TapWomen(driver));*/

        //************************* FUENT WAIT *******************
        // NoSuchElementException -> cuando no hacemos la interacción con el elemento (son errores enfocados a los elementos cuando no los encuentra)
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement element = fWait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(elementsLogin.tapWomen);
            }
        });

        Assert.assertTrue(driver.findElement(elementsLogin.tapWomen).isDisplayed());


    }



}
