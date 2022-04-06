package tests;

import static com.codeborne.selenide.Selenide.open;
import data.Message;
import data.User;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;

public class TestMessage {

    @Test
    public void testMessage(){
       open("https://ok.ru");
        try {
            User user1 = new User("Дарья Дюрдева", "89119877204","Dd18Pp27Ss55");
            User user2 = new User("Lol Kek", "89657631124","polinasuperstar");
            LoginPage loginPage = new LoginPage();
            MainPage mainPage = loginPage.login(user1);

            MessagePage messagePage = mainPage.getMessagePage();
            Message message = new Message("это тест");

            messagePage.openDialog(448805632L);
            messagePage.sendMessage(message);
            loginPage = mainPage.exit();

            mainPage = loginPage.login(user2);
            messagePage = mainPage.getMessagePage();
            messagePage.openDialog(448805632L);
            boolean result = messagePage.checkLastMessage(message);
            if(result) System.out.println("Message sent successfully");
            else System.out.println("Message sent unsuccessfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
