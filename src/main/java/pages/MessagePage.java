package pages;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import pages.Wrappers.MessageWrapper;
import org.openqa.selenium.By;

public class MessagePage extends BasePage{

    private By button = By.xpath("//*[@data-l=\"t,sendButton\"]//*[@icon=\"send\"]");
    private By lineForSearch = By.xpath("//input[@name='chat-search']");
    private By lineInputMessage = By.xpath("//msg-input");
    private By lastReceivedMessage = By.xpath("//*[@class=\"group\"][last()]//msg-message[not(@mine)][last()]");
    private By lastMyMessage = By.xpath("//*[@class=\"group\"][last()]//msg-message[@mine][last()]");

    private String loadError = "Search fields not displayed";

    public MessagePage(){
        isLoaded();
    }

    public MessagePage openDialog(Long id){
        String xPathDialog = "//msg-chats-list-item//*[@id= '"+id+"']";
        $(By.xpath(xPathDialog)).click();
        return this;
    }

    public MessagePage sendMessage(String text){
        $(lineInputMessage).setValue(text);
        $(button).click();
        return this;
    }

    public MessageWrapper getLastReceivedMessage(){
        MessageWrapper message = new MessageWrapper($(lastReceivedMessage));
        return message;
    }

    public MessageWrapper getLastMyMessage(){
        MessageWrapper message = new MessageWrapper($(lastMyMessage));
        return message;
    }

    @Override
    public void isLoaded() {
        $(lineForSearch).shouldBe(Condition.visible.because(loadError));
    }
}
