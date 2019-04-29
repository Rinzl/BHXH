package com.dangth.bhxh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTests {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();
    }
    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
    }
    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void demo() {
        driver.get("http://localhost:8080/");
        String expectedTitle = "Trang chủ";
        String actualTitle;

        // launch Fire fox and direct it to the Base URL

        // get the actual value of the title
        actualTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
