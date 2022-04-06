package pages;
import static com.codeborne.selenide.Selenide.$;

import data.Message;
import org.openqa.selenium.By;

public class MessagePage {

    public MessagePage openDialog(Long id){
        $(By.xpath("//*[@data-item-id='" + id + "']")).click();
        return this;
    }

    public MessagePage sendMessage(Message message){
        $(By.xpath("//*[@data-l=\"t,msgInput\"]")).setValue(message.getText());
        $(By.xpath("//*[@data-l=\"t,sendButton\"]//*[@icon=\"send\"]")).click();
        return this;
    }

    public boolean checkLastMessage(Message message){
        String textMessage = $(By.xpath("//*[@class=\"group\"][last()]//msg-message[not(@mine)][last()]//div/msg-parsed-text")).getText();
        return textMessage.equals(message.getText());
    }
}
