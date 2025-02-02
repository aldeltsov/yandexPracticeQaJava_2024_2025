package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;
import java.util.Objects;

public class OrderPage {
    private final WebDriver driver;

    //согласие кук
    private final By cookieInButton = By.className("App_CookieButton__3cvqF");

    //верхняя кнопка заказать
    private final By topButton = By.cssSelector(".Header_Nav__AGCXC > button:nth-child(1)");

    //нижняя кнопка заказать
    private final By bottomButton = By.cssSelector(".Button_Middle__1CSJM");

    //поле имени
    private final By nameInput = By.cssSelector(".Order_Form__17u6u > div:nth-child(1) > input:nth-child(1)");

    //поле фамилии
    private final By lastNameInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(2) > input:nth-child(1)");

    //поле адреса
    private final By addressInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(3) > input:nth-child(1)");

    //поле станции метро
    private final By metroInput = By.cssSelector(".select-search__input");

    //поле телефона
    private final By phoneNumberInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(5) > input:nth-child(1)");

    //кнопка далее
    private final By nextButton = By.cssSelector(".Button_Middle__1CSJM");

    //поле когда привезти самокат
    private final By dateInput = By.cssSelector(".react-datepicker__input-container > input:nth-child(1)");

    //поле срок аренды
    private final By rentPeriodInput = By.cssSelector(".Dropdown-control");

    //поле комментария для курьера
    private final By commentInput = By.cssSelector("div.Input_InputContainer__3NykH:nth-child(4) > input:nth-child(1)");

    //кнопка заказать
    private final By createOrderButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");

    //кнопка да
    private final By yesButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");

    //текст успешного заказа
    private final By successMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void acceptCookie() {
        waitForCookiesFloater();
        driver.findElement(cookieInButton).click();
        waitForCookiesFloaterToDisappear();
    }

    private void waitForCookiesFloater() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(cookieInButton));
    }

    private void waitForCookiesFloaterToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(cookieInButton));
    }

    public OrderPage openPage() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    public OrderPage clickOnMakeOrderButton (String button) {
        if (Objects.equals(button, "Верхняя кнопка")){
            new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                    .until(ExpectedConditions.visibilityOfElementLocated(topButton));
            driver.findElement(topButton).click();
        } else if (Objects.equals(button, "Нижняя кнопка")) {
            new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomButton));
            driver.findElement(bottomButton).click();
        }
        return this;
    }

    public OrderPage typeName(String name){
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public OrderPage typeLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public OrderPage typeAddress(String address){
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderPage selectMetro(String id){
        driver.findElement(metroInput).click();
        //элемент из выпадающего списка станций метро
        final By metroList = By.xpath(".//li[@data-index='" + id + "']");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(metroList));
        driver.findElement(metroList).click();
        return this;
    }

    public OrderPage typePhoneNumber(String phone){
        driver.findElement(phoneNumberInput).sendKeys(phone);
        return this;
    }

    public OrderPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage selectDate(String id){
        driver.findElement(dateInput).click();
        //день из выпадающего календаря
        driver.findElement(By.cssSelector(".react-datepicker__day--0" + id)).click();
        return this;
    }

    public OrderPage selectRentPeriod(String id){
        driver.findElement(rentPeriodInput).click();
        //элемент из выпадающего списка сроков аренды
        driver.findElement(By.cssSelector("div.Dropdown-option:nth-child(" + id + ")")).click();
        return this;
    }

    public OrderPage selectColor(String color){
        //чек бокс с выбором цвета
        driver.findElement(By.cssSelector("#"+ color)).click();
        return this;
    }

    public OrderPage typeComment(String comment){
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderPage clickOnCreateOrderButton(){
        driver.findElement(createOrderButton).click();
        return this;
    }

    public OrderPage clickOnYesButton(){
        driver.findElement(yesButton).click();
        return this;
    }

    public OrderPage checkSuccessMessage(){
        String successMessageText = driver.findElement(successMessage).getText();
        System.out.println(successMessageText);
        assert driver.findElement(successMessage).isDisplayed();
        return this;
    }
}