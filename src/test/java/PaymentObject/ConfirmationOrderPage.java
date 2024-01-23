package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOrderPage {
    private final WebDriver driver;
    private final By buttonConfirm;


    public ConfirmationOrderPage(WebDriver driver) {
        this.driver = driver;
        this.buttonConfirm = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    }

    public void clickConfirmButton(){
        driver.findElement(buttonConfirm).click();
    }


}
