import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;

public class Homework23 extends BaseTest{

    @Test
    public void renamePlaylist() throws InterruptedException {

        String oldPlaylistName = "My Playlist";
        String newPlaylistName = "My New Playlist";
        String displaySuccessMsg = "Updated playlist \"" + newPlaylistName + ".\"";

        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homePageFactory = new HomePageFactory(driver);

        loginPageFactory.inputEmail("marcello.ferraz.vieira@testpro.io");
        loginPageFactory.inputPassword("TestPro@123");
        loginPageFactory.clickSubmit();

        Assert.assertTrue(homePageFactory.getUserAvatar().isDisplayed());


        homePageFactory.doubleClickPlayList();
        Thread.sleep(3000);
        homePageFactory.renamePlaylistField("My New Playlist");
        Assert.assertTrue(homePageFactory.isNewPlayListDisplayed());
    }
}
