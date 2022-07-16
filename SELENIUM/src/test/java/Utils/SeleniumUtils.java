package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumUtils
{
    WebDriver driver;
    protected WebElement element;

    public void Click (WebElement element)
    {
        element.click();
    }

    public void Clear(WebElement element)
    {
        element.clear();
    }


    public void InputFill(WebElement input, String data)
    {
        Clear(input);
        input.sendKeys(data);

    }

    public void waiting (WebDriver driver, int timeMiliseconds) throws InterruptedException {
        Thread.sleep(timeMiliseconds);
    }
    public void Enter()
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
    }

    public String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Images/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }

}
