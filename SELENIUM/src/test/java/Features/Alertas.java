package Features;

import Common.BaseTest;
import Utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alertas extends BaseTest
{
    WebDriverWait wait;
    SeleniumUtils utils = new SeleniumUtils();

    @Test
    public void  Alerts () throws InterruptedException {
        // INSTANCIA DE OBJETO JAVA SCRIPT
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //AECPTAR ALERTAS
        js.executeScript("alert('Notificación Activa');");
        wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.alertIsPresent());
        utils.waiting(driver,3000);
        //driver.switchTo().alert().accept();
        //utils.waiting(driver,3000);

        //DISMISS ALERTA --> lO QUE HACE ESTA FUNCION ES CANCELAR UNA ALERTA

        String alert = driver.switchTo().alert().getText();
        System.out.println("Texto de alerta: " + alert);
        driver.switchTo().alert().dismiss();


    }


}
