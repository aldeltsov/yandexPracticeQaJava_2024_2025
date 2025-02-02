package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static praktikum.EnvConfig.TIMEOUT_WAIT;

public class QuestionsPage {
    private final WebDriver driver;

    //кнопка куки
    private final By cookieInButton = By.className("App_CookieButton__3cvqF");

    //поиск вопроса
    private final String questionsIdPrefix = "accordion__heading-";

    //поиск ответа
    private final String answerIdPrefix = "accordion__panel-";

    private  final By[] ANSWERS = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7"),
    };

    public static final String[] EXPECTED_ANSWERS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    private final String ERROR_MESSAGE = "Текст не соответствует";

    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public QuestionsPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    public void acceptCookies() {
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

    public QuestionsPage clickOnQuestion(int id) {
        driver.findElement(By.id(questionsIdPrefix + id)).click();
        return this;
    }

    public void waitForAnswer(int id) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerIdPrefix + id)));
    }

    public QuestionsPage checkAnswerIsInvisible(int id) {
        assert !driver.findElement(By.id(answerIdPrefix + id)).isDisplayed();
        return this;
    }

    public QuestionsPage checkTextAnswer(int id) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated((ANSWERS[id])));
        String actualAnswer = driver.findElement(ANSWERS[id]).getText();
        assertEquals(ERROR_MESSAGE, EXPECTED_ANSWERS[id], actualAnswer);
        return this;
    }
}
