package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import data.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.main.MainPage;
import pages.MessagePage;
import pages.Wrappers.MessageWrapper;

public class MessageTest extends BaseTest{

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

   @DisplayName("Test send message")
   @ParameterizedTest
   @ValueSource(strings = {"Hello", "How are you?"})
    public void testMessage(String argument){
       LoginPage loginPage = new LoginPage();
       MainPage mainPage = loginPage.login(user1);
       MessagePage messagePage = mainPage.openMessage();
       messagePage.openDialog(user2.getId()).sendMessage(argument);

       loginPage = mainPage.exit();

       mainPage = loginPage.login(user2);
       messagePage = mainPage.openMessage();
       MessageWrapper message = messagePage.openDialog(user1.getId()).getLastReceivedMessage();

       assertEquals(message.getMessageText(), argument);
    }

}
