package ui_tests.tests;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ui_tests.pages.DragDropAreaPageObject;
import ui_tests.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;


import java.security.PublicKey;

public class TestCase_1 {

    WebDriver driver = Driver.getDriver("chrome");
    DragDropAreaPageObject homePageObject = DragDropAreaPageObject.getHomePage(driver);

    WebDriverWait wait = new WebDriverWait(driver, 100);
    Actions action = new Actions(driver);
//    WebElement premiumPlus = BuildCarPageObject.getBuildPage(driver).secondCheckBox;

    @Test(priority = 1)
    public void userIsOnHomePage() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

    }

    @Test(priority = 2)
    public void setUp() {
        WebElement acceptCookies = wait.until(ExpectedConditions.visibilityOf(homePageObject.acceptButton));
        acceptCookies.click();
    }

    @Test(priority = 3)
    public void click()  {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", homePageObject.circleButton);

        Actions builder = new Actions(driver);
        builder.moveToElement(homePageObject.circleButton).clickAndHold().moveByOffset(-10,0).build().perform();
        WebElement blueBox = wait.until(ExpectedConditions.visibilityOf(homePageObject.bluetBox));

        Assertions.assertEquals(blueBox.getText(), "(Drop here)");

    }
}
