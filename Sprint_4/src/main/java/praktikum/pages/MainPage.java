package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.EnvConfig;

public class MainPage {
    private final WebDriver driver;

    //кнопка Go
    private final By goButton = By.className("Header_Button__28dPO");
    //поле для ввода номера заказа
    private final By orderInputText = By.xpath(".//input[contains(@class,'Input_Input__1iN_Z')]");
    //кнопка статуса заказа
    private final By orderStatus = By.className("Header_Link__1TAG7");
    //принять куки
    private final By cookieInButton = By.className("App_CookieButton__3cvqF");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //клик по кнопе go
    public StatusPage clickGoButton() {
        driver.findElement(goButton).click();
        return new StatusPage(driver);
    }

    //ввод текста в поиск заказа
    public void typeOrderId(String orderId) {
        driver.findElement(orderInputText).sendKeys(orderId);
    }

    //клик по кнопке статуса заказа
    public void clickOrderStatus() {
        driver.findElement(orderStatus).click();
    }

    //принятие кук
    public void closeCookieInButton() {
        driver.findElement(cookieInButton).click();
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }
}
