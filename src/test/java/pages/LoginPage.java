package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AndroidDriver driver;

    private By hamburgerMenu = AppiumBy.accessibilityId("View menu");
    private By loginMenuOption = AppiumBy.accessibilityId("Login Menu Item");
    private By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By loginButton = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void bukaHalamanLogin() {
        driver.findElement(hamburgerMenu).click();
        driver.findElement(loginMenuOption).click();
    }

    public void inputUsername(String user) {
        driver.findElement(usernameField).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void klikTombolLogin() {
        driver.findElement(loginButton).click();
    }
}