package pages.Wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class MessageWrapper {
    private SelenideElement message;
    private final String xPathMessageText = ".//msg-parsed-text";
    private final String xPathMessageTime = ".//msg-time";
    //Добавить кнопки перслать и тд


    public MessageWrapper(SelenideElement message){
        this.message = message;
    }

    public String getMessageText(){
       return  message.$(By.xpath(xPathMessageText)).getText();
    }
}
