import pages.LoginPage;
import pages.MainPage;
import data.User;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {

    @org.junit.jupiter.api.Test
    public void testLogin(){
        open("https://ok.ru");
        User user = new User("Дарья Дюрдева", "89119877204","aaaa");
        LoginPage loginPage = new LoginPage();
        try{
            MainPage mainPage = loginPage.login(user);
            assertEquals(mainPage.getName(),user.getName());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
