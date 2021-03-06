package ui_tests.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ui_tests.pages.DragDropAreaPageObject2;
import ui_tests.utils.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase_2 {
    WebDriver driver = Driver.getDriver("chrome");
    Actions action = new Actions(driver);
    DragDropAreaPageObject2 elements = DragDropAreaPageObject2.getDetailPage(driver);
    WebElement circle = elements.blueCircle;
    WebElement squareBlue = elements.blueSquare;
    WebElement squareOrange = elements.orangeSquare;

    @Test (priority = 1)
    public void userIsOnPage() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test (priority = 2)
    public void userClickAndHoldTheBlueCircle() {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", circle);

        action.moveToElement(circle).clickAndHold().moveToElement(squareBlue).build().perform();
    }

    @Test (priority = 3)
    public void validateTextOfBlueSquare() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assertions.assertEquals("Now you can drop it.", squareBlue.getText());
    }

    @Test (priority = 4)
    public void validateTextOfOrangeSquare() {
        Assertions.assertEquals("(Drop here)", squareOrange.getText());
    }
}
