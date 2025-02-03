package praktikum;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.QuestionsPage;

@RunWith(Parameterized.class)
public class QuestionsTest {
    private final int itemId;
    private final String expectedAnswer;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    public QuestionsTest(int itemId, String expectedAnswer) {
        this.itemId = itemId;
        this.expectedAnswer = expectedAnswer;
    }

    @BeforeClass
    public static void closeCookies() {
        new QuestionsPage(driverRule.getDriver())
                .open()
                .acceptCookies();
    }

    @Parameterized.Parameters
    public static Object[][] faqData() {
        return new Object[][]{
                {0, QuestionsPage.EXPECTED_ANSWERS[0]},
                {1, QuestionsPage.EXPECTED_ANSWERS[1]},
                {2, QuestionsPage.EXPECTED_ANSWERS[2]},
                {3, QuestionsPage.EXPECTED_ANSWERS[3]},
                {4, QuestionsPage.EXPECTED_ANSWERS[4]},
                {5, QuestionsPage.EXPECTED_ANSWERS[5]},
                {6, QuestionsPage.EXPECTED_ANSWERS[6]},
                {7, QuestionsPage.EXPECTED_ANSWERS[7]}
        };
    }

    @Test
    public void clickOnFaqItems() {
        new QuestionsPage(driverRule.getDriver())
                .checkAnswerIsInvisible(itemId)
                .clickOnQuestion(itemId)
                .checkTextAnswer(itemId)
                .waitForAnswer(itemId);
    }
}