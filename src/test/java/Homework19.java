import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        openURL();

        Thread.sleep(1000);
        inputEmail("marcello.ferraz.vieira@testpro.io");

        Thread.sleep(1000);
        inputPassword("TestPro@123");

        Thread.sleep(1000);
        btnLogin();

        Thread.sleep(1000);
        menuDelPlaylist("My Playlist");

        Thread.sleep(2000);
        // Check if My Playlist exists
        Actions action = new Actions(this.driver);
        List<WebElement> checkPlaylistName = driver.findElements(By.xpath("//section[@id=\"playlists\"]//a[contains(text(),\"My Playlist\")]"));
        Assert.assertEquals(0, checkPlaylistName.size());

    }

    @Test
    public void deletePlaylistWMenu() throws InterruptedException {
        openURL();

        Thread.sleep(1000);
        inputEmail("marcello.ferraz.vieira@testpro.io");

        Thread.sleep(1000);
        inputPassword("TestPro@123");

        Thread.sleep(1000);
        btnLogin();

        Thread.sleep(1000);
        menuDelPlaylistWMenu("Rock Rules");

        Thread.sleep(2000);
        // Check if My Playlist exists
        List<WebElement> checkPlaylistName = driver.findElements(By.xpath("//section[@id=\"playlists\"]//a[contains(text(),\"My Playlist2\")]"));
        Assert.assertEquals(0, checkPlaylistName.size());

    }
}
