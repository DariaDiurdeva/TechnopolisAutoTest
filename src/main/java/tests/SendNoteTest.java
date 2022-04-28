package tests;

import pages.Wrappers.Note;
import data.User;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.main.MainPage;
import pages.NotesPage;
import pages.Wrappers.NoteWrapper;
import static org.junit.jupiter.api.Assertions.*;

public class SendNoteTest extends BaseTest {

   @Test
   @DisplayName("Test send note")
    public void testSendNote(){
       User user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
               .setLogin("89119877204").setPassword("autotest1")
               .setId(589088855467L).build();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user1);
        NotesPage notesPage = mainPage.openNotesPage();
        String text = "This is test";
        String head = "Hello";
        Note note = new Note(head,text);
        String checkText = head + "\n" + text;
        notesPage.sendNote(note);
        NoteWrapper checkNote = notesPage.getUserLastNote();
        assertAll("Should return not null note",
                    ()->assertTrue(checkNote!=null,"Не удалось найти пост!"),
                    ()-> assertEquals(checkText, checkNote.getTextNote(),
                            "Текст не совпадает с отправленным"));

    }
}
