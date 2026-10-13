package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.nio.file.Files;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        // Take a screenshot only if the test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            new File("screenshots").mkdirs();
            Files.copy(src.toPath(), new File("screenshots/" + result.getName() + ".png").toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        }
        driver.quit();
    }
}