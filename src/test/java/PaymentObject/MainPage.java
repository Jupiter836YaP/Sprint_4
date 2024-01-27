package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private final By[] headings = new By[8];
    private final By[] panels = new By[8];
    private final By buttonOrderFirst = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    private final By buttonOrderSecond = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";


    public MainPage(WebDriver driver) {
        super(driver);
        for (int i = 0; i < 8; i++) {
            this.headings[i] = By.xpath(String.format("//*[@id='accordion__heading-%d']", i));
            this.panels[i] = By.xpath(String.format("//*[@id='accordion__panel-%d']/p", i));
        }
    }

    public WebElement scrollUntilElement(By piece) {
        WebElement element = driver.findElement(piece);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }


    public String getTextPanel(int headingNumber) {
        WebElement element = scrollUntilElement(headings[headingNumber]);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(panels[headingNumber]));
        return driver.findElement(panels[headingNumber]).getText();
    }


    public RegisterOrderPage clickOrderButtonFirst() {
        driver.findElement(buttonOrderFirst).click();
        return new RegisterOrderPage(driver);
    }

    public RegisterOrderPage clickOrderButtonSecond() {
        WebElement element = scrollUntilElement(buttonOrderSecond);
        element.click();
        return new RegisterOrderPage(driver);
    }


}
