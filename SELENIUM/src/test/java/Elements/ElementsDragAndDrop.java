package Elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsDragAndDrop
{
    //Elemento Droppable
    public By byOptionDroppable = By.partialLinkText("Droppable");
    public WebElement OptionDroppable (WebDriver driver)
    {
        WebElement optionDroppable = driver.findElement(byOptionDroppable);
        return optionDroppable;
    }


    //ELEMENT DRAG
    public By byDrag = By.xpath("//div[@id='draggable']");
    public WebElement Drag (WebDriver driver)
    {
        WebElement drag = driver.findElement(byDrag);
        return drag;
    }

    //ELEMENT DROP
    public By byDrop = By.id("droppable");
    public WebElement Drop (WebDriver driver)
    {
        WebElement drop = driver.findElement(byDrop);
        return drop;
    }
}
