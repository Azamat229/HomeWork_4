package ui_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropAreaPageObject2 {


    private DragDropAreaPageObject2(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id=\"draggable\"]")
    public WebElement blueCircle;

    @FindBy(xpath = "//div[@class=\"test1\"]")
    public WebElement blueSquare;

    @FindBy(xpath = "//div[@class=\"test2\"]")
    public WebElement orangeSquare;






    public static DragDropAreaPageObject2 getDetailPage(WebDriver driver) {
        return new DragDropAreaPageObject2(driver);
    }
}
