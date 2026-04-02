package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setPlatformVersion("14")
                .setAutomationName("UIAutomator2")
                .setApp(System.getProperty("user.dir") + "/apk/saucedemo.apk")
                .setAppWaitActivity("*");

        URL appiumUrl = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(appiumUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testHelloAppium(){
        if (driver != null) {
            assert driver.getSessionId() != null;
            System.out.println("Session Successfully Created: " + driver.getSessionId());
        }
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            System.out.println("Quit Driver");
        }
    }
}