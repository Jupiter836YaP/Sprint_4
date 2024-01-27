package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentOrderPage extends BasePage {
    private final By buttonOrder = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    private final By checkboxColour = By.xpath("//*[@id='black']");
    private final By inputComment = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private final By selectDateOfDelivery = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    private final By rentalOptionLocator = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[1]");
    private final By selectRentalPeriod = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[1]");


    public RentOrderPage(WebDriver driver) {
        super(driver);
    }


    public RentOrderPage setInputPersonalData (String comment, String date) {
        driver.findElement(selectDateOfDelivery).sendKeys(date);
        driver.findElement(checkboxColour).click();
        driver.findElement(inputComment).sendKeys(comment);
        driver.findElement(rentalOptionLocator).click();
        driver.findElement(selectRentalPeriod).click();
        return this;
    }

    public ConfirmationOrderPage clickOrderButton(){
        driver.findElement(buttonOrder).click();
        return new ConfirmationOrderPage(driver);
    }


}


