package pageFactory;

import io.netty.util.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory extends BasePageFactory {

    public HomePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    // IMPORTANT NOTE : @FindBy is not possible to make it dynamic Ex. @FindBy( css = "$var")
    @FindBy( css = "img.avatar")
    WebElement avatarIcon;

    @FindBy( xpath = "//section[@id=\"playlists\"]//a[contains(text(),\"My Playlist\")]")
    WebElement myPlalistOption;

    @FindBy( xpath = "//section[@id=\"playlists\"]//a[contains(text(),\"My New Playlist\")]")
    WebElement myNewPlalistOption;

    @FindBy( xpath = "//input[@data-testid=\"inline-playlist-name-input\"]")
    WebElement playlistEditField;

    @FindBy( xpath = "//div[contains(text(),'My New Playlist')]")
    WebElement newPlaylistConfirmMsg;


    public WebElement getUserAvatar(){
        return avatarIcon;
    }

    public HomePageFactory rightClickPlaylist(){
        actions.contextClick(myPlalistOption).perform();
        return this;
    }

    public HomePageFactory doubleClickPlayList() {
        actions.doubleClick(myPlalistOption).perform();
        return this;
    }

    public HomePageFactory renamePlaylistField(String text) {
        playlistEditField.sendKeys(Keys.chord(Keys.CONTROL,"a"),text);
        playlistEditField.sendKeys(Keys.ENTER);
        return this;
    }

    public Boolean isNewPlayListDisplayed() {
        return newPlaylistConfirmMsg.isDisplayed();
    }

}
