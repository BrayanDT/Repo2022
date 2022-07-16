package Browser_Manager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager
{
    @Override
    public void createDriver()
    {
        System.setProperty("webdriver.gekco.driver","src/main/resources/Drivers/geckodriver.exe");

        driver = new FirefoxDriver();
    }

}
