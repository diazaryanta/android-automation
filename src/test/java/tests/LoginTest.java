package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void testLoginScenario() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.bukaHalamanLogin();

        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.klikTombolLogin();

        boolean isHeaderDisplayed = driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).isDisplayed();

        Assert.assertTrue(isHeaderDisplayed, "Login gagal! Halaman utama tidak ditemukan.");
        System.out.println("Login Berhasil dengan user: bod@example.com");
    }
}