package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiPrimerTest
{
    private WebDriver driver;

    @BeforeTest
    public void setup () throws InterruptedException {
        //se coloca la dirección del driver, sea chrome, mozilla, opera, safari
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");

        //se crea la instancia u objeto del Navegador
        driver = new ChromeDriver();

        //Maximiza el navegador
        driver.manage().window().maximize();

        //Enviamos la url al navergador
        driver.get("https://www.amazon.com.mx/");

        Thread.sleep(2000);
    }

    @Test
   public void testAmazon() throws InterruptedException {
        /*Primero Identificar el elemento, es de suma importancia tener instanciado un elemento de tipo WebElement, de lo contrario no podremos buscan en DOM
        ni tampoco interactuar con él, es decir, dar click, enviar datos, desplegar*/
        WebElement inputBusqueda = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(2000);
        //Se da click en el elemento
        inputBusqueda.click();
        Thread.sleep(2000);

        inputBusqueda.sendKeys("Alexa");

        //Entiendase que submit es similar a lanzar o dar un Enter
        inputBusqueda.submit();
        Thread.sleep(2000);
        /*
        web

         */
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
