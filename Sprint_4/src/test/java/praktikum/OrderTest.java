package praktikum;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String lastname;
    private final String address;
    private final String metroId;
    private final String phone;
    private final String day;
    private final String rentPeriod;
    private final String color;
    private final String comment;
    private final String button;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();


    public OrderTest(String button,
                           String name,
                           String lastname,
                           String address,
                           String metroId,
                           String phone,
                           String day,
                           String rentPeriod,
                           String color,
                           String comment) {
        this.button = button;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metroId = metroId;
        this.phone = phone;
        this.day = day;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
    }

    @BeforeClass
    public static void closeCookies() {
        new OrderPage(driverRule.getDriver())
                .openPage()
                .acceptCookie();
    }

    @Parameterized.Parameters
    public static Object[][] faqData() {
        return new Object[][]{
                {"Верхняя кнопка",
                        "Иван",
                        "Иванов",
                        "г.Москва, ул. Пушкина , д.1",
                        "0",
                        "79031234567",
                        "30",
                        "1",
                        "grey",
                        "Комментарий"},
                {"Нижняя кнопка",
                        "Иванна",
                        "Иванова",
                        "г.Москва, ул. Есенина, д.33",
                        "2",
                        "79031234568",
                        "31",
                        "2",
                        "black",
                        "Комментарий"}
        };
    }

    @Test
    public void createOrder() {
        new OrderPage(driverRule.getDriver())
                .clickOnMakeOrderButton(button)
                .typeName(name)
                .typeLastName(lastname)
                .typeAddress(address)
                .selectMetro(metroId)
                .typePhoneNumber(phone)
                .clickOnNextButton()
                .selectDate(day)
                .selectRentPeriod(rentPeriod)
                .selectColor(color)
                .typeComment(comment)
                .clickOnCreateOrderButton()
                .clickOnYesButton()
                .checkSuccessMessage().openMainPage();
    }
}