package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Locators
{
    private WebDriver driver;

    @BeforeTest
    public void setup () throws InterruptedException {
        //se coloca la dirección del driver, sea chrome, mozilla, opera, safari
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
    }

    @Test
   public void xpaths () throws InterruptedException
    {
        //Existen dos tipos de xpaths; que son absoluto y el relativo
        //El xpath absoluto por buenas prácticas no se debe utilizar o abusar de el
        //Diferencias entre los Xpaths
        //El absoluto es la ruta del elemento, es decir la ubicación del mismo y su sintáxis inicia con una diagonal

        //*******       Este es el xpath absoluto     **********************
        //WebElement inputBusqueda = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input"));
        //inputBusqueda.sendKeys("Monitores");
        //Thread.sleep(6000);

        //*******      Estas son las diferentes técnicas de uso de xpath relativo   *******************
        //Los xpaths relativos inician con doble diagonal
        //1.- Uso de xpath con tag y atributos, entiendase que tags son: "spam, img, button, input, etc..."


        //WebElement inputBusqueda = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        //Thread.sleep(6000);
        //inputBusqueda.sendKeys("Monitores");
        //inputBusqueda.submit();
        //Thread.sleep(6000);

        //2.- Uso de xpath relativo con tag y múltiples atributos
        //WebElement inputBusqueda = driver.findElement(By.xpath("//input[@name='field-keywords' and @id='twotabsearchtextbox']"));
        //Thread.sleep(6000);
        //inputBusqueda.sendKeys("Monitores");
        //inputBusqueda.submit();
        //Thread.sleep(6000);

        //3.- Uso de xpath relativo usando contains, con: "*" o "tag", cabe mencionar que el asterísco se puede reemplazar
        /*WebElement bottonIdentificate = driver.findElement(By.xpath("//span[contains(text(), 'Hola, Identifícate')]"));
        bottonIdentificate.click();*/

        //4.- Uso de Xpath por relationship, esto es en función del manejo de las etiquetas o tags, padre e hijo
        /*WebElement inputBusqueda = driver.findElement(By.xpath("//div/input[@id='twotabsearchtextbox' and @type = 'text']"));
        inputBusqueda.sendKeys("Como ser un tester");
        inputBusqueda.submit();
        Thread.sleep(6000);*/

        //Thread.sleep(4000);

        //************************  x P A T H S  ************************//




    }
    @Test
    public void parthialLinkText() throws InterruptedException {
        //********************* Parthial Link Text **************************
        /*Thread.sleep(5000);
        WebElement buttonContinue = driver.findElement(By.xpath("//input[@class='a-button-input' and @data-action-type='DISMISS']"));
        buttonContinue.click();
        WebElement offerDayBotton = driver.findElement(By.partialLinkText("Ofertas"));
        offerDayBotton.click();
        Thread.sleep(4000);

         */

    }
    @Test
    public void LinkText() throws InterruptedException {
        //*********************  Link Text **************************
        /*Thread.sleep(5000);
        WebElement buttonContinuar = driver.findElement(By.xpath("//input[@class='a-button-input' and @data-action-type='DISMISS']"));
        buttonContinuar.click();

        WebElement offersDayBotton = driver.findElement(By.linkText("Ofertas del Dia"));
        offersDayBotton.click();
        Thread.sleep(4000);
        */


    }
    @Test
    public void name() throws InterruptedException {
        //*********************  Name **************************
        /*
                WebElement inputSearch = driver.findElement(By.name("field-keywords"));
        inputSearch.sendKeys("PELUCHES");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000); */



    }

    @Test
    public void id() throws InterruptedException {
        //*********************  ID **************************

        /*
        WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));
        inputSearch.sendKeys("PELUCHES");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);
        */

    }
    @Test
    public void className() throws InterruptedException {
        //*********************  Class Name **************************

        /*
        WebElement inputSearch = driver.findElement(By.className("nav-input nav-progressive-attribute"));
        inputSearch.sendKeys("PELUCHES");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);
        */

    }
    /*
    @Test
    public void cssSelector() throws InterruptedException {
        //*********************  CssSelector **************************


        WebElement inputSearch = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        inputSearch.sendKeys("PELUCHES");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);


    }

     */

    @Test
    public void cssSelector() throws InterruptedException {
        //*********************  CssSelector **************************

        //WebElement inputSearch = driver.findElement(By.cssSelector("input[name='field-keywords']"));
        // WebElement inputSearch = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        //WebElement inputSearch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement inputSearch = driver.findElement(By.cssSelector("input[name='field-keywords'][id='twotabsearchtextbox']"));
        inputSearch.sendKeys("PELUCHES");
        Thread.sleep(5000);
        inputSearch.submit();
        Thread.sleep(3000);

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
