package tests;

import data.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.Wrappers.NoteWrapper;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestLikeNote {

    static User user1;
    static LoginPage loginPage;
    static MainPage mainPage;

    @BeforeAll
    static void start(){
        open("https://ok.ru");
        user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId(589088855467L).build();
    }

    @Test
    public void setLikeTest(){
        loginPage = new LoginPage();
        mainPage = loginPage.login(user1);
        ArrayList<NoteWrapper> notes = mainPage.getFeedList();
        NoteWrapper note = notes.get(0);
        note.setLike();
        assertTrue(note.isLike(),"Лайк уже стоит");

        //удалить лайк
        note.deleteLike();
        assertFalse(note.isLike(),"Лайк уже убран");
    }

    @AfterAll
    static void close(){
        closeWebDriver();
    }
}
