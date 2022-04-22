package pages;

import com.codeborne.selenide.Condition;
import data.Note;
import org.openqa.selenium.By;
import pages.Wrappers.NoteWrapper;
import java.util.Optional;
import static com.codeborne.selenide.Selenide.$;

public class NotesPage extends BasePage {
    private final String xPathFieldForTextNote = "//*[@class=\"pf-head_itx_a\"]";
    private final String xPathLastNote = "//div[1][@class= 'feed']";


    public NotesPage(){
        isLoaded();
    }


    @Override
    public void isLoaded() {
        $(By.xpath(xPathFieldForTextNote)).shouldBe(Condition.visible.because("Text field not loaded"));
    }

    public Optional<NoteWrapper> getUserLastNote(){
        Optional<NoteWrapper> lastNote = Optional.of(new NoteWrapper($(By.xpath(xPathLastNote))));
        if (lastNote.isPresent()){
            return lastNote;
        } else {
            return Optional.empty();
        }
    }

    public NotesPage sendNote(Note note){
        $(By.xpath(xPathFieldForTextNote)).click();
        note.createNote();
        return this;
    }
}
