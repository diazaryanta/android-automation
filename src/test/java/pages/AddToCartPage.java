package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddToCartPage {
    private AndroidDriver driver;

    private By productItem = By.xpath("(//android.widget.ImageView[@content-desc='Product Image'])[1]");

    private By addToCartButton = AppiumBy.accessibilityId("Tap to add product to cart");

    private By cartIcon = AppiumBy.accessibilityId("Displays number of items in your cart");

    private By cartBadge = By.id("com.saucelabs.mydemoapp.android:id/cartTV");

    public AddToCartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void pilihProdukPertama() {
        driver.findElement(productItem).click();
    }

    public void klikTambahKeKeranjang() {
        driver.findElement(addToCartButton).click();
    }

    public void klikIconKeranjang() {
        driver.findElement(cartIcon).click();
    }

    public String getJumlahKeranjang() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return "0";
        }
    }
}