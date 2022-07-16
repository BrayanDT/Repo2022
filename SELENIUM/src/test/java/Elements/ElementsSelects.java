package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsSelects
{
    //TAP WOMAN
    public  By byTapWoman = By.partialLinkText("Women");
    public WebElement TapWoman(WebDriver driver)
    {
        WebElement tapWoman = driver.findElement(byTapWoman);
        return tapWoman;
    }

    public By bybottonMasTops = By.xpath("//div/ul/li[1]/span[@class='grower CLOSE'] ");
    public  WebElement BottonMasTops (WebDriver driver)
    {
        WebElement bottonMasTops = driver.findElement(bybottonMasTops);
        return bottonMasTops;
    }

    public By bybottonTSshirts = By.xpath("//div/ul/li[1]/ul/li[1]/a[contains(text(), 'T-shirts')]");
    public WebElement BottonTSshirts (WebDriver driver)
    {
        WebElement bottonTSshirts = driver.findElement(bybottonTSshirts);
        return bottonTSshirts;
    }

    public By bySelectSort = By.id("selectProductSort");
    public WebElement SelectSort (WebDriver driver)
    {
        WebElement selectSort = driver.findElement(bySelectSort);
        return selectSort;
    }
}
