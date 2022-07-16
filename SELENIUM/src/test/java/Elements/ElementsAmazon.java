package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsAmazon
{
    //ELEMENTO MENU PRIME
    public By byMenuPrime = By.xpath("//a[@id='nav-link-prime']");
    public WebElement MenuPrime (WebDriver driver)
    {
        WebElement menuPrime = driver.findElement(byMenuPrime);
        return menuPrime;
    }

    //ELEMENTO BOTON PRUEBA AMAZON PRIME
    public By byBotonAmazonPrime = By.xpath("//span[@class='a-button-text' and contains(text(), 'Prueba Amazon Prime')]");
    public WebElement BotonAmazonPrime (WebDriver driver )
    {
        WebElement botonAmazonPrime = driver.findElement(byBotonAmazonPrime);
        return botonAmazonPrime;
    }
}
