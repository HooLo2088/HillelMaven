package ua.hillel.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(css = "#content > ul > li:nth-child(21) > a")
    private WebElement logButton;

    @FindBy(css = "#content > ul > li:nth-child(23) > a")
    private WebElement geoButton;

    @FindBy(css = "#content > ul > li:nth-child(5) > a")
    private WebElement challengButton;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage() {
        logButton.click();
        return new LoginPage(driver);
    }

    public GeoPage goToGeoPage() {
        geoButton.click();
        return new GeoPage(driver);
    }

    public ChallengPage goToChallengPage() {
        challengButton.click();
        return new ChallengPage(driver);
    }
}
