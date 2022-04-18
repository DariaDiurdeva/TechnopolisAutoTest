package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

import data.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;
import pages.Wrappers.MessageWrapper;

public class TestMessage  {

    @Test
    public void testMessage(){
       open("https://ok.ru");

       User user1 = new User.UserBuilder().setFullName("Дюрдева Дарья")
               .setLogin("89119877204").setPassword("autotest1")
               .setId(589088855467L).build();

       User user2 = new User.UserBuilder().setFullName("Lol Kek")
               .setLogin("89657631124").setPassword("polinasuperstar")
               .setId(589260828331L).build();

       String text = "Hello";
       LoginPage loginPage = new LoginPage();
       MainPage mainPage = loginPage.login(user1);

       MessagePage messagePage = mainPage.openMessage();
       messagePage.openDialog(user2.getId()).sendMessage(text);

       closeWebDriver();
       //loginPage = mainPage.exit();
       open("https://ok.ru");
       LoginPage lp2 = new LoginPage();
       MainPage mp2 = lp2.login(user2);
       MessagePage msp2 = mp2.openMessage();

       MessageWrapper message = msp2.openDialog(user1.getId()).getLastReceivedMessage();
       assertEquals(message.getMessageText(), text);
    }
}
