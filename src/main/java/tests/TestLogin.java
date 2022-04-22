package tests;

import data.User;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLogin  {

    private  User user;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeAll
    void init(){
        user = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId(589088855467L).build();
    }

    @BeforeEach
    void start(){
        open("https://ok.ru");
        loginPage = new LoginPage();
        mainPage = loginPage.login(user);
    }

    @Test
    @DisplayName("Test log in")
    public void testLogin(){
        assertEquals(mainPage.getName(),user.getName());
    }

    @Test
    @Disabled("Test for logout disabled")
    public void testLogOut(){
        loginPage = mainPage.exit();
        assertTrue(loginPage.intoLoginPage());
    }
    @AfterEach
    void finish(){
        closeWebDriver();
    }
}
