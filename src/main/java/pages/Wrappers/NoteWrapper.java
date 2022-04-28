package pages.Wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NoteWrapper {
    private SelenideElement note;
    private By textNote = By.xpath(".//*[contains(@class, 'media-text_cnt_tx')]");
    private By authorGroup = By.xpath(".//*[contains(@class, 'group-link o')]");
    private By authorUser = By.xpath(".//*[contains(@class, 'user-link o')]");
    private By likeButton = By.xpath(".//*[contains(@class,'js-klass-action')]");
    private By activeLike = By.xpath(".//*[@data-react='like']");

    public NoteWrapper(SelenideElement note){
        this.note = note;
    }

    public String getTextNote(){
        return note.$(textNote).getText();
    }

    public String getAuthor(){
        if (note.$(authorGroup).is(Condition.visible)){
            return note.$(authorGroup).getText();
        } else return note.$(authorUser).getText();
    }

    public boolean isLike(){
        return note.$(activeLike).exists();
    }

    public void clickLike(){
        note.$(likeButton).shouldBe(Condition.visible).click();
    }

}
