package PaymentObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletedPage {
    private final WebDriver driver;
    private final By successText = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]");


    public CompletedPage (WebDriver driver) {
        this.driver = driver;
    }

    public String searchSuccessText() {
        WebElement element = driver.findElement(successText);
        return element.getText();
    }

}
