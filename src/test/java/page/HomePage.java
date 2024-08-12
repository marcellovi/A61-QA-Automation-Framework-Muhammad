package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    By avatarIcon = By.cssSelector("img.avatar");
    By playlistEditField = By.xpath("//input[@data-testid=\"inline-playlist-name-input\"]");

    String replaceSubTxt = "@replaceText@";
    String playlistOption = "//section[@id=\"playlists\"]//a[contains(text(),\"" + replaceSubTxt + "\")]";

    String findDisplayMsg = "//div[contains(text(),'"+ replaceSubTxt + "')]";

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    /**
     *
     * @return
     */
    public WebElement getUserAvatar(){
        return findElement(avatarIcon);
    }

    public void rightClickPlaylist(String playList){
        playList = playlistOption.replaceFirst(replaceSubTxt,playList);
        rightClick(By.xpath(playList));
    }

    public void clickPlayList(String playList){
        playList = playlistOption.replaceFirst(replaceSubTxt,playList);
        rightClick(By.xpath(playList));
    }

    public void doubleClickPlayList(String playList){
        playList = playlistOption.replaceFirst(replaceSubTxt,playList);
        doubleClick(By.xpath(playList));
    }

    public void renamePlaylistField(String playlistName){
        sendKeysUpdate(playlistEditField,playlistName);
        pressEnter(playlistEditField);
    }

    public Boolean findDiplayedElement(String message){
        message = findDisplayMsg.replaceFirst(replaceSubTxt,message);
        WebElement el = findElement(By.xpath(message));
        return el.isDisplayed();
    }

}
