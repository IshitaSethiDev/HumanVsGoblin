import models.Land;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    Land landObj = new Land();
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String NO_COLOR = "\u001B[0m";
    public static final String COLOR_GREEN = "\033[0;32m";

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Firing up unit tests");
    }

    @BeforeEach
    void nextTest() {
        System.out.println("Running Next Unit test........");
    }

    @DisplayName("Print Strength")
    @Test
    void printStrength(){
        assertEquals(COLOR_GREEN + "88" + NO_COLOR, landObj.printStrength("100"),
                "Test Failed for input One");
    }

    @DisplayName("Change Position")
    @Test
    void changePosition(){
        assertEquals(false, landObj.changePosition(),
                "Test Failed for input Two");
    }

    @AfterEach
    void afterTest() {
        System.out.println("This test completed");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are completed.");
    }
}