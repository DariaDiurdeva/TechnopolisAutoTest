package pages.Wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.Note;
import org.openqa.selenium.By;

public class NoteWrapper {
    private SelenideElement note;
    private final String xPathTextNote = ".//*[contains(@class, 'media-text_cnt_tx')]";
    private final String xPathAuthorGroup = ".//*[contains(@class, 'group-link o')]";
    private final String xPathAuthorUser = ".//*[contains(@class, 'user-link o')]";
    private final String xPathLikeButton = ".//*[contains(@class,'js-klass-action')]";
    private final String xPathActiveLike = ".//*[@data-react='like']";

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

    public boolean isLike(){
        return note.$(By.xpath(xPathActiveLike)).exists();
    }

    public NoteWrapper setLike(){
        if (!isLike()) {
            note.$(By.xpath(xPathLikeButton)).shouldBe(Condition.visible).click();
        }
        return this;
    }

    public void deleteLike(){
        if (isLike()){
            note.$(By.xpath(xPathLikeButton)).shouldBe(Condition.visible).click();
        }
    }
}
