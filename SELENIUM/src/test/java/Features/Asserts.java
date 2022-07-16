package Features;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.String;

import java.util.concurrent.TimeUnit;

public class Asserts
{
    private WebDriver driver;

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es-la.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);

    }
    @Test
    public void AssertTrue()
    {

        //El Assert True se utiliza para realizar validacioones en scripts positivos
        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passContainer"));

        //Se valida que los elementos esten presentes, lo cual dará como resultado que los scripts sean pasados

        Assert.assertTrue(user.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
    }
    @Test
    public void AssertFalse() throws InterruptedException {

        //El Assert True se utiliza para realizar validacioones en scripts negativos
        WebElement user = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));

        //Se valida que los elementos esten presentes, lo cual dará como resultado que los scripts sean pasados
        user.sendKeys("djbrayandelgado@hotmail.com");
        Thread.sleep(4000);
        password.sendKeys("000000000111111112");
        Thread.sleep(4000);
        password.submit();

        WebElement mensaje = driver.findElement(By.xpath("//div[contains(text(), 'La contraseña que ingresaste es incorrecta. ')]"));

        Assert.assertFalse(mensaje.isDisplayed());

    }
    @Test
    public void AssertEquals()
    {
        //El AssertEquals realiza validaciones de iguales

        //Validación
        String expetedTitle = "Facebook - Inicia sesión o regístrate";
        Assert.assertEquals(expetedTitle, driver.getTitle());

    }
    @Test
    public void GetText() throws InterruptedException {
        //Con los metodos Get, podemos recuperar información y guardarlo en una variable
        String createAccount = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy')]")).getText();
        System.out.println(createAccount);
        Assert.assertEquals(createAccount, "Crear cuenta nueva");
        Thread.sleep(3000);
        Assert.assertEquals(createAccount.length(), 18);

    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();
    }
}
