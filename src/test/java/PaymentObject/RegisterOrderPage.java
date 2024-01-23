package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterOrderPage {
    private final WebDriver driver;
    private final By buttonNext;
    private final By inputFirstName;
    private final By inputSecondName;
    private final By inputAddress;
    private final By inputPhone;


    public RegisterOrderPage(WebDriver driver) {
        this.driver = driver;
        this.buttonNext = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
        this.inputFirstName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
        this.inputSecondName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
        this.inputAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
        this.inputPhone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    }


    public void setInputPersonalData (String firstName, String secondName, String address, String phone) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputSecondName).sendKeys(secondName);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputPhone).sendKeys(phone);

    }

    public void clickNextButton(){
        driver.findElement(buttonNext).click();
    }

    public void selectMetroFromOptions(String metro) {
        final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String metroOptionLocator = String.format(metroOptionTemplate, metro);
        WebElement metroSelect = driver.findElement(By.xpath("//div[contains(@class, 'select-search')]"));
        metroSelect.click();
        WebElement metroOption = driver.findElement(By.xpath(metroOptionLocator));
        metroOption.click();
    }

}
