package HomeworkGrapes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class BaseTestGrapes {
    public static WebDriver driver;

    GrapesFlow grape = new GrapesFlow(driver);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @AfterEach
    public void captureScreen(TestInfo testInfo) throws Exception{

        takeScreenShot(driver, "target/screenshots/" + this.getClass().getName() + "/" + testInfo.getDisplayName() + ".png");
    }

    public void takeScreenShot(WebDriver driver, String filePath) throws Exception {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        FileUtils.copyFile(srcFile, destFile);
    }
}
