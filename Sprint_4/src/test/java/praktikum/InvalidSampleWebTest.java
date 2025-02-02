package praktikum;

import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class InvalidSampleWebTest {
    @ClassRule
    public static DriverRule factory = new DriverRule();

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);

        mainPage.openMainPage();

        mainPage.closeCookieInButton(); //закрыть куки

        mainPage.clickOrderStatus();

        Thread.sleep(10_00);

        String invalidId = "123";
        mainPage.typeOrderId(invalidId);

        var statusPage = mainPage.clickGoButton();

        statusPage.checkNotFoundMessage();
    }
}





