@RunWith(Parameterized.class)
public class CheckIsAdultTest {
    private final int age;
    private final boolean result;

    public CheckIsAdultTest(int age, boolean result) {
	    this.age = age;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
	    return new Object[][] {
                {19, false},
                {20, false},
                {21, true},
                {22, true},
        };
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age);
        assertEquals("Должно вернуться true, так как совершеннолетие наступает в 21 год", true, isAdult);
	}
}
