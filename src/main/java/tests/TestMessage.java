package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

import data.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;
import pages.Wrappers.MessageWrapper;

public class TestMessage  {

   private static User user1;
   private static User user2;

   @BeforeAll
   static void init(){
      user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
              .setLogin("89119877204").setPassword("autotest1")
              .setId(589088855467L).build();
      user2 = new User.UserBuilder().setFullName("Lol Kek")
              .setLogin("89657631124").setPassword("polinasuperstar")
              .setId(589260828331L).build();
   }

   @BeforeEach
   void start(){
      open("https://ok.ru");
   }

   @ParameterizedTest
   @ValueSource(strings = {"Hello", "How are you?"})
    public void testMessage(String argument){

       LoginPage loginPage = new LoginPage();
       MainPage mainPage = loginPage.login(user1);

       MessagePage messagePage = mainPage.openMessage();
       messagePage.openDialog(user2.getId()).sendMessage(argument);

       closeWebDriver();
       open("https://ok.ru");
       LoginPage lp2 = new LoginPage();
       MainPage mp2 = lp2.login(user2);
       MessagePage msp2 = mp2.openMessage();

       MessageWrapper message = msp2.openDialog(user1.getId()).getLastReceivedMessage();
       assertEquals(message.getMessageText(), argument);
    }

   @AfterEach
   void finish(){
      closeWebDriver();
   }
}
