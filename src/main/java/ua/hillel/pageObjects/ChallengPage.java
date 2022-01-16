package ua.hillel.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ChallengPage extends BasePage {

    private final By byText4Colum = By.xpath("//table/tbody/tr/td[4]");

    @FindBy(css = "div.large-2 a:nth-of-type(1)")
    private WebElement blueButton;

    @FindBy(css = "div.large-2 > .alert")
    private WebElement redButton;

    @FindBy(css = "div.large-2 > .success")
    private WebElement greenButton;

    public ChallengPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ChallengPage clickBlueButton() {
        clickButton(blueButton);
        return this;
    }

    public ChallengPage clickRedButton() {
        clickButton(redButton);
        return this;
    }

    public ChallengPage clickGreenButton() {
        clickButton(greenButton);
        return this;
    }

    public List<WebElement> getText4Colums() {
        return driver.findElements(byText4Colum);
    }
}
