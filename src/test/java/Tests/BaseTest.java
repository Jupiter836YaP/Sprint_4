package Tests;

import PaymentObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MainPage.URL);

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie((cookie));
        driver.navigate().refresh();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
