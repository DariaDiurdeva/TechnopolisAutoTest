package tests;

import data.User;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin  {

    @Test
    public void testLogin(){
        open("https://ok.ru");
        User user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("Dd18Pp27Ss55")
                .setId(589088855467L).build();
        LoginPage loginPage = new LoginPage();
        try{
            MainPage mainPage = loginPage.login(user1);
            assertEquals(mainPage.getName(),user1.getName());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
