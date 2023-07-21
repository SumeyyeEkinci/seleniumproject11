package com.cydeo.tests.day8_proporties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

   // WebDriver driver;
    //    @BeforeMethod
    //    public void setupMethod() {
    //
    //        //We are getting the browserType dynamically from our configuration.properties file
    //       String browserType = ConfigurationReader.getProperty("browser");
    //       driver = WebDriverFactory_2.getSite("https://www.google.com", browserType);
    //
    //    }



    @Test
    public void google_search_test(){

        Driver.getDriver().get("https://www.google.com");

        //3- Write “apple” in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//textarea[@type='search']"));

        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
