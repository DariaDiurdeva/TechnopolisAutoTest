package pages.Wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NoteWrapper {
    private SelenideElement note;
    private final String xPathTextNote = ".//*[contains(@class, 'media-text_cnt_tx')]";
    private final String xPathAuthorGroup = ".//*[contains(@class, 'group-link o')]";
    private final String xPathAuthorUser = ".//*[contains(@class, 'user-link o')]";

    public NoteWrapper(SelenideElement note){
        this.note = note;
    }

    public String getTextNote(){
        return note.$(By.xpath(xPathTextNote)).getText();
    }

    public String getAuthor(){
        if (note.$(By.xpath(xPathAuthorGroup)).is(Condition.visible)){
            return note.$(By.xpath(xPathAuthorGroup)).getText();
        } else return note.$(By.xpath(xPathAuthorUser)).getText();
    }

}
