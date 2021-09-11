package ui_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPractisePageObject {

    private SeleniumPractisePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(text(),'Click here for Facebook')]")
    public WebElement facebook;

    @FindBy(linkText = "Создать аккаунт")
    public WebElement createNewAccount;


    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastname;
    @FindBy(xpath = "//input[@name='reg_email__']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    public WebElement password;

    @FindBy(xpath = "//select[@id='day']")
    public WebElement day;

    @FindBy(xpath = "//select[@id='month']")
    public WebElement month;

    @FindBy(xpath = "//select[@id='year']")
    public WebElement year;
    @FindBy(xpath = "//label[contains(text(),'Мужчина')]")
    public WebElement other;


    public static SeleniumPractisePageObject getHomePage(WebDriver driver) {
        return new SeleniumPractisePageObject(driver);
    }

}
