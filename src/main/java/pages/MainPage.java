package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Wrappers.NoteWrapper;
import pages.Wrappers.ToolBarWrapper;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage extends BasePage{

    private final String xPathFullName = "//*[@id=\"hook_Block_Navigation\"]//*[@class = \"tico ellip\"]";
    private final String xPathNoteButton = "//*[contains(@data-l,'t,userStatuses')]";
    private final String xPathNotes = "//*[contains(@class, 'feed-w')]";
    private ToolBarWrapper toolbar = new ToolBarWrapper($(By.xpath("//div[contains(@data-module,'ToolbarManager')]")));

    public MainPage(){
        isLoaded();
    }

    public String getName(){
        SelenideElement element = $(By.xpath(xPathFullName));
        return element.getText();
    }

    public MessagePage openMessage(){
        toolbar.getMessagesPage();
        return  new MessagePage();
    }

    public LoginPage exit(){
        toolbar.exit();
        return new LoginPage();
    }

    @Override
    public void isLoaded() {
       $(By.xpath(xPathFullName)).shouldBe(Condition.visible.because("Full name not displayed"));
    }

    public NotesPage openNotesPage(){
        $(By.xpath(xPathNoteButton)).click();
        return new NotesPage();
    }

    public ArrayList<NoteWrapper> getFeedList() {
        ArrayList<NoteWrapper> feedList = new ArrayList<>();
        for (SelenideElement note : $$(By.xpath(xPathNotes))) {
            feedList.add(new NoteWrapper(note));
        }
        return feedList;
    }
}
