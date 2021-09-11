package ui_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DragDropAreaPageObject {


    private DragDropAreaPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement circleButton;

    @FindBy(xpath = "//div[@id='example']")
    public WebElement outerSquare;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptButton;

    @FindBy(xpath = "//div[@class=\"test1\"]")
    public WebElement bluetBox;


    public static DragDropAreaPageObject getHomePage(WebDriver driver) {
        return new DragDropAreaPageObject(driver);
    }


}
