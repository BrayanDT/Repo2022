package Common;


import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import Features.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest
{
    //***** INSTANCIAS *****
    protected static WebDriver driver = null;
    //Login tiene que ser con el mismo nombre de su clase
    Login login = new Login();
    private DriverManager driverManager;

    @BeforeTest
    public void setup () throws InterruptedException {

        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        Thread.sleep(1000);


        // Se realiza el Login
        login.miLogin(driver);
    }

    @AfterTest
    public void teardown()
    {
        //Cierra el navegador
        driver.close();

        //Matamos la instancia
        driver.quit();

    }


}


