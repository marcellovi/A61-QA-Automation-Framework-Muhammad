import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    ChromeOptions options;
    String url = "https://qa.koel.app/"; // "https://app.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initMethod(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void endMethod(){
        this.driver.quit();
    }

    public void openURL(){
        this.driver.get(this.url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void inputEmail(String email){
        WebElement emailField = this.driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
    }

    public void inputPassword(String pwd){
        WebElement passField = this.driver.findElement(By.cssSelector("input[type='password']"));
        passField.sendKeys(pwd);
    }

    public void btnLogin(){
        WebElement buttonLogin = this.driver.findElement(By.cssSelector("button[type='submit']"));
        buttonLogin.click();
    }

    public void inputSearch(String seachTxt){
        WebElement seachField = this.driver.findElement(By.cssSelector("input[type='search']"));
        seachField.sendKeys(seachTxt);
    }

    public void btnSongsViewAll(){
        WebElement buttonViewAll = this.driver.findElement(By.xpath("//section[@class='songs']//button[contains(text(),'View All')]"));
        buttonViewAll.click();
    }

    public void btnAddTo(){
        WebElement buttonAddTo = this.driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        buttonAddTo.click();
    }

    public void btnPlaySong(){
        WebElement buttonPlaySong = this.driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        buttonPlaySong.click();
    }

    public void btnPlayNextSong(){
        WebElement buttonPlayNext = this.driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        buttonPlayNext.click();
    }

    public void imgSoundBarVisible(){
        WebElement buttonPlayNext = this.driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        buttonPlayNext.isDisplayed();
    }

}