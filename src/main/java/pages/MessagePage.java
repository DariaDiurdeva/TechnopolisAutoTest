package pages;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import pages.Wrappers.MessageWrapper;
import org.openqa.selenium.By;

public class MessagePage extends BasePage{

    private final String lineForSearch = "//input[@name='chat-search']";
    private final String lineInputMessage = "//msg-input";
    private final String sendButton = "//*[@data-l=\"t,sendButton\"]//*[@icon=\"send\"]";
    private final String lastReceivedMessage ="//*[@class=\"group\"][last()]//msg-message[not(@mine)][last()]";
    private final String lastMyMessage = "//*[@class=\"group\"][last()]//msg-message[@mine][last()]";

    public MessagePage(){
        isLoaded();
    }

    public MessagePage openDialog(Long id){
        $(By.xpath("//msg-chats-list-item//*[@id='" + id + "']")).click();
        return this;
    }

    public MessagePage sendMessage(String text){
        $(By.xpath(lineInputMessage)).setValue(text);
        $(By.xpath(sendButton)).click();
        return this;
    }

    public MessageWrapper getLastReceivedMessage(){
        MessageWrapper message = new MessageWrapper($(By.xpath(lastReceivedMessage)));
        return message;
    }

    public MessageWrapper getLastMyMessage(){
        MessageWrapper message = new MessageWrapper($(By.xpath(lastMyMessage)));
        return message;
    }

    @Override
    public void isLoaded() {
        $(By.xpath(lineForSearch)).shouldBe(Condition.visible.because("Search fields not displayed"));
    }
}
