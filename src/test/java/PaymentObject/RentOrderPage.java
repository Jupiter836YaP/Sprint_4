package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentOrderPage {
    private final WebDriver driver;
    private final By buttonOrder;
    private final By checkboxColour;
    private final By inputComment;
    private final By selectDateOfDelivery;
    private final By rentalOptionLocator;
    private final By selectRentalPeriod;


    public RentOrderPage(WebDriver driver) {
        this.driver = driver;
        this.buttonOrder = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
        this.checkboxColour = By.xpath("//*[@id='black']");
        this.inputComment = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
        this.selectDateOfDelivery = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
        this.rentalOptionLocator = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[1]");
        this.selectRentalPeriod = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    }


    public void setInputPersonalData (String comment, String date) {
        driver.findElement(selectDateOfDelivery).sendKeys(date);
        driver.findElement(checkboxColour).click();
        driver.findElement(inputComment).sendKeys(comment);
        driver.findElement(rentalOptionLocator).click();
        driver.findElement(selectRentalPeriod).click();
    }

    public void clickOrderButton(){
        driver.findElement(buttonOrder).click();
    }


}


