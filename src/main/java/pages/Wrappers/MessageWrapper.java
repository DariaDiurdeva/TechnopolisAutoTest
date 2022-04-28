package pages.Wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MessageWrapper {
    private SelenideElement message;
    private By messageText = By.xpath(".//msg-parsed-text");
    //Добавить кнопки перслать и тд

    public MessageWrapper(SelenideElement message){
        this.message = message;
    }

    public String getMessageText(){
       return  message.$(messageText).getText();
    }
}
