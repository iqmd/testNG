package com.testdemo;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.Option;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class WebDriverTest {
    private WebDriver driver = null;

    @BeforeClass(alwaysRun = true)
    public void initAll(){
        ChromeOptions choice = new ChromeOptions();
        choice.addArguments("headless");
        driver = new ChromeDriver(choice);
    }

    @Test(groups="selenium")
    public void seleniumTest(){
        driver.get("https://testng.org/doc/index.html");
        String title = driver.getTitle();
        assertEquals("TestNG - Welcome", title);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @AfterClass(alwaysRun = true)
    public void destroy(){
        driver.quit();
    }


}
