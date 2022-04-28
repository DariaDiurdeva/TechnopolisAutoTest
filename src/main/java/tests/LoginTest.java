package tests;

import data.User;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.main.MainPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Test log in")
    public void testLogin(){
        User user = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId(589088855467L).build();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);
        assertEquals(mainPage.getName(),user.getName());
    }
}
