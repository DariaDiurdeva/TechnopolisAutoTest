package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.Wrappers.Note;
import pages.Wrappers.NoteWrapper;
import static com.codeborne.selenide.Selenide.$;

public class NotesPage extends BasePage {
    private By fieldForTextNote = By.xpath("//*[@class=\"pf-head_itx_a\"]");
    private  By lastNote = By.xpath("//div[1][@class= 'feed']");
    private String loadError = "Text field not loaded";

    public NotesPage(){
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(fieldForTextNote).shouldBe(Condition.visible.because(loadError));
    }

    public NoteWrapper getUserLastNote(){
        NoteWrapper noteWrapper = new NoteWrapper($(lastNote));
        return noteWrapper;
    }

    public NotesPage sendNote(Note note){
        $(fieldForTextNote).click();
        return note.createNote(this);
    }
}
