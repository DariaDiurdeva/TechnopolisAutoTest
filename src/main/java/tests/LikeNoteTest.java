package tests;

import data.User;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.main.MainPage;
import pages.Wrappers.NoteWrapper;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LikeNoteTest extends BaseTest {

    private NoteWrapper note;

    @Test
    @DisplayName("Test set like on note")
    public void setLikeTest(){
        User user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId(589088855467L).build();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user1);
        ArrayList<NoteWrapper> notes = mainPage.getFeedList();
        NoteWrapper note = notes.get(0);
        if (!note.isLike()){
            note.clickLike();
        }
        assertTrue(note.isLike(),"Like not found");
    }

    @After
    public void close(){
        note.clickLike();
    }
}
