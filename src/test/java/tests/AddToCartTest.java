package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AddToCartPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class AddToCartTest extends BaseTest {

    @Test
    public void testTambahProdukKeKeranjang() {
        LoginPage loginPage = new LoginPage(driver);
        AddToCartPage cartPage = new AddToCartPage(driver);

        loginPage.bukaHalamanLogin();
        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.klikTombolLogin();

        cartPage.pilihProdukPertama();

        cartPage.klikTambahKeKeranjang();

        cartPage.klikIconKeranjang();

        String jumlah = cartPage.getJumlahKeranjang();

        System.out.println("Log: Jumlah item di keranjang saat ini = " + jumlah);

        Assert.assertEquals(jumlah, "1", "Assertion Gagal: Produk tidak berhasil masuk ke keranjang!");

        System.out.println("Skenario Add to Cart Berhasil Dieksekusi!");
    }
}