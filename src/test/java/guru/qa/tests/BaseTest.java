package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWindow;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 7500;
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
