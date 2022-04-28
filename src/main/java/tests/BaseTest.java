package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    @BeforeEach
    public void initBase(){
        open("https://ok.ru");
    }

    @AfterEach
    public void endBase(){
        closeWebDriver();
    }

}
