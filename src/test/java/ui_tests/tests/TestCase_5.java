package ui_tests.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ui_tests.pages.SeleniumPractisePageObject;
import ui_tests.utils.Driver;

import java.util.ArrayList;

public class TestCase_5 {

    WebDriver driver = Driver.getDriver("chrome");
    SeleniumPractisePageObject homePageObject = SeleniumPractisePageObject.getHomePage(driver);

    WebDriverWait wait = new WebDriverWait(driver, 50);

    @Test(priority = 1)
    public void userIsOnHomePage() {
        driver.get("http://seleniumpractise.blogspot.com/2017/");

    }

    @Test(priority = 2)
    public void clickFacebookButton() {
        WebElement facebook = wait.until(ExpectedConditions.visibilityOf(homePageObject.facebook));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", facebook);
        facebook.click();
    }

    @Test(priority = 3)
    public void switchToNextTab() {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
    }

    @Test(priority = 4)
    public void clickCreatNewAccount() {
        WebElement createNewAccount = wait.until(ExpectedConditions.visibilityOf(homePageObject.createNewAccount));
        createNewAccount.click();


    }

    @Test(priority = 5)
    public void fillTheForm(){
        WebElement firstname = wait.until(ExpectedConditions.visibilityOf(homePageObject.firstname));
        firstname.sendKeys("Techtorial");

        WebElement lastname = wait.until(ExpectedConditions.visibilityOf(homePageObject.lastname));
        lastname.sendKeys("Academy");

        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOf(homePageObject.phoneNumber));
        phoneNumber.sendKeys("2223334455");

        WebElement password = wait.until(ExpectedConditions.visibilityOf(homePageObject.password));
        password.sendKeys("techtorial123");

        WebElement day = wait.until(ExpectedConditions.visibilityOf(homePageObject.day));
        day.sendKeys("20");

        WebElement month = wait.until(ExpectedConditions.visibilityOf(homePageObject.month));
        month.sendKeys("апр");

        WebElement year = wait.until(ExpectedConditions.visibilityOf(homePageObject.year));
        year.sendKeys("2002");

        WebElement other = wait.until(ExpectedConditions.visibilityOf(homePageObject.other));
        other.click();

    }


    @Test(priority = 6)
    public void switchToPreviousTab() {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
    }

    @Test(priority = 7)
    public void checkTile() {
        Assertions.assertEquals(driver.getTitle(), "Selenium Practise: 2017");

    }
    @Test(priority = 8)
    public void closeWindow(){
        driver.quit();
    }

}
