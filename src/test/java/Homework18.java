import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest
{
    @Test
    public void playSong() throws InterruptedException {
        openURL();

        Thread.sleep(1000);
        inputEmail("marcello.ferraz.vieira@testpro.io");
        Thread.sleep(1000);

        inputPassword("TestPro@123");
        Thread.sleep(1000);

        btnLogin();
        Thread.sleep(2000);

        btnPlayNextSong();
        Thread.sleep(2000);

        btnPlaySong();
        Thread.sleep(2000);

        imgSoundBarVisible();
        Thread.sleep(2000);

    }
}
