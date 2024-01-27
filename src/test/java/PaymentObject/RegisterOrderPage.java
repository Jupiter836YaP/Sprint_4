package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterOrderPage extends BasePage {
    private final By buttonNext = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");;
    private final By inputFirstName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private final By inputSecondName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private final By inputAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private final By inputPhone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");


    public RegisterOrderPage(WebDriver driver) {
        super(driver);
    }


    public RegisterOrderPage setInputPersonalData (String firstName, String secondName, String address, String phone) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputSecondName).sendKeys(secondName);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputPhone).sendKeys(phone);
        return this;
    }

    public RentOrderPage clickNextButton(){
        driver.findElement(buttonNext).click();
        return new RentOrderPage(driver);
    }

    public RegisterOrderPage selectMetroFromOptions(String metro) {
        final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String metroOptionLocator = String.format(metroOptionTemplate, metro);
        WebElement metroSelect = driver.findElement(By.xpath("//div[contains(@class, 'select-search')]"));
        metroSelect.click();
        WebElement metroOption = driver.findElement(By.xpath(metroOptionLocator));
        metroOption.click();
        return this;
    }

}
