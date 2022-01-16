package ua.hillel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeoPage extends BasePage {

    private final By byLatitudeText = By.cssSelector("#lat-value");
    private final By byLongitudeText = By.cssSelector("#long-value");

    @FindBy(css = "#content > div > button")
    private WebElement whereAmIButton;

    public GeoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GeoPage clickWhereAmIButton() {
        clickButton(whereAmIButton);
        return this;
    }

    public String getLatitudeText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLatitudeText)).getText();
    }

    public String getLongitudeText() {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLongitudeText)).getText();
    }
}
