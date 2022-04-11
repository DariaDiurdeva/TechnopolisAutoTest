package tests;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

import data.User;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;
import pages.Wrappers.MessageWrapper;

public class TestMessage  {

    @Test
    public void testMessage(){
       open("https://ok.ru");
        try {
            User user1 = new User.UserBuilder().setFullName("Дюрдева Дарья")
                    .setLogin("89119877204").setPassword("Dd18Pp27Ss55")
                    .setId(589088855467L).build();

            User user2 = new User.UserBuilder().setFullName("Lol Kek")
                    .setLogin("89657631124").setPassword("polinasuperstar")
                    .setId(589260828331L).build();

            String text = "Hello";
            LoginPage loginPage = new LoginPage();
            MainPage mainPage = loginPage.login(user1);

            MessagePage messagePage = mainPage.openMessage();
            messagePage.openDialog(user2.getId()).sendMessage(text);

            loginPage = mainPage.exit();

            mainPage = loginPage.login(user2);
            messagePage = mainPage.openMessage();

            MessageWrapper message = messagePage.openDialog(user1.getId()).getLastReceivedMessage();
            assertEquals(message.getMessageText(), text);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
