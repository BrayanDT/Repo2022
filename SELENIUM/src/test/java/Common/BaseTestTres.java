package Common;

import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestTres
{
    //*******INSTANCIAS *****************
    public static WebDriver driver = null;
    private DriverManager driverManager;
    private static int numberOfCase = 0;

    //**********************************
    @BeforeTest
    public void beforeTestMethod()
    {

        numberOfCase ++;
        System.out.println("Se está ejecutando el escenario Número: " + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_DRAG_AND_DROP);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void TearDown()
    {
        System.out.println("el escenario Numero " + numberOfCase + "se ejecuto correctamente");
        driverManager.quitDriver();
        
    }
}
