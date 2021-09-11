package ui_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoSitePageObject {
    private DemoSitePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//li[@data-id=\"1\"]")
    public WebElement minusFiveThousand;

    @FindBy(xpath = "//li[@data-id=\"2\"]")
    public WebElement fiveThousand;

    @FindBy(xpath = "(//li[@data-id=\"2\"])[2]")
    public WebElement secondFiveThousand;

    @FindBy(xpath = "//ol[@id=\"amt8\"]")
    public WebElement olCreditSpace;

    @FindBy(xpath = "//li[@id=\"credit2\"]")
    public WebElement bankButton;

    @FindBy(xpath = "//li[@id=\"credit1\"]")
    public WebElement salesButton;

    @FindBy(xpath = "//ol[@id=\"bank\"]")
    public WebElement debitSideAccount;

    @FindBy(xpath = "//ol[@id=\"loan\"]")
    public WebElement creditSideAccount;

    @FindBy(xpath = "//li[contains(text(), \" BANK\")]")
    public WebElement bankLabel;

    @FindBy(xpath = "//li[contains(text(), \" SALES\")]")
    public WebElement salesLabel;

    @FindBy(xpath = "//div[@class=\"e14\"]")
    public WebElement dynamicText;

    @FindBy(xpath = "//table[@align=\"center\"]/tbody/tr/td")
    public List<WebElement> tableSize;

    @FindBy(xpath = "//div[@id=\"shoppingCart1\"]")
    public WebElement thePointToMove;

    @FindBy(xpath = "//ol[@id=\"amt7\"]")
    public WebElement olElementToDrop;





    public static DemoSitePageObject getDetailPage(WebDriver driver) {
        return new DemoSitePageObject(driver);
    }
}
