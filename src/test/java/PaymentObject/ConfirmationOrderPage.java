package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOrderPage extends BasePage {
    private final By buttonConfirm = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");


    public ConfirmationOrderPage(WebDriver driver) {
        super(driver);
    }

    public CompletedPage clickConfirmButton(){
        driver.findElement(buttonConfirm).click();
        return new CompletedPage(driver);
    }


}
