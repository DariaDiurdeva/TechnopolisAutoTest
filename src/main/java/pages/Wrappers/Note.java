package pages.Wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.NotesPage;

import static com.codeborne.selenide.Selenide.$;

public class Note {

    //самый простой вариант с текстом и заголовком

    private String head;
    private String text;
    private By optionButton = By.xpath("//*[@class = \"posting_itx_ac_menu\"]");
    private By addHeadButton = By.xpath("//*[@data-action = \"add_header\"]");
    private By textField = By.xpath("//*[contains(@class, 'ok-posting-handler')]");
    private By headField = By.xpath("//*[@data-id = 'adHeader']");
    private By sendButton = By.xpath("//*[@data-l = 't,button.submit']");

    private String buttonError = "Button send not displayed";
    private String textFieldError = "Not exit window note";

    public Note(String head, String text){
        this.head = head;
        this.text = text;
    }

    public Note(String text){
        this.text= text;
    }

    public NotesPage createNote(NotesPage notesPage) {
        if (head != null) {
            $(optionButton).click();
            $(addHeadButton).click();
            $(headField).setValue(head);
        }

        if (text != null) {
            $(textField).setValue(text);
        }

        $(sendButton).shouldBe(Condition.visible.because(buttonError)).click();
        $(textField).shouldNot(Condition.visible.because(textFieldError));
        return notesPage;
    }
}
