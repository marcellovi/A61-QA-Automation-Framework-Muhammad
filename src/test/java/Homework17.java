import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        openURL();

        Thread.sleep(2000);
        inputEmail("marcello.ferraz.vieira@testpro.io");
        Thread.sleep(2000);

        inputPassword("TestPro@123");
        Thread.sleep(2000);

        btnLogin();
        Thread.sleep(2000);

        inputSearch("dark days");
        Thread.sleep(2000);

        btnSongsViewAll();
        Thread.sleep(2000);

        // Click on the first song
        WebElement firstSong = this.driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);

        // Click on the ADD TO button ( Only visible when you click in a song )
        btnAddTo();
        Thread.sleep(2000);

        // Choose the option Best Music
        WebElement liBestMusic = this.driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Best Music')]"));
        liBestMusic.click();
        Thread.sleep(2000);

        // Check if it was Added to Best Music
        WebElement successMsg = this.driver.findElement(By.xpath("//div[@class='success show'][contains(text(),'Added 1 song into \"Best Music.\"')]"));
        String expected = "Added 1 song into \"Best Music.\"";
        Assert.assertEquals(successMsg.getText(),expected);
        Assert.assertTrue(successMsg.isDisplayed());
        Thread.sleep(2000);
    }
}

