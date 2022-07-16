package test.java.Features;
import Common.Config;

import Elements.ElementsSelects;
import Features.Login;
import Utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Reportes
{
    public static WebDriver driver = null;
    Login login = new Login();
    private DriverManager driverManager;
    private static int numberOfCase = 0;
    static ExtentReports report;
    static ExtentTest test;
    SeleniumUtils utils = new SeleniumUtils();
    ElementsSelects elementsSelects = new ElementsSelects();

    @BeforeTest
    public void setUp () throws InterruptedException {
        numberOfCase ++;
        System.out.println("Se esta ejecutando el escenario numero:" + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        report = new ExtentReports("C:\\Users\\BDELGADO\\OneDrive - Capgemini\\Desktop\\Automation\\SELENIUM\\Reports\\report.html", true);
        test = report.startTest("Automation Report");

        //Login
        login.miLogin(driver);
                    test.log(LogStatus.INFO, "Se realizo correctamente el login");


    }

    @Test
    public void ListaConclicks() throws Exception {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver,2000);

        //***** SELECCIONAR OPCIONEESA DE LISTAS CON CLICK*********
        //NO SE RECOMIENDA UTILIZAR DAR CLICKS EN LAS OPCIONES DE UN SELECT

        utils.Click(elementsSelects.SelectSort(driver));
        utils.waiting(driver,3000);

        String opcionEsperada = "In stock";
        String opcionBuscar = String.format("//option[text()='%s']",opcionEsperada);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        utils.Click(option);
        utils.waiting(driver,3000);
                    test.log(LogStatus.PASS, test.addScreenCapture(utils.getScreenshot(driver, "Screen_0001"))+ "Se selecciona correctamente usando Clicks");


    }

    @Test
    public void ListaConSendKeys () throws InterruptedException {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver,2000);

        //*************MANEJO DE LISTAS CON SEND KEYS************
        //************* Esta opción es recomendable *************
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver).sendKeys(opcionEsperada);
        utils.waiting(driver,3000);
                    test.log(LogStatus.PASS, "Se selecciona correctamente usando Sendkeys");

    }

    @Test
    public void ListaUsandoClaseSelec () throws InterruptedException {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver,2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver,2000);

        //********* MANEJO DE LISTAS CON CLASE SELECT **************
        //********* ESTA OPCION ES LA MÁS RECOMENDADA

        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver);
        Select selectLista = new Select(elementsSelects.SelectSort(driver));
        //selectLista.selectByVisibleText(opcionEsperada);
        //selectLista.selectByValue("price:desc");
        selectLista.selectByIndex(6);

        utils.waiting(driver,3000);
                    test.log(LogStatus.FAIL, "Se selecciona incorrectamente usando ClaseSelect");




    }
    @AfterTest
    public void TearDown()
    {
      driverManager.quitDriver();
      report.endTest(test);
      report.flush();
    }
}
