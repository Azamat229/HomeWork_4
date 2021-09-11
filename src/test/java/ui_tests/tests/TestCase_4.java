package ui_tests.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ui_tests.pages.DemoSitePageObject;
import ui_tests.utils.Driver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestCase_4 {

    WebDriver driver = Driver.getDriver("chrome");
    Actions action = new Actions(driver);
    DemoSitePageObject elements = DemoSitePageObject.getDetailPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 100);

    WebElement point = elements.thePointToMove;
    WebElement text = elements.dynamicText;
    WebElement minFive = elements.minusFiveThousand;
    WebElement dropSpaceDebit = elements.olElementToDrop;
    WebElement fiveThous = elements.fiveThousand;

    @Test(priority = 1)
    public void userIsOnPage() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test (priority = 2)
    public void userClicksAndHoldTheFirstNum() {
        action.moveToElement(minFive).clickAndHold().moveToElement(point).build().perform();
    }

    @Test (priority = 3)
    public void validateTheSelectAnotherText() {
        WebElement redText = wait.until(ExpectedConditions.visibilityOf(text));
        Assertions.assertEquals("Please select another block", redText.getText());
    }

    @Test (priority = 4)
    public void userDragAndDropNumToDebitSide() {
        minFive.click();

        action.moveToElement(fiveThous).clickAndHold().moveToElement(dropSpaceDebit).release().build().perform();
    }

    @Test (priority = 5)
    public void validateTheTextInTable() {
        ArrayList word = new ArrayList();
        int numOfRow = elements.tableSize.size();

        for(int iRow=0; iRow<= numOfRow-1; iRow++) {

            word.add(elements.tableSize.get(iRow).getText());

        }

        String phrase = String.join(" ", word);

        Assertions.assertEquals("Debit Movement 5000 Credit Movement 0", phrase);
    }

    @Test (priority = 6)
    public void userDragAndDropNumToCreditSide() {
        fiveThous.click();

        action.moveToElement(elements.secondFiveThousand).clickAndHold().moveToElement(elements.olCreditSpace).release().build().perform();
    }


    @Test (priority = 7)
    public void validateTheTextInTableSecond() {
        ArrayList word = new ArrayList();
        int numOfRow = elements.tableSize.size();

        for(int iRow=0; iRow<= numOfRow-1; iRow++) {

            word.add(elements.tableSize.get(iRow).getText());

        }

        String phrase = String.join(" ", word);

        Assertions.assertEquals("Debit Movement 5000 Credit Movement 5000", phrase);
    }

    @Test (priority = 8)
    public void userDragAndDropToDebitSideAccount() {
        fiveThous.click();

        action.moveToElement(elements.bankButton).clickAndHold().moveToElement(elements.debitSideAccount).release().build().perform();
    }

    @Test (priority = 9)
    public void validateBankIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement text = wait.until(ExpectedConditions.visibilityOf(elements.bankLabel));
        Assertions.assertEquals("BANK", text.getText());
    }

    @Test (priority = 10)
    public void userDragAndDropToCreditSideAccount() {
        fiveThous.click();

        action.moveToElement(elements.salesButton).clickAndHold().moveToElement(elements.creditSideAccount).release().build().perform();
    }

    @Test (priority = 11)
    public void validateSalesIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement text = wait.until(ExpectedConditions.visibilityOf(elements.salesLabel));
        Assertions.assertEquals("SALES", text.getText());
    }
}
