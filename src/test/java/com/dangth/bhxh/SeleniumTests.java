package com.dangth.bhxh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.bind.Element;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SeleniumTests {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();
        BhxhApplication.main(new String[]{});
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
    public void testHomePage() {
        driver.get("http://localhost:8080/");
        String expectedTitle = "Trang chủ";
        String actualTitle;

        // launch Fire fox and direct it to the Base URL

        // get the actual value of the title
        actualTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testLoginPage() {
        driver.get("http://localhost:8080/login");

        String actualName = driver.findElement(By.tagName("h2")).getText();
        String expected = "Đăng nhập";
        Assert.assertEquals(expected, actualName);
    }
}
