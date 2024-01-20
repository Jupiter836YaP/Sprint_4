package PaymentObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By[] headings = new By[8];
    private final By[] panels = new By[8];
    private final By buttonOrderFirst;
    private final By buttonOrderSecond;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.buttonOrderFirst = By.xpath(".//button[@class='Button_Button__ra12g']");
        this.buttonOrderSecond = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
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
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(panels[headingNumber]));
        return driver.findElement(panels[headingNumber]).getText();
    }


    public void clickOrderButtonFirst() {
        driver.findElement(buttonOrderFirst).click();
    }

    public void clickOrderButtonSecond() {
        WebElement element = scrollUntilElement(buttonOrderSecond);
        element.click();
    }


}
