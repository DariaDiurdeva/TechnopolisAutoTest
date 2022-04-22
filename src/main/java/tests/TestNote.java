package tests;

import data.Note;
import data.User;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MainPage;
import pages.NotesPage;
import pages.Wrappers.NoteWrapper;

import java.util.Optional;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class TestNote {

    static User user1;
    static LoginPage loginPage;
    static MainPage mainPage;
    static NotesPage notesPage;


    @BeforeAll
    static void start(){
        open("https://ok.ru");
        user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId(589088855467L).build();
    }

   @Test
    public void testSendNote(){
        loginPage = new LoginPage();
        mainPage = loginPage.login(user1);
        notesPage = mainPage.openNotesPage();
        String text = "This is test";
        String head = "Hello";
        Note note = new Note(head,text);
        String checkText = head + "\n" + text;
        notesPage.sendNote(note);
        Optional<NoteWrapper> checkNote = notesPage.getUserLastNote();
        assertAll("Should return not null note",
                    ()->assertTrue(checkNote.isPresent(),"Не удалось найти пост!"),
                    ()-> assertEquals(checkText, checkNote.get().getTextNote(),
                            "Текст не совпадает с отправленным через тест!"));

    }


    @AfterAll
    static void close(){
        closeWebDriver();
    }
}
