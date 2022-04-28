package pages.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.LoginPage;
import pages.MessagePage;
import pages.NotesPage;
import pages.Wrappers.NoteWrapper;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage extends BasePage {

    private By fullName = By.xpath("//*[@id=\"hook_Block_Navigation\"]//*[@class = \"tico ellip\"]");
    private By noteButton = By.xpath("//*[contains(@data-l,'t,userStatuses')]");
    private By notes = By.xpath("//*[contains(@class, 'feed-w')]");
    private By confirmExitButton = By.xpath("//*[@class='form-actions __center']//*[@data-l='t,logout']");

    private String loadError = "Full name not displayed";

    public MainPage(){
        isLoaded();
    }

    public String getName(){
        SelenideElement element = $(fullName);
        return element.getText();
    }

    public MessagePage openMessage(){
        $(MainPageToolbar.MESSAGE.getElement()).click();
        return  new MessagePage();
    }

    public LoginPage exit(){
        $(MainPageToolbar.MINITOOLBAR.getElement()).click();
        $(MainPageToolbar.EXITBUTTON.getElement()).click();
        $(confirmExitButton).click();
        return new LoginPage();
    }

    @Override
    public void isLoaded() {
       $(fullName).shouldBe(Condition.visible.because(loadError));
    }

    public NotesPage openNotesPage(){
        $(noteButton).click();
        return new NotesPage();
    }

    public ArrayList<NoteWrapper> getFeedList() {
        ArrayList<NoteWrapper> feedList = new ArrayList<>();
        for (SelenideElement note : $$(notes)) {
            feedList.add(new NoteWrapper(note));
        }
        return feedList;
    }
}
